CREATE TABLE CUSTOMERS
(
    id SERIAL PRIMARY KEY,
    name varchar(255),
    surname varchar(255),
    age INTEGER,
    phone_number varchar(255)
);
CREATE TABLE ORDERS
(
    id SERIAL PRIMARY KEY,
    date date,
    customer_id INTEGER,
    product_name varchar(255),
    amount INTEGER,
    FOREIGN KEY(customer_id) REFERENCES CUSTOMERS(id)
);