create schema if not exists catalogue;

create table catalogue.t_product
(
    id        serial primary key,
    c_title   varchar(50) not null check (length(trim(c_title)) >= 3),
    c_price   integer not null check (c_price between 0 and 5000),
    c_details varchar(1000)
);