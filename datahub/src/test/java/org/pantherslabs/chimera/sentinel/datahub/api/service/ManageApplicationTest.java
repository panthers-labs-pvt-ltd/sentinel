package org.pantherslabs.chimera.sentinel.datahub.api.service;

import org.junit.jupiter.api.Test;
import org.pantherslabs.chimera.sentinel.datahub.modal.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

@SpringBootTest
class ManageApplicationTest {

    @Autowired
    private ManageApplication manageApplication;

    @Test
    void createApplication() throws Exception {

        String appName="Test Application for Spark";
        String appDescription = "This application processes real-time financial transactions using Spark and Kafka.";
        String actionType="UPSERT";
        String domainName="finance";
       List<Tag> appTags = List.of(
                        new Tag("tag1", "Tag 1"),
                        new Tag("tag2", "Tag 2")
                );
        // Sample owners
        List<Owners> owners = List.of(
                new Owners("urn:li:corpuser:alice", "DATAOWNER"),
                new Owners("urn:li:corpuser:bob", "DEVELOPER")
        );

        manageApplication.createApplication(appName,appDescription,actionType,domainName,appTags,owners,null);
    }
}