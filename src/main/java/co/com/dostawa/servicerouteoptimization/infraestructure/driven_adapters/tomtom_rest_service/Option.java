package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.tomtom_rest_service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Option {

    private String departAt;
    private String routeType;
    private String traffic;
    private TravelMode travelMode = TravelMode.truck;
    private Integer vehicleMaxSpeed;
    private Integer vehicleWeight;
    private Integer vehicleAxleWeight;
    private float vehicleLength;
    private float vehicleWidth;
    private float vehicleHeight;
    private boolean vehicleCommercial;
    private String[] vehicleLoadType;
    private String vehicleAdrTunnelRestrictionCode;
    private String[] avoid;
}
