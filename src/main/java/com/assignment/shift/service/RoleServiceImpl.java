package com.assignment.shift.service;

import com.assignment.shift.model.Role;
import com.assignment.shift.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public Role getByName(String name) {
        return roleRepository.findByRole(name);
    }
}
