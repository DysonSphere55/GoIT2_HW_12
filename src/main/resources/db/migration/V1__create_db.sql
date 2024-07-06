CREATE TABLE client (
    id IDENTITY PRIMARY KEY,
    name VARCHAR NOT NULL
    CHECK length(name) BETWEEN 3 AND 200
);

CREATE TABLE planet (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR NOT NULL
        CHECK length(name) BETWEEN 1 AND 500
);

CREATE TABLE ticket (
    id IDENTITY PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    client_id BIGINT NOT NULL,
    from_planet_id VARCHAR(10) NOT NULL,
    to_planet_id VARCHAR(10) NOT NULL
);

ALTER TABLE ticket
ADD CONSTRAINT client_id_fk
FOREIGN KEY (client_id) REFERENCES client(id);

ALTER TABLE ticket
ADD CONSTRAINT from_planet_id_client_id_fk
FOREIGN KEY (from_planet_id) REFERENCES planet(id);

ALTER TABLE ticket
ADD CONSTRAINT to_planet_id_client_id_fk
FOREIGN KEY (to_planet_id) REFERENCES planet(id);


