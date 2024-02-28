package com.example.numerosprimosfibonacci.configuracionjaba;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
@Configuration
public class ConfigColasJABA {
    public static final String cola_primos="JABA_PRIMOS";
    public static final String cola_fibonacci_jaba = "JABA_FIBONACCI";

    //DEFINIR LAS RUTAS
    public static final String ROUTINGA_JABA= "jaba-primos";
    public static final String ROUTINGB_JABA= "jaba_fibonacci";

    //definir las colas
    @Bean
    public Queue colanumprimos(){return new Queue(cola_primos,false);}
    @Bean
    public Queue colafibonacci(){return new Queue(cola_fibonacci_jaba, false);}

    //configurar redireccionamiento
    @Bean
    public DirectExchange exchange(){
        return new DirectExchange("exchange-numeros");
    }

    //configuracion de los binding
    @Bean
    public Binding bindingNumPrimos(Queue colanumprimos, DirectExchange exchange){
        return BindingBuilder.bind(colanumprimos).to(exchange).with(ROUTINGA_JABA);
    }
    @Bean
    public Binding bindingNumFibonacci(Queue colafibonacci, DirectExchange exchange){
        return BindingBuilder.bind(colafibonacci).to(exchange).with(ROUTINGB_JABA);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    RabbitTemplate rabbitTemplate(ConnectionFactory factory){
        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }


}
