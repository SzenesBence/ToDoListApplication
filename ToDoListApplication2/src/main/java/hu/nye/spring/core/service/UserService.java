package hu.nye.spring.core.service;

import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
@Autowired
    UserRepository userRepository;
@Override
    public UserEntity getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow();
}
@Override
    public UserEntity addUser(UserEntity userEntity){
    return userRepository.save(userEntity);
}
}
