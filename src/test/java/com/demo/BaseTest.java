package com.demo;


import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(profiles = "test")
@SpringBootTest
@Slf4j
public class BaseTest {
    @Value("${flyway.url}")
    protected String flywayUrl;
    @Value("${flyway.user}")
    protected String flywayUser;
    @Value("${flyway.password}")
    protected String flywayPassword;
//    @Value("${flyway.locations}")
//    protected String flywayLocation;

    @BeforeEach
    public void init() {
        Flyway flyway = Flyway.configure().dataSource(flywayUrl, flywayUser, flywayPassword)
//                .locations(flywayLocation)
                .load();
        flyway.clean();
        flyway.migrate();
    }

    @Test
    @DirtiesContext
    public void contextLoads() {
    }

}
