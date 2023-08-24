package co.com.dostawa.servicerouteoptimization.infraestructure.mapper;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Vehicle;
import co.com.dostawa.servicerouteoptimization.domain.models.value_objects.Delivery;
import co.com.dostawa.servicerouteoptimization.domain.usecase.helper.DateFormatter;
import co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.tomtom_rest_service.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Component
public class TomRequestMapper {
    public ObjectRequest toObjectRequest(Order order){
        List<Point> vehicleOrigin = order.getVehicles().stream()
                .map(Vehicle::getAddressLocation)
                .map(address -> new Point(new Coordinates(address.getLatitude(), address.getLongitude())))
                .collect(Collectors.toList());
        List<Point> destinations = order.getDeliveries().stream()
                .map(Delivery::getDeliveryAddress)
                .map(address -> new Point(new Coordinates(address.getLatitude(), address.getLongitude())))
                .collect(Collectors.toList());
        return ObjectRequest.builder()
                .origins(vehicleOrigin)
                .destinations(destinations)
                .options(Option.builder()
                        .departAt(DateFormatter.format())
                        .routeType("fastest")
                        .traffic("live")
                        .travelMode(TravelMode.truck)
                        .vehicleMaxSpeed(90)
                        .vehicleWeight(3500)
                        .vehicleAxleWeight(1000)
                        .vehicleLength(5)
                        .vehicleWidth(2)
                        .vehicleHeight(2.5f)
                        .vehicleCommercial(true)
                        .vehicleLoadType(new String[]{"otherHazmatExplosive", "otherHazmatGeneral"})
                        .vehicleAdrTunnelRestrictionCode("C")
                        .avoid(new String[]{"unpavedRoads"})
                        .build())
                .build();
    }

}
