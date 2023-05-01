-- —оздайте представление с произвольным SELECT-запросом из прошлых уроков [CREATE VIEW] 
-- ¬ыведите данные, использу€ написанное представление [SELECT]
-- ”далите представление [DROP VIEW]
-- * —колько новостей (записей в таблице media) у каждого пользовател€? ¬ывести пол€: 
-- news_count (количество новостей), user_id (номер пользовател€), user_email (email 
-- пользовател€). ѕопробовать решить с помощью CTE или с помощью обычного JOIN.

USE vk;

CREATE VIEW groups_num AS
SELECT user_id, COUNT(*) FROM users_communities
GROUP BY user_id;

SELECT * FROM groups_num;

DROP VIEW groups_num;