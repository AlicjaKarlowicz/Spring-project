package io.lab.springdatalab.model.user;

import io.lab.springdatalab.model.user.User;
import io.lab.springdatalab.model.user.UserDto;
import io.lab.springdatalab.security.PasswordEncodingConfig;
import org.springframework.context.annotation.Bean;

public class UserDtoBuilder {

    private PasswordEncodingConfig passwordEncodingConfig = new PasswordEncodingConfig();

    @Bean
    public UserDto userToUserDto(User user) {
        return new UserDto(user.getName(), passwordEncodingConfig.passwordEncoder().encode(user.getPassword()),user.getRole());
    }
}
