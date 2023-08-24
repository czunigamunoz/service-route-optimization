package co.com.dostawa.servicerouteoptimization.domain.models.value_objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreationDate {

    private String createdAt;
    private int limit;
}
