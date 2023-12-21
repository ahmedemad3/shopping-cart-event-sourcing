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

## Get Customer Cart with Aggregations

```http
  - **Endpoint:** GET /carts/aggregation/{customerId}
  - **Method:** GET
  Retrieves the customer's cart with aggregations, including total quantity and price.

  Parameters
  customerId (path): The ID of the customer.
 - **Output:**
  200 OK with the customer's cart and aggregations.
  404 Not Found if the customer or cart is not found.

### Get Customer Cart with Denormalization
```http
 - **Endpoint:** GET /carts/{customerId}
 - **Method:** GET
Retrieves the customer's cart without aggregations.

  Parameters
  customerId (path): The ID of the customer.
 - **Output:**
  200 OK with the customer's cart.
  404 Not Found if the customer or cart is not found.

## Notes

- This is a basic example, and you may need to customize the logic based on your business rules and requirements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

Feel free to adjust the content based on your project's specific details, including more information about the purpose of the project, prerequisites, dependencies, and any additional features or configurations.
