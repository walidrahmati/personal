CREATE TABLE user_roles (
    user_role_id SERIAL PRIMARY KEY,
    user_role_name TEXT UNIQUE NOT NULL
);

CREATE TABLE reimb_types (
    reimb_type_id SERIAL PRIMARY KEY,
    reimb_type_name TEXT UNIQUE NOT NULL
);

CREATE TABLE reimbs (
    reimb_id SERIAL PRIMARY KEY,
    reimb_amount DECIMAL(7, 2) NOT NULL,
    reimb_submitted TIMESTAMP DEFAULT NOW(),
    reimb_resolved TIMESTAMP,
    reimb_description TEXT,
    reimb_receipt_url TEXT,
    reimb_is_approved BOOL DEFAULT NULL,
    reimb_type_id_fk INT REFERENCES reimb_types(reimb_type_id),
    reimb_author_id_fk INT REFERENCES users(user_id),
    reimb_resolver_id_fk INT REFERENCES users(user_id)
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    username TEXT UNIQUE NOT NULL,
    PASSWORD TEXT NOT NULL,
    user_first_name TEXT NOT NULL,
    user_last_name TEXT NOT NULL,
    user_email TEXT UNIQUE NOT NULL,
    user_role_id_fk INT REFERENCES user_roles(user_role_id)
);

SELECT * FROM users;

SELECT * FROM reimbs;

SELECT * FROM reimb_types;

INSERT INTO user_roles (user_role_id, user_role_name) VALUES (1, 'Admin');
INSERT INTO users (user_id, username, PASSWORD, user_first_name, user_last_name, user_email, user_role_id_fk) VALUES (1, 'Max','pass', 'Walid', 'Rahmati', 'somethingemail', 1);
INSERT INTO reimb_types (reimb_type_id, reimb_type_name) VALUES (1, 'Certificate'), (2, 'Rent'), (3, 'Personal');