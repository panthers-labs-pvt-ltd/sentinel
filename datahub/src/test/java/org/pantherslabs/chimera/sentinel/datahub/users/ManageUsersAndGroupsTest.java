package org.pantherslabs.chimera.sentinel.datahub.users;

import org.pantherslabs.chimera.sentinel.datahub.modal.Users;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

class ManageUsersAndGroupsTest {

/*    @Test
    void createUsers() throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        List<Users> userInfo = new ArrayList<>();
        Users user = new Users( "Data Engineer", "Manish","Kumar", "Kumar, Manish Gupta", "manish.kumar@natwest.com",null,
                true, "+91", 1L, "Data & Analytics","Manish is a jovial guy", Collections.singletonList("Scala"),
                Collections.singletonList("OBDEF"), "8007464285", "manish.kumar.gupta@outlook.com",Collections.singletonList("UNKNOWN"),
                "https://static.vecteezy.com/system/resources/previews/014/194/219/large_2x/businessman-manager-boss-man-an-office-worker-illustration-flat-design-vector.jpg");

        userInfo.add(user);
        ManageUsersAndGroups.createUsers(userInfo);

    }*/

    @Test
    void createUsersMandatoryValues() throws URISyntaxException, IOException, ExecutionException, InterruptedException {
        List<Users> userList = new ArrayList<>();
        userList.add(new Users("Abhinav", "Kumar", "abhinav.official@gmail.com"));
        userList.add(new Users("Chhaya", "Jain","chhaya.237@gmail.com"));
        userList.add(new Users("Ganesh", "Raj", "ganeshrajaj@gmail.com"));
        userList.add(new Users("Jaycharakula", "K", "jaycharakula.official@gmail.com"));
        userList.add(new Users("Manish Kumar", "Gupta", "manish.kumar.gupta@outlook.com"));
        userList.add(new Users("Mohit", "Ranjan", "mohit.sinha10@gmail.com"));
        userList.add(new Users("Prashant", "Kumar", "prashantkumar.official@gmail.com"));
        userList.add(new Users("sandhya", "salian", "sandhya.rock18@gmail.com"));
        userList.add(new Users("Vivek", "Tiwari", "vivekt1801@gmail.com"));

        ManageUsersAndGroups.createUsers(userList);

    }
}