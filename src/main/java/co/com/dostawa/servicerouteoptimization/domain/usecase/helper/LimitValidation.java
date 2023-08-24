package co.com.dostawa.servicerouteoptimization.domain.usecase.helper;

import java.util.Optional;

public class LimitValidation {
    public static int getLimit(int limit) {
        int MAX_LIMIT = 100;
        int DEFAULT_LIMIT = 10;
        return limit > 0 && limit < MAX_LIMIT ? limit : DEFAULT_LIMIT;
    }
}
