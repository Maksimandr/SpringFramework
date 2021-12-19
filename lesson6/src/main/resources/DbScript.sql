drop table if exists customers_products;

drop table if exists customers;
create table if not exists customers
(
    id   bigserial primary key,
    name varchar(255)
    );

drop table if exists products;
create table if not exists products
(
    id    bigserial primary key,
    title varchar(255),
    cost  int
    );

create table if not exists customers_products
(
    customer_id bigint,
    product_id  bigint,

    foreign key (customer_id) references customers (id),
    foreign key (product_id) references products (id)
    );

insert into customers (name)
values ('Иван'),
       ('Анна'),
       ('Егор');

insert into products (title, cost)
values ('Кофе', 100),
       ('Чай', 70),
       ('Сок', 50),
       ('Вода', 10);

select * from products;
select * from customers;
