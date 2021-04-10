
INSERT INTO usr (username,password) VALUES
 ('admin','1111'),
 ('user1','1111'),
 ('user2','2222'),
 ('user3','3333');

INSERT INTO user_role (user_id,roles) VALUES
    (1,'ADMIN'),
    (2,'USER'),
    (3,'USER'),
    (4,'USER');

INSERT INTO offence (user_id,description,price) VALUES
    (1,'1111',1),
    (2,'2222',2),
    (3,'3333',3),
    (4,'4444',4);
