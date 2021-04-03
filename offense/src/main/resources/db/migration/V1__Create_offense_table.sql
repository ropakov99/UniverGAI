create table offence (
    id serial not null,
    user_id serial not null,
    description varchar(255) not null,
    price int8 not null,
    primary key (id)
);