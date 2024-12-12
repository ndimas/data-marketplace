# FILE: /data-marketplace-backend/data-marketplace-backend/README.md

# Data Marketplace Backend

This project is an initial Kotlin backend for a data marketplace application designed for internal use by a bank. It is built using Quarkus and provides a simple REST API for managing data products.

## Core Functionality

### Data Product Catalog
- Models data products with the following attributes:
  - `id` (UUID)
  - `name` (String)
  - `description` (String)
  - `category` (String)
  - `provider` (String)
  - `accessLevel` (enum: PUBLIC, INTERNAL, RESTRICTED)
  - `lastUpdated` (LocalDateTime)
- Provides basic CRUD operations (create, read, update, delete) for data products using an in-memory data store.

### User Authentication
- Implements a simplified user authentication mechanism with a single hardcoded user:
  - Username: `admin`
  - Password: `password`
- Uses basic authentication over HTTP.

### API Endpoints
- Built using Quarkus for creating a REST API.
- Available endpoints:
  - `GET /products`: Get all data products.
  - `GET /products/{id}`: Get a single data product by ID.
  - `POST /products`: Create a new data product (requires authentication).
  - `PUT /products/{id}`: Update an existing data product (requires authentication).
  - `DELETE /products/{id}`: Delete a data product (requires authentication).

## Setup
To set up the project, ensure you have the necessary dependencies and configurations as specified in the `build.gradle.kts` and `application.properties` files. 

## Running the Application
You can run the application using the following command:
```
./gradlew run
```

## License
This project is licensed under the MIT License.