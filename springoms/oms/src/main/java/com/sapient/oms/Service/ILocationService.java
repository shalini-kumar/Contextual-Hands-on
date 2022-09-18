package com.sapient.oms.Service;
import java.util.List;

import com.sapient.oms.Entity.Location;

public interface ILocationService {
    List<Location> getValue();
    Location save(Location location);
    void delete(Integer id);
}