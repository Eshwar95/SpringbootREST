package com.exampleDrugsapi.springbootrestapi.Controller;

import com.exampleDrugsapi.springbootrestapi.Model.Drugs;
import com.exampleDrugsapi.springbootrestapi.Repository.DrugsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DrugsController {

    @Autowired
    private DrugsRepository drugsRepository;

    @PostMapping("/drugs")
    public Drugs addDrugs(@RequestBody Drugs drug) {
        return drugsRepository.save(drug);
    }

    @GetMapping("/getdrugs")
    public ResponseEntity<List<Drugs>> getAllDrugs() {
        return ResponseEntity.ok(drugsRepository.findAll());
    }

    @GetMapping("drugs/{drugId}")
    public ResponseEntity<Drugs> findDrugsById(@PathVariable(value = "drugId") Integer drugId) {
        Drugs drug = drugsRepository.findById(drugId).orElseThrow(
                () -> new ResouceNotFoundException("Drug not found" + drugId));
        return ResponseEntity.ok().body(drug);
    }

    @PutMapping("drugs/{drugId}")
    public ResponseEntity<Drugs> updateDrug(@PathVariable(value = "drugId") Integer drugId,
                                                   @RequestBody Drugs drugDetails) {
        Drugs drug = drugsRepository.findById(drugId)
                .orElseThrow(() -> new ResouceNotFoundException("Drug not found for this id :: " + drugId));
        drug.setName(drugDetails.getName());
        final Drugs updatedEmployee = drugsRepository.save(drug);
        return ResponseEntity.ok(updatedEmployee);
    }

    @DeleteMapping("drugs/{drugId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable(value = "drugId") Integer drugId) {
        Drugs drug = drugsRepository.findById(drugId).orElseThrow(
                () -> new ResouceNotFoundException("Drug not found" + drugId));
        drugsRepository.delete(drug);
        return ResponseEntity.ok().build();
    }


}
