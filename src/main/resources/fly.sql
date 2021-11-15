CREATE DATABASE FLY;

CREATE SCHEMA fl;

CREATE TABLE fl.user
(
    id        int          NOT NULL,
    name      varchar(255) NOT NULL,
    user_name varchar(255) NOT NULL,
    pass_word varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE fl.role
(
    id   int          NOT NULL,
    name varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE fl.user_role
(
    id      int NOT NULL,
    id_user int NOT NULL,
    id_role int NOT NULL,
    PRIMARY KEY (id),

    FOREIGN KEY (id_user) REFERENCES fl.user (id)
        ON DELETE CASCADE,
    FOREIGN KEY (id_role) REFERENCES fl.role (id)
        ON DELETE CASCADE
);