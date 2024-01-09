create table Product (
    id serial primary key,
    name varchar(36) not null,
    manufacturer varchar(36) not null,
    price double precision
)