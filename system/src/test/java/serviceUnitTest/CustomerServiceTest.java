package serviceUnitTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.crm.system.entity.Customer;
import com.crm.system.repository.ICustomerRepository;
import com.crm.system.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CustomerServiceTest {

    @Mock
    private ICustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllCustomers() {
        // Arrange
        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");

        Customer customer2 = new Customer();
        customer2.setFirstName("Jane");
        customer2.setLastName("Doe");

        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer1, customer2));

        // Act
        List<Customer> result = customerService.getAllCustomers();

        // Assert
        assertEquals(2, result.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void testGetCustomerById() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");

        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        // Act
        Optional<Customer> result = customerService.getCustomerById(1L);

        // Assert
        assertTrue(result.isPresent());
        assertEquals("John", result.get().getFirstName());
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveCustomer() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");

        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        // Act
        Customer result = customerService.saveCustomer(customer);

        // Assert
        assertNotNull(result);
        assertEquals("John", result.getFirstName());
        verify(customerRepository, times(1)).save(customer);
    }

    @Test
    void testDeleteCustomer() {
        // Act
        customerService.deleteCustomer(1L);

        // Assert
        verify(customerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testGetCustomersByRegion() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setRegion("North");

        when(customerRepository.findByRegion("North")).thenReturn(Arrays.asList(customer));

        // Act
        List<Customer> result = customerService.getCustomersByRegion("North");

        // Assert
        assertEquals(1, result.size());
        assertEquals("North", result.get(0).getRegion());
        verify(customerRepository, times(1)).findByRegion("North");
    }

    @Test
    void testGetCustomersCreatedAfter() {
        // Arrange
        LocalDate date = LocalDate.of(2023, 1, 1);
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setRegistrationDate(LocalDate.of(2023, 2, 1));

        when(customerRepository.findByRegistrationDateAfter(date)).thenReturn(Arrays.asList(customer));

        // Act
        List<Customer> result = customerService.getCustomersCreatedAfter(date);

        // Assert
        assertEquals(1, result.size());
        assertTrue(result.get(0).getRegistrationDate().isAfter(date));
        verify(customerRepository, times(1)).findByRegistrationDateAfter(date);
    }

    @Test
    void testGetCustomerByEmail() {
        // Arrange
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setEmail("john@example.com");

        when(customerRepository.findByEmail("john@example.com")).thenReturn(customer);

        // Act
        Optional<Customer> result = customerService.getCustomerByEmail("john@example.com");

        // Assert
        assertTrue(result.isPresent());
        assertEquals("john@example.com", result.get().getEmail());
        verify(customerRepository, times(1)).findByEmail("john@example.com");
    }
}