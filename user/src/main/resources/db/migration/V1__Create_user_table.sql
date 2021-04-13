create table user_role (
    user_id int8 not null,
    roles varchar(255)
);

create table usr (
    id serial not null,
    password varchar(255) not null,
    username varchar(255) not null,
    email varchar(255) not null,
    primary key (id)
);

create table offence (
    id serial not null,
    user_id serial not null,
    description varchar(255) not null,
    price int8 not null,
    primary key (id)
);

CREATE TABLE testdb_card (
    id serial NOT NULL,
    summary double precision,
    primary key (id)
);

CREATE TABLE carapi_car (
    id serial NOT NULL,
    user_id integer NOT NULL,
    number character varying(10) NOT NULL,
    condition character varying(20) NOT NULL,
    registration character varying(30) NOT NULL,
    hijaked boolean NOT NULL,
    primary key (id)
);

alter table if exists user_role
    add constraint user_role_user_fk
    foreign key (user_id) references usr;

