package com.piyushpriyadarshi.uberApp.services;

import com.piyushpriyadarshi.uberApp.dto.DriverDto;
import com.piyushpriyadarshi.uberApp.dto.SignupDto;
import com.piyushpriyadarshi.uberApp.dto.UserDto;

public interface AuthService {

    String login(String email,String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(Long userId);
}
