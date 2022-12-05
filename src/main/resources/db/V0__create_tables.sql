CREATE TABLE IF NOT EXISTS factory(
    name VARCHAR(255) PRIMARY KEY,
    address VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS product(
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    factory_name VARCHAR(255) REFERENCES factory(name) ON UPDATE CASCADE ON DELETE CASCADE,
    count INT NOT NULL
);

