package serviceUnitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.crm.system.entity.User;
import com.crm.system.repository.IUserRepository;
import com.crm.system.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

public class UserServiceTest {

    @Mock
    private IUserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById_UserExists() {
        // Arrange
        User user = new User();
        user.setId(1L);
        user.setUsername("testuser");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        // Act
        Optional<User> result = userService.getUserById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("testuser", result.get().getUsername());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserById_UserDoesNotExist() {
        // Arrange
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        // Act
        Optional<User> result = userService.getUserById(1L);

        // Assert
        assertFalse(result.isPresent());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveUser_NewUser() {
        // Arrange
        User user = new User();
        user.setUsername("newuser");
        when(userRepository.save(any(User.class))).thenReturn(user);

        // Act
        User savedUser = userService.saveUser(user);

        // Assert
        assertNotNull(savedUser.getCreatedAt());
        assertNotNull(savedUser.getUpdatedAt());
        assertEquals("newuser", savedUser.getUsername());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser() {
        // Arrange
        Long userId = 1L;

        // Act
        userService.deleteUser(userId);

        // Assert
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testGetUsersByRole() {
        // Arrange
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("adminuser");
        user.setRole("ADMIN");
        users.add(user);
        when(userRepository.findByRole("ADMIN")).thenReturn(users);

        // Act
        List<User> result = userService.getUsersByRole("ADMIN");

        // Assert
        assertEquals(1, result.size());
        assertEquals("adminuser", result.get(0).getUsername());
        verify(userRepository, times(1)).findByRole("ADMIN");
    }

    @Test
    void testGetUsersCreatedAfter() {
        // Arrange
        LocalDateTime date = LocalDateTime.now().minusDays(1);
        List<User> users = new ArrayList<>();
        User user = new User();
        user.setUsername("newuser");
        user.setCreatedAt(LocalDateTime.now());
        users.add(user);
        when(userRepository.findByCreatedAtAfter(date)).thenReturn(users);

        // Act
        List<User> result = userService.getUsersCreatedAfter(date);

        // Assert
        assertEquals(1, result.size());
        assertEquals("newuser", result.get(0).getUsername());
        verify(userRepository, times(1)).findByCreatedAtAfter(date);
    }
}