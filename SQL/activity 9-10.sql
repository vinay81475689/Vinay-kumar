-- Create the customers table
create table customers (
    customer_id int primary key, customer_name varchar(32),
    city varchar(20), grade int, salesman_id int);

-- Insert values into it
INSERT ALL
    INTO customers VALUES (3002, 'Nick Rimando', 'New York', 100, 5001)
    INTO customers VALUES (3007, 'Brad Davis', 'New York', 200, 5001)
    INTO customers VALUES (3005, 'Graham Zusi', 'California', 200, 5002)
    INTO customers VALUES (3008, 'Julian Green', 'London', 300, 5002)
    INTO customers VALUES (3004, 'Fabian Johnson', 'Paris', 300, 5006)
    INTO customers VALUES (3009, 'Geoff Cameron', 'Berlin', 100, 5003)
    INTO customers VALUES (3003, 'Jozy Altidor', 'Moscow', 200, 5007)
    INTO customers VALUES (3001, 'Brad Guzan', 'London', 300, 5005)
SELECT 1 FROM DUAL;

select * from customers;

select s.salesman_name, c.customer_name
from salesman s INNER JOIN customers c on s.salesman_id=c.salesman_id

select c.customer_name, s.salesman_name
from salesman s inner join customers c on s.salesman_id=s.salesman_id
where s.grade<=300;

select c.customer_name
from customers c inner join salesman s on c.salesman_id=s.salesman_id
where s.COMMISSION>12;


SELECT a.order_no, a.order_date, a.purchase_amount, b.customer_name AS "Customer Name", b.grade, c.salesman_name AS "Salesman", c.commission FROM orders a 
INNER JOIN customers b ON a.customer_id=b.customer_id 
INNER JOIN salesman c ON a.salesman_id=c.salesman_id;

select order_no
from orders
where salesman_id=(select salesman_id
from customers
where customer_id=3007);

SELECT *
-- Write a query to find all the orders issued against the salesman who may works for customer whose id is 3007.
SELECT * FROM orders
WHERE salesman_id=(SELECT DISTINCT salesman_id FROM orders WHERE customer_id=3007);

-- Write a query to find all orders attributed to a salesman in New York.
SELECT * FROM orders
WHERE salesman_id IN (SELECT salesman_id FROM salesman WHERE salesman_city='New York');

-- Write a query to count the customers with grades above New York's average.
SELECT grade, COUNT(*) FROM customers
GROUP BY grade HAVING grade>(SELECT AVG(grade) FROM customers WHERE city='New York');

-- Write a query to extract the data from the orders table for those salesman who earned the maximum commission
SELECT order_no, purchase_amount, order_date, salesman_id FROM orders
WHERE salesman_id IN( SELECT salesman_id FROM salesman
WHERE commission=( SELECT MAX(commission) FROM salesman));