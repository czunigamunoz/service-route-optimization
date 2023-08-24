package co.com.dostawa.servicerouteoptimization.infraestructure.mapper;

import co.com.dostawa.servicerouteoptimization.domain.models.Route;
import co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository.document.RouteDocument;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {

    public Route toRoute(RouteDocument routeDocument){
        return new Route(
                routeDocument.getRouteId(),
                routeDocument.getCreatedAt(),
                routeDocument.getDeliveries(),
                routeDocument.getTotalDistance()
        );
    }

    public RouteDocument toRouteDocument(Route route){
        return new RouteDocument(
                route.getRouteId(),
                route.getCreatedAt(),
                route.getDeliveries(),
                route.getTotalDistance()
        );
    }
}
