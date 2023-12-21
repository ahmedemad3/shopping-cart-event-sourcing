CREATE TABLE cart_event (
    id SERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    event_type VARCHAR(255) NOT NULL,
    event_date TIMESTAMP NOT NULL,
    item_id BIGINT,
    item_name VARCHAR(255),
    quantity INTEGER,
    price DOUBLE PRECISION
);
