package io.lab.springdatalab.repository;

import io.lab.springdatalab.model.user.UserDto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<UserDto, Long> {

    UserDto findByName(String name);


}
