DROP TABLE rewards_customer;
DROP TABLE rewards_transaction;

CREATE TABLE rewards_customer(cust_id varchar2(25), cust_nm varchar2(100));
CREATE TABLE rewards_transaction(id integer ,cust_id varchar2(25) , purchase_amt DOUBLE PRECISION);

INSERT INTO rewards_customer (cust_id, cust_nm) VALUES ('1001', 'User 1001');
INSERT INTO rewards_customer (cust_id, cust_nm) VALUES ('1002', 'User 1002');
INSERT INTO rewards_customer (cust_id, cust_nm) VALUES ('1003', 'User 1003');

INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (1,'1001', 75.00);
INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (2,'1001', 120.00);
INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (3,'1001', 150.00);
INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (4,'1001', 220.00);
INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (5,'1001', 270.00);

INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (6,'1002', 110.00);
INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (7,'1002', 210.00);
INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (8,'1002', 320.00);

INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (9,'1003', 80.00);
INSERT INTO rewards_transaction (id,cust_id, purchase_amt) VALUES (20,'1003', 250.00);