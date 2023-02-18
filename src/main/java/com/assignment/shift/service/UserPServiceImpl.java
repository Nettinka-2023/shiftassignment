package com.assignment.shift.service;

import com.assignment.shift.model.Role;
import com.assignment.shift.model.UserP;
import com.assignment.shift.repository.UserPRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserPServiceImpl implements UserPService {

    private final UserPRepository repository;

    private final RoleServiceImpl roleService;

    private final PasswordEncoder passwordEncoder;

    private String DEFAULT_ROLE = "ROLE_USER";

    public UserP createUser(UserP user) {
        List<Role> roles = Arrays.asList(roleService.getByName(DEFAULT_ROLE));
        user.setRoles(roles);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return save(user);
    }

    public boolean isCoincident(String login) {
        return repository.findByLogin(login) != null ? true : false;
    }

    private UserP save(UserP userP) {
        return repository.save(userP);
    }
}
