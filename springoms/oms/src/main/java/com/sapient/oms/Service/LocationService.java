package com.sapient.oms.Service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sapient.oms.Entity.Location;
import com.sapient.oms.Repository.LocationRepository;

@Service
public class LocationService implements ILocationService {

    @Autowired
    LocationRepository locationRepository;

    @Override
    @Transactional
    public Location save(Location location) {
        return locationRepository.save(location);
    }

    @Override
    public List<Location> getValue() {
        return locationRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        locationRepository.deleteById(id);
    }
}


