package com.sapient.oms.Services;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.sapient.oms.Entity.Location;
import com.sapient.oms.Repository.LocationRepository;
import com.sapient.oms.Service.LocationService;

@ExtendWith(MockitoExtension.class)
public class LocationServiceTest {
    @Mock
    LocationRepository locationRepository;

    @InjectMocks
    LocationService locationService;

    private Location expectedLocation;

    @BeforeEach
    void setup() {
        expectedLocation = new Location();
        expectedLocation.setId(10);
        expectedLocation.setLineAddress("ambattur");
        expectedLocation.setPincode(600077);
        expectedLocation.setCity("chennai");
        expectedLocation.setState("tamil nadu");
        expectedLocation.setCountry("india");
        
    }

    @Test
    void testSaveOrder() {
        Location location = new Location(10, "ambattur", 600077, "chennai", "tamil nadu", "india");
        when(locationRepository.save(any(Location.class))).thenReturn(location);
        Location actualLocation = locationService.save(location);
        assertEquals(expectedLocation.toString(), actualLocation.toString());
    }
}