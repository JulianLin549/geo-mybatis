package com.demo.config;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FlywayConfig {

    @Value("${flyway.url}")
    protected String flywayUrl;
    @Value("${flyway.user}")
    protected String flywayUser;
    @Value("${flyway.password}")
    protected String flywayPassword;

    @PostConstruct
    public void initFlyway() {
        Flyway flyway = Flyway.configure().dataSource(flywayUrl, flywayUser, flywayPassword).load();

        flyway.clean();
        flyway.migrate();
    }

}