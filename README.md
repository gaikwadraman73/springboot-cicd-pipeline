# Spring Boot CI/CD Demo

A small Spring Boot 3 / Java 21 REST API with a GitHub Actions pipeline:

```
push / PR ─► build + test (Maven) ─► [main only] Docker build + push to GHCR ─► [optional] deploy
```

## Endpoints
| Path | Description |
|------|-------------|
| `GET /hello?name=Asha` | Returns `{"message":"Hello, Asha!"}` |
| `GET /version` | Returns the `APP_VERSION` env var (default `dev`) |
| `GET /actuator/health` | Health check (used by Docker HEALTHCHECK) |

## Run locally
```bash
mvn spring-boot:run          # or
mvn clean verify && java -jar target/app.jar
```

## Run with Docker
```bash
docker build -t springboot-cicd-demo .
docker run -p 8080:8080 -e APP_VERSION=local springboot-cicd-demo
curl localhost:8080/hello?name=Pune
```

## Set up the pipeline
1. Create a GitHub repo and push this project to `main`.
2. In **Settings → Actions → General → Workflow permissions**, choose *Read and write permissions*.
3. Push a commit. Watch the **Actions** tab: `build-test` runs on every push/PR, `docker` runs on `main` only.
4. The image appears under **Packages** as `ghcr.io/<you>/<repo>:latest` and `:sha-xxxxxxx`.
5. Pull it: `docker run -p 8080:8080 ghcr.io/<you>/<repo>:latest`

## Optional: deploy
Create a repo variable `DEPLOY_ENABLED=true`, a secret `DEPLOY_HOOK_URL` (for example a
Render or Railway deploy hook), and a `production` environment (add required reviewers
for a manual approval gate).

## Ideas to extend
- Add Checkstyle/Spotless, JaCoCo coverage gate
- Add Trivy image scan before push
- Add a Dependabot config for Maven and Actions
