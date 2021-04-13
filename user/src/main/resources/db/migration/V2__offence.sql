
INSERT INTO usr (username,password,email) VALUES
 ('admin','1111','aaa@email.com'),
 ('user1','1111','ccc@email.com'),
 ('user2','2222','bbb@email.com'),
 ('user3','3333','ddd@email.com');

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
