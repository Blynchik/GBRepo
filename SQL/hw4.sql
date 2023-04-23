-- Подсчитать количество групп, в которые вступил каждый пользователь.
-- Подсчитать количество пользователей в каждом сообществе.
-- Пусть задан некоторый пользователь. Из всех пользователей соц. сети найдите человека, который 
-- больше всех общался с выбранным пользователем (написал ему сообщений).
-- * Подсчитать общее количество лайков, которые получили пользователи младше 18 лет..
-- * Определить кто больше поставил лайков (всего): мужчины или женщины.

USE vk;

SELECT user_id, COUNT(*) FROM users_communities
GROUP BY user_id;

SELECT community_id, COUNT(*) FROM users_communities
GROUP BY community_id;

SELECT from_user_id FROM messages 
WHERE to_user_id = 1
GROUP BY from_user_id
ORDER BY COUNT(*) DESC
LIMIT 1;

SELECT COUNT(*) FROM media 
LEFT JOIN profiles
ON media.user_id = profiles.user_id
LEFT JOIN likes
ON profiles.user_id = likes.user_id
WHERE profiles.birthday + interval 18 YEAR > NOW();

SELECT gender, likes_count FROM (
SELECT gender, COUNT(*) as likes_count FROM likes
LEFT JOIN profiles ON likes.user_id = profiles.user_id
WHERE profiles.gender = 'm'
UNION ALL 
SELECT gender, COUNT(*) as likes_count FROM likes
LEFT JOIN profiles ON likes.user_id = profiles.user_id
WHERE profiles.gender = 'f'
) AS temp
ORDER BY likes_count DESC
LIMIT 1;