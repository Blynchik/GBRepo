-- Создать БД vk, исполнив скрипт _vk_db_creation.sql (в материалах к уроку)
-- Написать скрипт, добавляющий в созданную БД vk 2-3 новые таблицы (с перечнем полей, указанием индексов и внешних ключей) (CREATE TABLE)
-- Заполнить 2 таблицы БД vk данными (по 10 записей в каждой таблице) (INSERT)
-- 4.* Написать скрипт, отмечающий несовершеннолетних пользователей как неактивных (поле is_active = true). При необходимости предварительно добавить такое поле в таблицу profiles со значением по умолчанию = false (или 0) (ALTER TABLE + UPDATE)
-- 5.* Написать скрипт, удаляющий сообщения «из будущего» (дата позже сегодняшней) (DELETE)

drop table if exists comments;
create table comments
(
id int primary key auto_increment,
message varchar(300) not null,
created_at timestamp default now() not null,
user_id int references users(id) on delete set null,
media_id int references media(id) on delete cascade 
);

drop table if exists donates;
create table donates
(
id int primary key auto_increment,
amount int not null,
donater int references users(id) on delete set null,
beneficiary int references user(id) on delete set null,
created_at timestamp default now() not null
);

insert into users(firstname, lastname, email, phone) values
('Петр', 'Петров', '1@maul.ru',12345678910),
('Иван', 'Иванов', '2@maul.ru',12345678911),
('Илья', 'Ильин', '3@maul.ru',12345678912),
('Николай', 'Николаев', '4@maul.ru',12345678913),
('Анна', 'Анина', '5@maul.ru',12345678914),
('Светлана', 'Светланина', '6@maul.ru',12345678915),
('Татьяна', 'Татьянина', '7@maul.ru',12345678916),
('Алевтина', 'Алевтинина', '8@maul.ru',12345678917),
('Андрей', 'Андреев', '9@maul.ru',12345678918),
('Евгения', 'Евгенина', '10@maul.ru',12345678919);

insert into profiles(user_id, gender, birthday) values
(1, 'm', '1993-12-18'),
(2, 'm', '1999-06-23'),
(3, 'm', '2009-04-15'),
(4, 'm', '2015-11-19'),
(5, 'f', '1997-07-15'),
(6, 'f', '2010-01-02'),
(7, 'f', '1995-09-07'),
(8, 'f', '1997-03-21'),
(9, 'm', '2000-01-01'),
(10, 'f', '1967-10-23');

alter table profiles add is_active boolean default true;

update profiles set is_active=false 
where birthday + interval 18 year > now();

insert into messages(from_user_id, to_user_id, body, created_at) values
(1, 2, 'Hello', now()),
(2, 1, 'Back to Future', now() + interval 100 second);

delete from messages where created_at > now();