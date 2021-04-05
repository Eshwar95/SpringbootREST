package com.exampleDrugsapi.springbootrestapi.Repository;

import com.exampleDrugsapi.springbootrestapi.Model.Drugs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugsRepository extends JpaRepository<Drugs, Integer> {

}
