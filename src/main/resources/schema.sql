CREATE TABLE surveys
(
   id INT NOT NULL AUTO_INCREMENT,
   age INT,
   satisfaction INT ,
   comment VARCHAR(100),
   created DATETIME,
   PRIMARY KEY(id)
);

CREATE TABLE items 
(
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR2(100),
    price NUMBER(5),
    PRIMARY KEY(id)
);

CREATE TABLE comments
(
    id INT NOT NULL AUTO_INCREMENT,
    text VARCHAR2(400),
    item_id int not null references items(id),
    PRIMARY KEY(id)
);
