package com.userresource.domain.service;

import com.userresource.application.repository.RoleRepository;
import com.userresource.application.repository.UserRepository;
import com.userresource.domain.model.Role;
import com.userresource.domain.model.User;
import com.userresource.port.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepository userRepo;
    private final RoleRepository roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        log.info("Saving new user to the database");
        user.setPass(passwordEncoder.encode(user.getPass()));
        return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        log.info("Adding role {} to user {}", roleName, userName);
        User user = userRepo.findByUserName(userName);
        Role role = roleRepo.findByName(roleName);
        user.getRoles().add(role);
        userRepo.save(user);
    }

    @Override
    public User getUser(String userName) {
        log.info("Fetching user {} to user {}", userName);
        return userRepo.findByUserName(userName);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUserName(username);
        if (user == null) {
            log.info("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities =
                user.getRoles().stream()
                        .map(it -> new SimpleGrantedAuthority(it.getName())).collect(Collectors.toSet());


        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPass(), authorities);
    }
}
