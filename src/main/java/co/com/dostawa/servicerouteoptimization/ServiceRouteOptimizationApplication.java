package co.com.dostawa.servicerouteoptimization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServiceRouteOptimizationApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceRouteOptimizationApplication.class, args);
	}

}
