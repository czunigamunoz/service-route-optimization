package co.com.dostawa.servicerouteoptimization.domain.models;

import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Delivery;
import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents an Order
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    /**
     * Represents primary key from order
     */
    private String orderId;
    /**
     * Represents order register day as date
     */
    private String createdAt;
    /**
     * Represents a list of deliveries
     */
    private List<Delivery> deliveries;
    /**
     * Represents a list of vehicles
     */
    private List<Vehicle> vehicles;
}
