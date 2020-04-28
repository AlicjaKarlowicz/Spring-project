package io.lab.springdatalab.service.user;

import io.lab.springdatalab.exception.InvalidNameOrPasswordException;
import io.lab.springdatalab.security.PasswordEncodingConfig;
import io.lab.springdatalab.model.user.User;
import io.lab.springdatalab.model.user.UserDto;
import io.lab.springdatalab.model.user.UserDtoBuilder;
import io.lab.springdatalab.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceIml implements UserService{

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDto getUserByName(String name) {

        return userRepo.findByName(name);
    }

    @Override
    public UserDto addUser(User user) {
        UserDtoBuilder builder = new UserDtoBuilder();
        UserDto userDto = builder.userToUserDto(user);
        return userRepo.save(userDto);
    }

    @Override
    public UserDto isUserValid(User user) {

        UserDto userDto = getUserByName(user.getName());
        PasswordEncodingConfig passwordEncodingConfig = new PasswordEncodingConfig();

        if (userDto != null && passwordEncodingConfig.passwordEncoder().matches(user.getPassword(),userDto.getPasswordHash()))
            return userDto;
        else {
            throw new InvalidNameOrPasswordException("Username and password doesn't match to any stored user");
        }

    }
}
