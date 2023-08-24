package co.com.dostawa.servicerouteoptimization.infraestructure.entry_points;

import co.com.dostawa.servicerouteoptimization.domain.models.Route;
import co.com.dostawa.servicerouteoptimization.domain.usecase.RouteUseCase;
import co.com.dostawa.servicerouteoptimization.infraestructure.entry_points.helper.ValidateItem;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/routes")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET,RequestMethod.POST})
public class RouteController {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final RouteUseCase routeCase;

    @PostMapping("/new")
    public ResponseEntity<?> create(@Valid @RequestBody Route route, BindingResult result){
        if(result.hasErrors()){
            LOG.info("Error when creating new route.");
            return ValidateItem.validateObject(result);
        }
        try {
            LOG.info("Creating new route.");
            Route _route = routeCase.createRoute(route);
            return ResponseEntity.ok().body(_route);
        } catch (Exception e){
            LOG.info("Internal server error when creating new route.", e);
            return ResponseEntity.internalServerError().build();
        }
    }
}
