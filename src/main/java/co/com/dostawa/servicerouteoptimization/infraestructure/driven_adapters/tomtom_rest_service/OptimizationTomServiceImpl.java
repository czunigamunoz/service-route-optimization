package co.com.dostawa.servicerouteoptimization.infraestructure.driven_adapters.tomtom_rest_service;

import co.com.dostawa.servicerouteoptimization.domain.models.Order;
import co.com.dostawa.servicerouteoptimization.domain.models.gateways.OptimizationGateway;
import co.com.dostawa.servicerouteoptimization.infraestructure.mapper.TomRequestMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class OptimizationTomServiceImpl implements OptimizationGateway {

    private final Logger LOG = LoggerFactory.getLogger(getClass());
    private final TomRequestMapper tomRequestMapper;

    private final OkHttpClient client;
    private final ObjectMapper mapper;
    @Value("${adapter.tomtom.url}")
    private String url = "";
    @Value("${adapter.tomtom.key}")
    private String apiKey;

    @Override
    public ResponseEntity<HttpStatus> createOrderOptimization(Order order) throws IOException {
        ObjectRequest tomRequest = tomRequestMapper.toObjectRequest(order);
        /*LOG.info("TomRequest: {}", mapper.writeValueAsString(tomRequest));*/
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), mapper.writeValueAsString(tomRequest));
        Request request = new Request.Builder()
                .url(url.concat("/routing/matrix/2?key=").concat(apiKey))
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();
        /*LOG.info(request.toString());*/
        try (Response response = client.newCall(request).execute()) {
            LOG.info(response.toString());
            return response.isSuccessful()
                    ? ResponseEntity.ok().build()
                    : ResponseEntity.badRequest().build();
        } catch (IOException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
