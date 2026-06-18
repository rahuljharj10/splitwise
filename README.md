# Splitwise

![Build](https://github.com/OWNER/REPO/actions/workflows/build.yml/badge.svg)

A Spring Boot service that powers the Splitwise application. This module exposes health probes and self-documented REST APIs via OpenAPI/Swagger.

## Tech Stack

- Java 21 (toolchain)
- Spring Boot 4.1.x (Web MVC, Actuator availability state)
- springdoc-openapi 2.x (Swagger UI)
- Gradle 9.x (wrapper included)
- Lombok

## Project Layout

```
src/main/java/com/app/splitwise
├── SplitwiseApplication.java        # Spring Boot entry point
├── config/OpenApiConfig.java        # OpenAPI metadata (title, version, license)
└── controller/HealthController.java # /health, /health/liveness, /health/readiness
src/main/resources
└── application.yaml                 # springdoc + actuator probe config
```

## Prerequisites

- JDK 21+ installed (project tested with JDK 25)
- `JAVA_HOME` pointing to a valid JDK installation

If `JAVA_HOME` is not set on Windows PowerShell, set it for the current session:

```powershell
$env:JAVA_HOME = "C:\Program Files\Java\jdk-25.0.3"
```

## Build & Run

Run the application using the Gradle wrapper:

```powershell
.\gradlew.bat bootRun
```

Build a runnable jar:

```powershell
.\gradlew.bat clean bootJar
java -jar build\libs\splitwise-0.0.1-SNAPSHOT.jar
```

Run tests:

```powershell
.\gradlew.bat test
```

The app starts on `http://localhost:8080` by default.

## API Documentation (Swagger / OpenAPI)

Once the app is running, browse the live API docs:

- Swagger UI: http://localhost:8080/swagger-ui.html
- Swagger UI (alt entry): http://localhost:8080/swagger-ui/index.html
- OpenAPI JSON spec: http://localhost:8080/v3/api-docs
- OpenAPI YAML spec: http://localhost:8080/v3/api-docs.yaml

These paths are configured in `src/main/resources/application.yaml` under `springdoc.*`.

## Health Endpoints

The `HealthController` provides probe endpoints suitable for Kubernetes and load balancers.

| Endpoint              | Purpose                                            | Success | Failure |
|-----------------------|----------------------------------------------------|---------|---------|
| `GET /health`         | Aggregate liveness + readiness                     | 200 UP  | 503 DOWN |
| `GET /health/liveness`| Process-level liveness probe                       | 200 UP  | 503 DOWN |
| `GET /health/readiness` | Traffic-routing readiness probe                  | 200 UP  | 503 DOWN |

Sample response (`GET /health`):

```json
{
  "status": "UP",
  "service": "splitwise",
  "timestamp": "2026-06-18T10:15:30Z",
  "checks": {
    "liveness": "UP",
    "readiness": "UP"
  }
}
```

Spring Boot Actuator's built-in probes are also enabled:

- http://localhost:8080/actuator/health
- http://localhost:8080/actuator/health/liveness
- http://localhost:8080/actuator/health/readiness

## Configuration Reference

Key properties in `application.yaml`:

```yaml
spring:
  application:
    name: splitwise

springdoc:
  api-docs:
    path: /v3/api-docs
  swagger-ui:
    path: /swagger-ui.html
    operations-sorter: alpha
    tags-sorter: alpha

management:
  endpoint:
    health:
      probes:
        enabled: true
      show-details: never
  endpoints:
    web:
      exposure:
        include: health,info
  health:
    livenessstate:
      enabled: true
    readinessstate:
      enabled: true
```

## Troubleshooting

- "JAVA_HOME is set to an invalid directory": point `JAVA_HOME` to an installed JDK (see Prerequisites).
- Port 8080 already in use: set `server.port` in `application.yaml` or pass `--server.port=8081` on startup.
- Swagger UI 404: ensure springdoc dependency is on the classpath and visit `/swagger-ui/index.html`.

## License

Apache 2.0

## Continuous Integration

GitHub Actions workflow at `.github/workflows/build.yml` runs on every push to any branch and every pull request:

- Checks out the repo
- Sets up Temurin JDK 21
- Validates the Gradle wrapper
- Runs `./gradlew clean build`
- Uploads test reports and built jars as workflow artifacts

Replace `OWNER/REPO` in the badge URL above with your GitHub repository path.
