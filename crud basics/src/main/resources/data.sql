create table empdetails
(
   id integer not null,
   name varchar(255) not null,
   address varchar(255),
   primary key(id)
);
INSERT INTO empdetails (ID, NAME, ADDRESS )
VALUES(10001,  'John', 'Hyderabad');
INSERT INTO empdetails (ID, NAME, ADDRESS )
VALUES(10002,  'James', 'Delhi');
INSERT INTO empdetails (ID, NAME, ADDRESS )
VALUES(10003,  'Jon', 'Mumbai');
