package com.example.consumirdor_springboot.serviciojaba;

import com.example.consumirdor_springboot.modelojaba.NumerosModelJaba;
import com.example.consumirdor_springboot.repositoriojaba.NumerosRepoJaba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NumeroSerJaba {
    @Autowired
    private NumerosRepoJaba numerosRepoJaba;
    public  NumerosModelJaba guardar(NumerosModelJaba numerosModelJaba){
        return numerosRepoJaba.save(numerosModelJaba);
    }
}
