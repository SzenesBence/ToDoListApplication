package hu.nye.spring.core.service;

import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.exception.UserNotFoundException;
import hu.nye.spring.core.repository.UserRepository;
import hu.nye.spring.core.request.UserRequest;
import hu.nye.spring.core.security.BCrytpHashing;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

@Autowired
    UserRepository userRepository;

    @SneakyThrows
    @Override
    public UserEntity getUserById(Long userId){
        return userRepository.findById(userId).orElseThrow(UserNotFoundException::new);
}
    @Override
    public UserEntity addUser( UserRequest userRequest){
        String hashedPassword = BCrytpHashing.hashPassword(userRequest.getPassword());
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(hashedPassword);
        return userRepository.save(userEntity);
    }

    @Override
    @SneakyThrows
    public void deleteUser(Long userID) {
        UserEntity userEntity = userRepository.findById(userID).orElseThrow(UserNotFoundException::new);
        userRepository.delete(userEntity);
    }
}
