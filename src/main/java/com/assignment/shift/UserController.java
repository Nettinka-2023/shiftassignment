package com.assignment.shift;

import com.assignment.shift.model.UserP;
import com.assignment.shift.service.UserPServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserPServiceImpl userPService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<String> saveUser(@RequestBody UserP user) {
        try {
            if (userPService.isCoincident(user.getLogin()))
                return new ResponseEntity<>("Пользователь с таким именем уже существует", HttpStatus.CONFLICT);
            return new ResponseEntity<>("Пользователь " + userPService.createUser(user).getUsername()
                    + " успешно создан", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Server error. Try again.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
