CREATE TABLE roles (id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(255));

CREATE TABLE users (id INT PRIMARY KEY AUTO_INCREMENT, login VARCHAR(45), password VARCHAR(60),
                    first_name VARCHAR(45), last_name VARCHAR(45),
                    email VARCHAR(45), phone VARCHAR(20));

CREATE TABLE users_roles(user_id INT NOT NULL, role_id INT NOT NULL,
                         PRIMARY KEY (user_id, role_id));