-- Написать скрипт, возвращающий список имен (только firstname) пользователей без повторений в алфавитном порядке. [ORDER BY]
-- Выведите количество мужчин старше 35 лет [COUNT].
-- Сколько заявок в друзья в каждом статусе? (таблица friend_requests) [GROUP BY]
-- * Выведите номер пользователя, который отправил больше всех заявок в друзья (таблица friend_requests) [LIMIT].
-- * Выведите названия и номера групп, имена которых состоят из 5 символов [LIKE].

USE vk;

SELECT DISTINCT firstname FROM users 
ORDER BY firstname; 

SELECT COUNT(*) FROM profiles
WHERE gender = 'm' AND birthday + INTERVAL 35 YEAR < now();

SELECT status, COUNT(*) FROM friend_requests
GROUP BY status;

SELECT initiator_user_id FROM friend_requests
GROUP BY initiator_user_id
LIMIT 1;

SELECT * FROM communities
WHERE name LIKE '_____';