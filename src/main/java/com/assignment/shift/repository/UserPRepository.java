package com.assignment.shift.repository;

import com.assignment.shift.model.UserP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserPRepository extends JpaRepository<UserP, Long> {

    UserP findByLogin(String login);
}
