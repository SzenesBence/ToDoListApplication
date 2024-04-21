package hu.nye.spring.core.service;

import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.repository.UserRepository;
import hu.nye.spring.core.request.UserRequest;
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
    public UserEntity addUser( UserRequest userRequest){
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(userRequest.getPassword());
        return userRepository.save(userEntity);
    }

    @Override
    public void deleteUser(Long userID) {
        UserEntity userEntity = userRepository.findById(userID).orElseThrow();
        userRepository.delete(userEntity);
    }
}
