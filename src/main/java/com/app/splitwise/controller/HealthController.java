package com.app.splitwise.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.availability.ApplicationAvailability;
import org.springframework.boot.availability.LivenessState;
import org.springframework.boot.availability.ReadinessState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Map;

/**
 * Exposes health probe endpoints used by load balancers and orchestrators.
 * <p>
 * This controller reports an aggregate health status and dedicated liveness/readiness probes
 * derived from Spring Boot {@link ApplicationAvailability}.
 */
@RestController
@RequestMapping("/health")
@Tag(name = "Health", description = "Service health check endpoints")
public class HealthController {

    private final ApplicationAvailability applicationAvailability;
    private final String applicationName;

    /**
     * Creates a health controller bound to the application's availability state.
     *
     * @param applicationAvailability source for liveness and readiness state
     * @param applicationName         configured application name used in API responses
     */
    public HealthController(
            ApplicationAvailability applicationAvailability,
            @Value("${spring.application.name:application}") String applicationName
    ) {
        this.applicationAvailability = applicationAvailability;
        this.applicationName = applicationName;
    }

    /**
     * Returns aggregate service health.
     *
     * @return HTTP 200 when both probes are up; otherwise HTTP 503 with probe details
     */
    @GetMapping
    @Operation(summary = "Overall health", description = "Returns overall service health with readiness and liveness details")
    public ResponseEntity<Map<String, Object>> health() {
        boolean live = applicationAvailability.getLivenessState() == LivenessState.CORRECT;
        boolean ready = applicationAvailability.getReadinessState() == ReadinessState.ACCEPTING_TRAFFIC;
        String status = live && ready ? "UP" : "DOWN";
        HttpStatus httpStatus = status.equals("UP") ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE;

        return ResponseEntity.status(httpStatus).body(Map.of(
                "status", status,
                "service", applicationName,
                "timestamp", ZonedDateTime.now(ZoneOffset.UTC).toString(),
                "checks", Map.of(
                        "liveness", live ? "UP" : "DOWN",
                        "readiness", ready ? "UP" : "DOWN"
                )
        ));
    }

    /**
     * Returns liveness status for process-level health checks.
     *
     * @return HTTP 200 when alive; otherwise HTTP 503
     */
    @GetMapping("/liveness")
    @Operation(summary = "Liveness probe", description = "Indicates whether the app is alive")
    public ResponseEntity<Map<String, Object>> liveness() {
        boolean live = applicationAvailability.getLivenessState() == LivenessState.CORRECT;
        HttpStatus httpStatus = live ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE;

        return ResponseEntity.status(httpStatus).body(Map.of(
                "status", live ? "UP" : "DOWN",
                "probe", "liveness",
                "timestamp", Instant.now().toString()
        ));
    }

    /**
     * Returns readiness status for traffic routing decisions.
     *
     * @return HTTP 200 when ready to accept traffic; otherwise HTTP 503
     */
    @GetMapping("/readiness")
    @Operation(summary = "Readiness probe", description = "Indicates whether the app can serve traffic")
    public ResponseEntity<Map<String, Object>> readiness() {
        boolean ready = applicationAvailability.getReadinessState() == ReadinessState.ACCEPTING_TRAFFIC;
        HttpStatus httpStatus = ready ? HttpStatus.OK : HttpStatus.SERVICE_UNAVAILABLE;

        return ResponseEntity.status(httpStatus).body(Map.of(
                "status", ready ? "UP" : "DOWN",
                "probe", "readiness",
                "timestamp", Instant.now().toString()
        ));
    }
}
