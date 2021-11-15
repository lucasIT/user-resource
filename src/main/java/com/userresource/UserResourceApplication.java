package com.userresource;

import com.userresource.domain.enumeration.ERole;
import com.userresource.domain.model.Role;
import com.userresource.domain.model.User;
import com.userresource.port.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class UserResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserResourceApplication.class, args);
    }

    /*@Bean
    CommandLineRunner runner(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, ERole.ROLE_USER.name()));
            userService.saveRole(new Role(null, ERole.ROLE_MANAGER.name()));
            userService.saveRole(new Role(null, ERole.ROLE_ADMIN.name()));
            userService.saveRole(new Role(null, ERole.ROLE_SUPER_ADMIN.name()));


            userService.saveUser(new User(null, "John Travolta", "john_travol@gmail.com", "john", "1234", new ArrayList<Role>()));
            userService.saveUser(new User(null, "Will Smith", "will@gmail.com", "will", "1234", new ArrayList<Role>()));
            userService.saveUser(new User(null, "Jim Carry", "jim@gmail.com", "jim", "1234", new ArrayList<Role>()));
            userService.saveUser(new User(null, "Arnold Schwarzenegger", "arnold@gmail.com", "arnold", "1234", new ArrayList<Role>()));

            userService.addRoleToUser("john", ERole.ROLE_USER.name());
            userService.addRoleToUser("john", ERole.ROLE_MANAGER.name());
            userService.addRoleToUser("will", ERole.ROLE_MANAGER.name());
            userService.addRoleToUser("jim", ERole.ROLE_ADMIN.name());
            userService.addRoleToUser("arnold", ERole.ROLE_USER.name());
            userService.addRoleToUser("arnold", ERole.ROLE_MANAGER.name());
            userService.addRoleToUser("arnold", ERole.ROLE_ADMIN.name());
            userService.addRoleToUser("arnold", ERole.ROLE_SUPER_ADMIN.name());
        };
    }
*/
}
