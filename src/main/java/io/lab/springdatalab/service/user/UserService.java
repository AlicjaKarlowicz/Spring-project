package io.lab.springdatalab.service.user;

import io.lab.springdatalab.model.user.User;
import io.lab.springdatalab.model.user.UserDto;

public interface UserService {

    UserDto getUserByName(String name);

    UserDto addUser(User user);

    UserDto isUserValid(User user);
}
