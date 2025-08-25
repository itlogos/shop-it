-- Customer
create table if not exists catalogue.t_customer
(
    id       serial primary key,
    c_name   varchar(50)  not null check (length(trim(c_name)) >= 2),
    c_phone  varchar(20)  not null,
    constraint uq_customer_phone unique (c_phone)
    );

-- Basket (резервация клиента)
create table if not exists catalogue.t_basket
(
    id            serial primary key,
    customer_id   integer     not null
    references catalogue.t_customer(id) on delete restrict,
    c_status      varchar(20) not null default 'CREATED',
    c_created_at  timestamp   not null default now()
    );

-- BasketItem (позиции корзины)
create table if not exists catalogue.t_basket_item
(
    id               serial primary key,
    basket_id        integer not null
    references catalogue.t_basket(id) on delete cascade,
    product_id       integer not null
    references catalogue.t_product(id) on delete restrict,
    c_quantity       integer not null check (c_quantity >= 1),
    c_price_snapshot integer not null,
    constraint uq_basket_product unique (basket_id, product_id)
    );