package hu.nye.spring.core;

import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.exception.UserNotFoundException;
import hu.nye.spring.core.repository.UserRepository;
import hu.nye.spring.core.request.UserRequest;
import hu.nye.spring.core.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Before
    public void setUp() {
        // Define the behavior of the userRepository mock
        UserEntity userEntity = new UserEntity();
        userEntity.setId(1L);
        userEntity.setUsername("testUser");
        when(userRepository.findById(1L)).thenReturn(Optional.of(userEntity));
        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);
    }




    @Test
    public void getUserById_UserExists_ShouldReturnUserEntity() {
        // GIVEN
        Long userId = 1L;

        // WHEN
        UserEntity user = userService.getUserById(userId);

        // THEN
        assertEquals(userId, user.getId());
    }
    @Test(expected = UserNotFoundException.class)
    public void getUserById_UserDoesNotExist_ShouldThrowUserNotFoundException() {
        // GIVEN
        Long userId = 2L;

        // WHEN
        userService.getUserById(userId);

        // THEN
        // UserNotFoundException is expected to be thrown
    }

    @Test
    public void addUser_ShouldReturnSavedUserEntity() {
        // GIVEN
        UserRequest userRequest = new UserRequest();
        userRequest.setUsername("testUser");
        userRequest.setPassword("testPassword");

        // WHEN
        UserEntity savedUser = userService.addUser(userRequest);

        // THEN
        assertEquals(userRequest.getUsername(), savedUser.getUsername());
    }

    @Test
    public void deleteUser_UserExists_ShouldDeleteUser() {
        // GIVEN
        Long userId = 1L;
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userId);
        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));

        // WHEN
        userService.deleteUser(userId);

        // THEN
        verify(userRepository).findById(userId);
        verify(userRepository).delete(userEntity);
    }
}



