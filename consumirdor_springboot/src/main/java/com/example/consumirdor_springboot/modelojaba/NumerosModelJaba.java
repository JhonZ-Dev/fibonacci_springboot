package com.example.consumirdor_springboot.modelojaba;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Entity
public class NumerosModelJaba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero_jaba;

    public NumerosModelJaba(){

    }
    public NumerosModelJaba(int numero_jaba) {
        this.numero_jaba = numero_jaba;
    }
}
