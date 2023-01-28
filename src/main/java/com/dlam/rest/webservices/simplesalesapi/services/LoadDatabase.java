package com.dlam.rest.webservices.simplesalesapi.services;

import com.dlam.rest.webservices.simplesalesapi.models.Product;
import com.dlam.rest.webservices.simplesalesapi.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    // This can be done as part of @postcontruct of something, creating a bean for populating data might be probalamatic
    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Product("Chrome Toaster", 100.00)));
            log.info("Preloading " + repository.save(new Product("Copper Kettle", 49.99)));
            log.info("Preloading " + repository.save(new Product("Mixing Bowl", 20.00)));
        };
    }
}
