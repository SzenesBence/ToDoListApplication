package hu.nye.spring.core.service;

import hu.nye.spring.core.entity.UserEntity;


public interface IUserService {
    UserEntity getUserById(Long id);
    UserEntity addUser(UserEntity userEntity);
}
