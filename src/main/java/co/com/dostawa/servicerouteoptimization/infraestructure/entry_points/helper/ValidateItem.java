package co.com.dostawa.servicerouteoptimization.infraestructure.entry_points.helper;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

public class ValidateItem {

    /**
     * Function to validate object
     * @param result BindingResult object
     * @return ResponseEntity object
     */
    public static ResponseEntity<Map<String, String>> validateObject(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
