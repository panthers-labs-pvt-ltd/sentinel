package org.pantherslabs.chimera.sentinel.datahub.service;

import org.junit.jupiter.api.Test;

class UserSecretServiceTest {

    @Test
    void createSecret() throws Exception {
        UserSecretService SS = new UserSecretService();
        SS.createSecret("NewSecret","MYValue","myDescXXXXXXXXXXXXXXX");
        //SS.getSecretValue("MYNAME");



    }
}