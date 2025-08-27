# API Automation with Rest Assured (Banking Demo)

Covers JWT auth (mocked via reqres.in), schema validation, Allure reporting, and GitHub Actions CI.

## Run
```bash
mvn clean test
mvn allure:serve
```

## GitHub Actions
Workflow in `.github/workflows/ci.yml` runs tests and uploads Allure results as artifacts.

## Endpoints
- `POST https://reqres.in/api/login` → mock JWT token
- `GET https://reqres.in/api/users/2` → sample secured resource
- `POST https://httpbin.org/post` → stub for transfer

Add screenshots of Allure and the Actions run to `/screenshots`.
