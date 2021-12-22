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
       ('Егор'),
       ('Глеб');

insert into products (title, cost)
values ('Кофе', 100),
       ('Чай', 70),
       ('Сок', 50),
       ('Вода', 10);

insert into customers_products (customer_id, product_id)
values (1, 1),
       (1, 3),
       (1, 4),

       (2, 1),
       (2, 3),

       (3, 1),
       (3, 3),
       (3, 4);

select * from products;
select * from customers;
select * from customers_products;
