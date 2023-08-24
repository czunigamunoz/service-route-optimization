package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.mongo_repository.document.OrderDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OrderMongoRepository extends MongoRepository<OrderDocument, String> {
    List<Order> findByCreatedAt(String date);
}
