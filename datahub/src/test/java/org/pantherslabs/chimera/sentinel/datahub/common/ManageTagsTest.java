package org.pantherslabs.chimera.sentinel.datahub.common;

import org.pantherslabs.chimera.sentinel.datahub.tag.ManageTags;
import org.junit.jupiter.api.Test;

class ManageTagsTest {
    @Test
    void TagTest() throws Exception {

        String retval= ManageTags.createTags("MANISH","MANISH IS GOOD BOY");
        System.out.println(retval.toString());
    }
}