
INSERT INTO usr (username,password) VALUES
 ('admin','aaaa'),
 ('user1','2222'),
 ('user2','3333'),
 ('user3','4444');

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
