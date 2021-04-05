package com.exampleDrugsapi.springbootrestapi.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Drugs extends DrugsAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int drugId;
    private String name;
    private String Provider;

}
