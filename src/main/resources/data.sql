SELECT product_name FROM orders
WHERE customer_id IN (
    SELECT id FROM customers WHERE LOWER(name) = :name
);