# Data Marketplace Backend

This is a Kotlin backend for a data marketplace application, built with Quarkus.

## Core Functionality

-   Data Product Catalog: Manages data products with attributes like id, name, description, category, provider, access level, and last updated timestamp.
-   User Authentication: Implements basic authentication with a hardcoded user (admin/password).
-   REST API Endpoints:
    -   `GET /products`: Get all data products.
    -   `GET /products/{id}`: Get a single data product by ID.
    -   `POST /products`: Create a new data product (requires authentication).
    -   `PUT /products/{id}`: Update an existing data product (requires authentication).
    -   `DELETE /products/{id}`: Delete a data product (requires authentication).
    -   `POST /login`: Generate a basic auth header to the application.
-   Error Handling: Returns appropriate HTTP error codes for missing resources, bad requests, etc.

## How to Run the Application

### Locally

1.  Navigate to the `data-marketplace-backend` directory.
2.  Run `./gradlew build` to build the project.
3.  Run `./gradlew quarkusDev` to start the application in development mode.
4.  The application will be available at `http://localhost:8080`.

### Using Docker

1.  Navigate to the `data-marketplace-backend` directory.
2.  Build the Docker image: `docker build -t data-marketplace-backend .`
3.  Run the Docker container: `docker run -p 8080:8080 data-marketplace-backend`
4.  The application will be available at `http://localhost:8080`.

### Replit

The project is configured to run within Replit. Simply import the project and run it. The Dockerfile is configured to expose the correct port.

## API Usage

### Authentication

To access protected endpoints (`POST`, `PUT`, `DELETE`), you need to provide a Basic Authentication header. You can obtain this header by sending a `POST` request to `/login`. The response will contain the header you need to use in subsequent requests.

Example:

1.  Send a `POST` request to `/login`.
2.  Copy the `Authorization` header from the response.
3.  Include the `Authorization` header in subsequent requests to protected endpoints.

## Project Structure

-   `src/main/kotlin/com/example/model`: Contains the `DataProduct` data class.
-   `src/main/kotlin/com/example/repository`: Contains the `DataProductRepository` for data access.
-   `src/main/kotlin/com/example/service`: Contains the `AuthenticationService` for authentication.
-   `src/main/kotlin/com/example/resource`: Contains the `DataProductResource` for REST API endpoints.
-   `src/main/resources`: Contains the `application.properties` file and the `index.html` file.
-   `build.gradle.kts`: Gradle build file.
-   `settings.gradle.kts`: Gradle settings file.
-   `Dockerfile`: Dockerfile for containerization.
