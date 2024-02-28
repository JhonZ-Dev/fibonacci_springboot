package com.example.consumirdor_springboot.controladorjaba;

import com.example.consumirdor_springboot.modelojaba.NumerosModelJaba;
import com.example.consumirdor_springboot.serviciojaba.NumeroSerJaba;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NumeroControllerJaba {

    @Autowired
    private NumeroSerJaba numeroSerJaba;

    @RabbitListener(queues = "JABA_PRIMOS")
    private void recibir(NumerosModelJaba numerosModelJaba){
        log.info("Mensaje del productor ->{}", numerosModelJaba);
        numeroSerJaba.guardar(numerosModelJaba);
    }
}
