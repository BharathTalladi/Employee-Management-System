package com.learning.employeemanagement.service;

import com.learning.employeemanagement.dto.UserRegistrationDto;
import com.learning.employeemanagement.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto userRegistrationDto);

    User findUserByEmail(String email);
}
