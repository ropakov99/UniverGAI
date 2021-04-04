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