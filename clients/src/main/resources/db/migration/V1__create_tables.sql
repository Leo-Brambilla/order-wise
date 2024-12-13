-- Tabela users
CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       document VARCHAR(100) UNIQUE NOT NULL,
                       email VARCHAR(255) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       is_active BOOLEAN DEFAULT TRUE,
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                       updated_at TIMESTAMP
);

-- Tabela clients
CREATE TABLE clients (
                         id SERIAL PRIMARY KEY,
                         loyalty_points INT DEFAULT 0 NOT NULL,
                         preferred_payment_method_id BIGINT,
                         user_id BIGINT NOT NULL,
                         address_id BIGINT NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP,
                         CONSTRAINT fk_user_client FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

-- Tabela address
CREATE TABLE address (
                         id SERIAL PRIMARY KEY,
                         client_id BIGINT NOT NULL,
                         street VARCHAR(255) NOT NULL,
                         number VARCHAR(50) NOT NULL,
                         complement VARCHAR(255),
                         neighborhood VARCHAR(100) NOT NULL,
                         city VARCHAR(100) NOT NULL,
                         state CHAR(2) NOT NULL,
                         zip_code VARCHAR(20) NOT NULL,
                         type VARCHAR(50) NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                         updated_at TIMESTAMP,
                         CONSTRAINT fk_client_address FOREIGN KEY (client_id) REFERENCES clients(id) ON DELETE CASCADE
);
