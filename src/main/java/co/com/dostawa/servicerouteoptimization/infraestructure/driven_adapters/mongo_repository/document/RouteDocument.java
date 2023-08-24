package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository.document;

import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Delivery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Represents a Route
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "routes")
public class RouteDocument {

    /**
     * Represents primary key from route
     */
    @Id
    private String routeId;
    /**
     * Represents order register day as date
     */
    private String createdAt;
    /**
     * Represents a list of deliveries
     */
    @NotNull
    private List<Delivery> deliveries;
    /**
     * Represents total distance to deliver all orders
     */
    @NotNull
    private float totalDistance;
}
