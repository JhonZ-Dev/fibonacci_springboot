package com.example.numerosprimosfibonacci.controladorjaba;

import com.example.numerosprimosfibonacci.configuracionjaba.ConfigColasJABA;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/colas_jaba")
public class ControllerJABA {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private DirectExchange exchange;

    @PostMapping("/generar")
    public void generarNumeros() {
        for (int i = 1; i <= 100; i++) {
            if (esPrimo(i)) {
                enviarMensaje(i, ConfigColasJABA.ROUTINGA_JABA);
            }
            if (esFibonacci(i)) {
                enviarMensaje(i, ConfigColasJABA.ROUTINGB_JABA);
            }
        }
    }

    private boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private boolean esFibonacci(int num) {
        int a = 0, b = 1, c;
        if (num == 0) {
            return true;
        }
        while (b < num) {
            c = a + b;
            a = b;
            b = c;
        }
        return b == num;
    }

    private void enviarMensaje(int num, String routingKey) {
        rabbitTemplate.convertAndSend(exchange.getName(), routingKey, num);
    }

}
