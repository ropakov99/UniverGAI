create table usr (
    id serial not null,
    password varchar(255) not null,
    username varchar(255) not null,
    primary key (id)
);

create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;


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