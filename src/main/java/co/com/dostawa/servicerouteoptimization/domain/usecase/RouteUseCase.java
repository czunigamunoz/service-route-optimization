package co.com.dostawa.servicerouteoptimization.domain.usecase;

import co.com.dostawa.servicerouteoptimization.domain.models.Route;
import co.com.dostawa.servicerouteoptimization.domain.models.gateways.RouteRepository;
import co.com.dostawa.servicerouteoptimization.domain.usecase.helper.DateFormatter;
import co.com.dostawa.servicerouteoptimization.domain.usecase.helper.LimitValidation;
import lombok.RequiredArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class RouteUseCase {


    private final RouteRepository routeRepository;

    /**
     * Save new route
     *
     * @param route Route object
     * @return Route object created
     */
    public Route createRoute(Route route) {
        try {
            route.setCreatedAt(DateFormatter.format());
            return routeRepository.create(route);
        } catch (Exception e) {
            throw new RuntimeException("Error creating route");
        }
    }

    /**
     * Get route by id
     *
     * @param id String
     * @return Route object
     */
    public Optional<Route> getRoute(String id) {
        try {
            return routeRepository.findById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error getting route");
        }
    }

    /**
     * Returns routes by date
     * @param date Date object
     * @return List of routes
     */
    public List<Route> getRoutesByDate(String date, int limit) {
        try {
            int limitDefault = LimitValidation.getLimit(limit);
            return routeRepository.findRoutesByDate(date, limitDefault);
        } catch (Exception e) {
            throw new RuntimeException("Error getting routes");
        }
    }
}
