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
    count INT,
    survey_id INT
);