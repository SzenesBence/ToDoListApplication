package hu.nye.spring.core.service;

import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.request.UserRequest;


public interface IUserService {
    UserEntity getUserById(Long userId);
    UserEntity addUser(UserRequest userRequest);

}
