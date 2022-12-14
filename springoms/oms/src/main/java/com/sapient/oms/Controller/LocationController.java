package com.sapient.oms.Controller;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.oms.Entity.Location;
import com.sapient.oms.Service.LocationService;

@CrossOrigin
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired  //dependecny injection
    LocationService locationService;// never create object

    @GetMapping
    List<Location> getLocations() {
        return locationService.getValue();
    }

    @PostMapping
    void save(@Valid @RequestBody Location location) {
        locationService.save(location);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") Integer id){
        locationService.delete(id);
}
}