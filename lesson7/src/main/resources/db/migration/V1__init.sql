create table if not exists products
(
    id    bigserial primary key,
    title varchar(255),
    cost  int
    );

insert into products (title, cost)
values ('Кофе', 1),
       ('Чай', 2),
       ('Сок', 3),
       ('Вода', 4),
       ('Кола', 5),
       ('Лимонад', 6),
       ('Тархун', 7),
       ('Молоко', 8),
       ('Кефир', 9),
       ('Ряженка', 10),
       ('Квас', 11),
       ('Пиво', 12),
       ('Водка', 13),
       ('Коньяк', 14),
       ('Вино', 15),
       ('Шампанское', 16),
       ('Джин', 17),
       ('Ром', 18),
       ('Глинтвейн', 19),
       ('Самогон', 20);

select * from products;
