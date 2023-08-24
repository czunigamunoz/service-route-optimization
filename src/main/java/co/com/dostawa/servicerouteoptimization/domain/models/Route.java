package co.com.dostawa.servicerouteoptimization.domain.models;

import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Delivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a Route
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Route {

    /**
     * Represents primary key from route
     */
    private String routeId;
    /**
     * Represents order register day as date
     */
    private String createdAt;
    /**
     * Represents a list of deliveries
     */
    private List<Delivery> deliveries;
    /**
     * Represents total distance to deliver all orders
     */
    private float totalDistance;
}
