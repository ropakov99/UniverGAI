CREATE TABLE offence (
    id serial not null,
    user_id serial not null,
    description varchar(255) not null,
    price int8 not null,
    primary key (id)
);

INSERT INTO offense (user_id,description,price) VALUES
 (1,'1111',1),
 (2,'2222',2),
 (3,'3333',3),
 (4,'4444',4);