CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    status VARCHAR(255) NOT NULL,
    phone_number BIGINT NOT NULL,
    birth_date DATE,
    address VARCHAR(255)
);

-- Insert sample data
INSERT INTO users (first_name, last_name, email, status, phone_number, birth_date, address)
VALUES ('John', 'Doe', 'john@example.com', 'Active', 1234567890, '1990-01-01', '123 Main St'),
       ('Alice', 'Smith', 'alice@example.com', 'Inactive', 9876543210, '1995-05-15', '456 Elm St');
