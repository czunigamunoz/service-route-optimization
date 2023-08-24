package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.tomtom_rest_service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class ObjectRequest {

    private List<Point> origins;
    private List<Point> destinations;
    private Option options;
}
