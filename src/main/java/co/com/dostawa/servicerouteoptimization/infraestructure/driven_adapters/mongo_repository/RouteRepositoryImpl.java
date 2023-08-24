package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository;

import co.com.dostawa.servicerouteoptimization.domain.models.Route;
import co.com.dostawa.servicerouteoptimization.domain.models.gateways.RouteRepository;
import co.com.dostawa.servicerouteoptimization.infraestructure.mapper.RouteMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RouteRepositoryImpl implements RouteRepository {

    private final RouteMapper routeMapper;
    private final RouteMongoRepository routeRepository;
    @Override
    public Route create(Route route) {
        return routeMapper.toRoute(routeRepository.save(routeMapper.toRouteDocument(route)));
    }

    @Override
    public Optional<Route> findById(String id) {
        return routeRepository.findById(id).map(routeMapper::toRoute);
    }

    @Override
    public List<Route> findRoutesByDate(String date, int limit) {
        return routeRepository.findByCreatedAt(date);
    }
}
