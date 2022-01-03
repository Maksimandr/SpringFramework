create table if not exists users (
    id bigserial primary key,
    username varchar(255) unique ,
    password varchar(255) not null,
    email varchar(255) not null,
    enabled boolean not null default false
);

create table if not exists roles (
    id bigserial primary key,
    name varchar(255) not null unique
);

create table if not exists users_roles (
    user_id bigint references users (id),
    role_id bigint references roles (id)
);

INSERT INTO users (username, password, email, enabled)
VALUES
('admin', '$2a$12$fIxG7VKFdJw9HriHgNyuNu.DitJytiDsERb25YAvhUEicllt37m0O', 'admin@admin.ru', true),
('manager', '$2a$12$a/LUQQzSTbOYVzNYY5Bki.kZdoKxy2YDiukW.8r5bB42a3JsqBpeC', 'manager@manager.ru', true),
('user', '$2a$12$.z4y.gN6zGcUMjU/USKMEedIinnVn.4xGonlD1.M2213psnAWqYW.', 'user@user.ru', true);

INSERT INTO roles (name)
VALUES
('ROLE_ADMIN'),
('ROLE_MANAGER'),
('ROLE_USER');

insert into users_roles (user_id, role_id)
values (1, 1), (2, 2), (3, 3);
