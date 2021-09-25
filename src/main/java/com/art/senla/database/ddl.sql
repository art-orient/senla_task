DROP database IF EXISTS senla;
CREATE database senla;
USE senla;

CREATE table products (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
price DECIMAL (8, 2) NOT NULL,
status VARCHAR(30) NOT NULL,
created_date TIMESTAMP NOT NULL
);

CREATE INDEX products_name_index ON products (name);
CREATE INDEX products_price_index ON products (price);

CREATE table orders (
 id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
 user_id INTEGER NOT NULL,
 status VARCHAR(30) NOT NULL,
 created_date TIMESTAMP NOT NULL
);

# CREATE table order_items (
# order_id BIGINT,
# product_id BIGINT,
# quantity INTEGER NOT NULL,
# PRIMARY KEY (order_id, product_id),
# FOREIGN KEY (order_id) REFERENCES orders (id),
# FOREIGN KEY (product_id) REFERENCES products(id)
# );

CREATE table user (
id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
email VARCHAR(50) NOT NULL,
password VARCHAR(64) NOT NULL,
);