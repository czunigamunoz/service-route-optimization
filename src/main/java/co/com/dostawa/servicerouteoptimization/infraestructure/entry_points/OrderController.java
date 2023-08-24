package co.com.dostawa.servicerouteoptimization.infraestructure.entry_points;

import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.CreationDate;
import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import co.com.dostawa.servicerouteoptimization.domain.usecase.OrderUseCase;
import co.com.dostawa.servicerouteoptimization.infraestructure.entry_points.helper.ValidateItem;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class OrderController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final OrderUseCase orderCase;

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody Order order, BindingResult result){
        if(result.hasErrors()){
            LOG.info("Error when creating new order.");
            return ValidateItem.validateObject(result);
        }
        try {
            LOG.info("Creating new order.");
            Order _order = orderCase.createOrder(order);
            return new ResponseEntity<>(_order, HttpStatus.CREATED);
        } catch (Exception e){
            LOG.info("Internal server error when creating new order.", e);
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping ("/date/limit")
    public ResponseEntity<?> getOrders(@Valid @RequestBody CreationDate creationDate, BindingResult result){
        if(result.hasErrors()){
            LOG.info("Error when getting orders.");
            return ValidateItem.validateObject(result);
        }
        try {
            LOG.info("Getting orders.");
            return ResponseEntity.ok().body(orderCase.getOrdersByDate(creationDate.getCreatedAt(), creationDate.getLimit()));
        } catch (Exception e){
            LOG.info("Internal server error when getting orders.", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
