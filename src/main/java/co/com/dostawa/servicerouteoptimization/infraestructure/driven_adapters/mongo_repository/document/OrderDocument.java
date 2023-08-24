package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository.document;

import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Delivery;
import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Represents an Order
 * @version 1.0
 * @author czm
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "orders")
public class OrderDocument {

    /**
     * Represents primary key from order
     */
    @Id
    private String orderId;
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
     * Represents a list of vehicles
     */
    @NotNull
    private List<Vehicle> vehicles;
}
