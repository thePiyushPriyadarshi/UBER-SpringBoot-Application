package com.piyushpriyadarshi.uberApp.services.impl;

import com.piyushpriyadarshi.uberApp.dto.DriverDto;
import com.piyushpriyadarshi.uberApp.dto.SignupDto;
import com.piyushpriyadarshi.uberApp.dto.UserDto;
import com.piyushpriyadarshi.uberApp.entities.Driver;
import com.piyushpriyadarshi.uberApp.entities.User;
import com.piyushpriyadarshi.uberApp.entities.enums.Role;
import com.piyushpriyadarshi.uberApp.exceptions.ResourceNotFoundException;
import com.piyushpriyadarshi.uberApp.exceptions.RuntimeConflictException;
import com.piyushpriyadarshi.uberApp.repositories.UserRepository;
import com.piyushpriyadarshi.uberApp.services.AuthService;
import com.piyushpriyadarshi.uberApp.services.DriverService;
import com.piyushpriyadarshi.uberApp.services.RiderService;
import com.piyushpriyadarshi.uberApp.services.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final RiderService riderService;
    private final WalletService walletService;
    private final DriverService driverService;

    @Override
    public String login(String email, String password){
        return "";
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {

        User alreadyExist = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(alreadyExist !=null){
                throw new RuntimeConflictException("User already exist with same email "+ signupDto.getEmail());
        }


        User user = modelMapper.map(signupDto,User.class);
        user.setRoles(Set.of(Role.RIDER));
        User saverUser = userRepository.save(user);

        // create User related entities
        riderService.createNewRider(saverUser);

        // add wallet
        walletService.createNewWallet(saverUser);

        return modelMapper.map(saverUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(Long userId,String vehicleId) {
        User user = userRepository.findById(userId).orElseThrow(()->
                new ResourceNotFoundException("User is not found with id : "+userId));

        if(user.getRoles().contains(Role.DRIVER)){
            throw new RuntimeConflictException("User with id "+userId + "is already a Driver");
        }

        Driver driver = Driver.builder()
                .user(user)
                .rating(0.0)
                .available(true)
                .vehicleId(vehicleId)
                .build();

        user.getRoles().add(Role.DRIVER);
        userRepository.save(user);

        return modelMapper.map(driverService.createNewDriver(driver),DriverDto.class);
    }
}
