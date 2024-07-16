package com.flyway.config;

import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.output.RepairResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlyWayConfig {
    @Autowired
    private Flyway flyway;

   /* @Bean
    public RepairResult repair() {
        return flyway.repair();
    }*/

    @Bean
    public FlywayMigrationStrategy repairFlyway() {
        return flyway -> {
            flyway.repair(); // Repair the Flyway schema history table
            flyway.migrate(); // Run the migrations
        };
    }
}
