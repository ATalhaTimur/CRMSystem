package ControllerUnitTest;

import com.crm.system.controller.UserController;
import com.crm.system.entity.User;
import com.crm.system.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetAllUsers() throws Exception {
        // Arrange
        User user1 = new User();
        user1.setUsername("john_doe");

        User user2 = new User();
        user2.setUsername("jane_doe");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        // Act & Assert
        mockMvc.perform(get("/api/users")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("john_doe"))
                .andExpect(jsonPath("$[1].username").value("jane_doe"));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    public void testGetUserById() throws Exception {
        // Arrange
        User user = new User();
        user.setUsername("john_doe");

        when(userService.getUserById(1L)).thenReturn(Optional.of(user));

        // Act & Assert
        mockMvc.perform(get("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("john_doe"));

        verify(userService, times(1)).getUserById(1L);
    }

    @Test
    public void testSaveUser() throws Exception {
        // Arrange
        User user = new User();
        user.setUsername("john_doe");

        when(userService.saveUser(any(User.class))).thenReturn(user);

        // Act & Assert
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"john_doe\", \"password\": \"password123\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("john_doe"));

        verify(userService, times(1)).saveUser(any(User.class));
    }

    @Test
    public void testGetUsersByRole() throws Exception {
        // Arrange
        User user = new User();
        user.setUsername("admin_user");
        user.setRole("ADMIN");

        when(userService.getUsersByRole("ADMIN")).thenReturn(Arrays.asList(user));

        // Act & Assert
        mockMvc.perform(get("/api/users/role/ADMIN")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("admin_user"))
                .andExpect(jsonPath("$[0].role").value("ADMIN"));

        verify(userService, times(1)).getUsersByRole("ADMIN");
    }

    @Test
    public void testGetUsersCreatedAfter() throws Exception {
        // Arrange
        LocalDateTime date = LocalDateTime.of(2023, 1, 1, 0, 0);
        User user = new User();
        user.setUsername("new_user");
        user.setCreatedAt(LocalDateTime.of(2023, 2, 1, 0, 0));

        when(userService.getUsersCreatedAfter(date)).thenReturn(Arrays.asList(user));

        // Act & Assert
        mockMvc.perform(get("/api/users/created-after/2023-01-01T00:00:00")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value("new_user"));

        verify(userService, times(1)).getUsersCreatedAfter(any(LocalDateTime.class));
    }
}