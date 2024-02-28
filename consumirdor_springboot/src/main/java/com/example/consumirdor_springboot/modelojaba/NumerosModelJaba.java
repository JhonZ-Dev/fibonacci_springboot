package com.example.consumirdor_springboot.modelojaba;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class NumerosModelJaba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero_jaba;
}
