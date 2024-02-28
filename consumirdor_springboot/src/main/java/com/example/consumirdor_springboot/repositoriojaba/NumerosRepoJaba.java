package com.example.consumirdor_springboot.repositoriojaba;

import com.example.consumirdor_springboot.modelojaba.NumerosModelJaba;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumerosRepoJaba extends JpaRepository<NumerosModelJaba, Long> {
}
