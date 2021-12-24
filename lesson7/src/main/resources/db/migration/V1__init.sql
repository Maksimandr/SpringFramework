create table if not exists products
(
    id    bigserial primary key,
    title varchar(255),
    cost  int
    );

insert into products (title, cost)
values ('Кофе', 10),
       ('Чай', 20),
       ('Сок', 30),
       ('Вода', 40),
       ('Кола', 50),
       ('Лимонад', 60),
       ('Тархун', 70),
       ('Молоко', 80),
       ('Кефир', 90),
       ('Ряженка', 100),
       ('Квас', 110),
       ('Пиво', 120),
       ('Водка', 130),
       ('Коньяк', 140),
       ('Вино', 150),
       ('Шампанское', 160),
       ('Джин', 170),
       ('Ром', 180),
       ('Глинтвейн', 190),
       ('Самогон', 200);

select * from products;