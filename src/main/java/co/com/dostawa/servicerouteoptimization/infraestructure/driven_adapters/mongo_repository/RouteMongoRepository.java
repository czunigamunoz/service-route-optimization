package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository;

import co.com.dostawa.servicerouteoptimization.domain.models.Route;
import co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository.document.RouteDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RouteMongoRepository extends MongoRepository<RouteDocument, String> {
    List<Route> findByCreatedAt(String date);
}
