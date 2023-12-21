```markdown
# Event Sourcing Shopping Cart Application

This Java Spring Boot application demonstrates an implementation of event sourcing for a shopping cart with a PostgreSQL DB table.

## 1st Chronological Reductions with java code

## 2nd Denormalization Technique

In the context of this project, denormalization refers to the process of simplifying data retrieval by storing redundant copies of certain information. It is particularly useful when dealing with read-heavy workloads, as it optimizes query performance at the expense of some redundancy in the data.

### Denormalized Table

A denormalized table is used to aggregate and store cart-related events, making it easier and faster to query the current state of a shopping cart. The denormalized table is designed to reduce the need for complex joins and calculations when retrieving cart information.

### Benefits

1. **Improved Query Performance**: Denormalization reduces the need for joins and aggregations during read operations, leading to faster query execution.

2. **Simplified Query Logic**: With denormalized data, the query logic becomes simpler, as the necessary information is readily available in a single table.

3. **Efficient Retrieval of Latest State**: The chronological reduction process is facilitated by the denormalized table, enabling efficient retrieval of the latest state of a shopping cart.

### Considerations

While denormalization offers performance benefits for read operations, it comes with the trade-off of increased storage space and the need for careful management to keep redundant data consistent.



## Project Structure

The project is organized as follows:

- `src/main/java`: Java source code.
  - `com.example.cartservice`: Main package for the cart service.
    - `CartEvent`: Entity representing events related to the cart.
    - `Cart`: Class handling the state of the cart and logic for processing events.
    - `CartItem`: Class for cartItems in Cart class.
    - `CartEventController`: REST controller for handling cart events.
    - `CartEventService`: Service layer for managing cart events.
  - Other packages and classes for supporting the application.

- `src/main/resources`: Configuration files and resources.
  - `application.properties`: Application configuration.

- `pom.xml`: Maven project configuration.

## Getting Started

Follow these steps to run the project locally:

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/event-sourcing-cart.git
   ```

2. Navigate to the project directory:

   ```bash
   cd event-sourcing-cart
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

The application will start, and you can access the API at `http://localhost:8080`.

## API Endpoints

### Add Cart Event

- **Endpoint:** `/api/v1/cart/{customerId}/events`
- **Method:** POST
- **Input:**
  ```json
  {
    "eventType": "ADD_TO_CART",
    "eventDate": "2023-11-19T12:30:00Z",
    "itemId": 123,
    "itemName": "Example Item",
    "quantity": 2,
    "price": 19.99
  }
  ```
- **Output:** Status code `201` (Created)

Certainly! Below are the additions for the README file to document the new APIs:

```markdown
# Shopping Cart Event Source Project

...

## APIs

### Get Customer Cart with Aggregations

Retrieve a customer's cart with aggregations, including calculated quantities and prices.

**Endpoint:**
```HTTP
GET /api/v1/carts/aggregation/{customerId}
```

**Response:**
- HTTP Status 200 OK: Returns the customer's cart with aggregations.
- HTTP Status 404 Not Found: If the customer's cart is not found.

### Get Customer Cart

Retrieve a customer's cart without aggregations.

**Endpoint:**
```HTTP
GET /api/v1/carts/{customerId}
```

**Response:**
- HTTP Status 200 OK: Returns the customer's cart.
- HTTP Status 404 Not Found: If the customer's cart is not found.

...

Feel free to explore these APIs and adapt them based on your specific needs. The provided endpoints allow you to retrieve a customer's cart with and without aggregations, providing flexibility based on the use case.
```
# Shopping Cart Event Source Project

## Database Scripts
-- this path src\main\resources\DB_script have the following scripts

### Update Cart Item Function

Run the following SQL script to create the `update_cart_item` function:

```SQL
-- update_cartitem_fn.sql
-- This script creates the 'update_cart_item' function.

### Database Creation Script

Run the following SQL script to create the necessary tables for the project:

```SQL
-- db-create.sql
-- This script creates the required database tables.

Ensure that you execute the scripts in the specified order for the correct setup of the database tables and functions.

...

Feel free to adapt the script names and content based on your specific database setup and requirements.
```

These additions provide documentation for running the database scripts in the correct order. Adjust the script names and content as needed for your project.

## Notes

- This is a basic example, and you may need to customize the logic based on your business rules and requirements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

Feel free to adjust the content based on your project's specific details, including more information about the purpose of the project, prerequisites, dependencies, and any additional features or configurations.
