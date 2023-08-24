package co.com.dostawa.servicerouteoptimization.domain.models.gateways;

import co.com.dostawa.servicerouteoptimization.domain.models.Route;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface RouteRepository {

    /**
     * Save new route
     * @param route Route object
     */
    Route create(Route route);
    /**
     * Get route by id
     * @param id String
     * @return Route object
     */
    Optional<Route> findById(String id);
    /**
     * Returns routes by date
     * @param dateStr String date in format String
     * @return List of routes
     */
    List<Route> findRoutesByDate(String dateStr, int limit);
}
