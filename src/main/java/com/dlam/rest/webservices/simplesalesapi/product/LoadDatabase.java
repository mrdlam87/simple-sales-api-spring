package com.dlam.rest.webservices.simplesalesapi.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Product("Chrome Toaster", 100.00)));
            log.info("Preloading " + repository.save(new Product("Copper Kettle", 49.99)));
            log.info("Preloading " + repository.save(new Product("Mixing Bowl", 20.00)));
        };
    }
}
