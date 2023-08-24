package co.com.dostawa.servicerouteoptimization.domain.models.value_objects;

import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    private int vehicleCapacity;
    private Address addressLocation;
    private boolean available;
}
