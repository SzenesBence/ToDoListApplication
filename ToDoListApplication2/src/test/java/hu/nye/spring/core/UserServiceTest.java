package hu.nye.spring.core;
import hu.nye.spring.core.entity.UserEntity;
import hu.nye.spring.core.exception.UserNotFoundException;
import hu.nye.spring.core.repository.TodoRepository;
import hu.nye.spring.core.repository.UserRepository;
import hu.nye.spring.core.request.TodoRequest;
import hu.nye.spring.core.request.UserRequest;
import hu.nye.spring.core.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void getUserById_UserExists_ShouldReturnUserEntity() {
        // GIVEN
        Long userId = 1L;
UserEntity userEntity= new UserEntity();
        when(userRepository.findById(userId)).thenReturn(Optional.of(userEntity));
        // WHEN
        UserEntity result = userService.getUserById(userId);

        // THEN
        verify(userRepository).findById(userId);
        assertEquals(userEntity, result);
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

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequest.getUsername());
        userEntity.setPassword(userRequest.getPassword());

        when(userRepository.save(any(UserEntity.class))).thenReturn(userEntity);

        // WHEN
        UserEntity savedUserEntity = userService.addUser(userRequest);

        // THEN
        assertNotNull(savedUserEntity);
        assertEquals(userRequest.getUsername(), savedUserEntity.getUsername());
        assertEquals(userRequest.getPassword(), savedUserEntity.getPassword());
        verify(userRepository).save(any(UserEntity.class));
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