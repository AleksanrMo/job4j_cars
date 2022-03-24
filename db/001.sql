create table manufacturer (
    id serial primary key,
    name varchar(255) not null
);

create table car_body(
    id serial primary key,
    name varchar(255) not null
);

create table cars(
    id serial primary key,
    name varchar(255) not null ,
    manufacturer_id int references manufacturer(id),
    car_body_id int references car_body(id)
);

create table users(
    id serial primary key,
    name varchar(255) not null,
    email varchar(255) not null,
    password varchar(255) not null
);

create table advertisement (
    id serial primary key,
    description text,
    created timestamp,
    photo text,
    status boolean,
    car_id int references cars(id),
    user_id int references users(id)

);






