package org.fleshframework.experiments.boot;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
public class App implements CommandLineRunner
{
    public static void main(final String[] args)
    {
        SpringApplication.run(App.class, args);
    }
    
    @Autowired
    RabbitTemplate template;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sleeping.");
        Thread.sleep(10000);
        System.out.println("Done Sleeping.");
        
        template.convertAndSend("flesh.time-shift.fan", "", "1000");
        Thread.sleep(10000);
    }
}
