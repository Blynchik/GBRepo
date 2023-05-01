-- Написать функцию, которая удаляет всю информацию об указанном 
-- пользователе из БД vk. Пользователь задается по id. Удалить 
-- нужно все сообщения, лайки, медиа записи, профиль и запись 
-- из таблицы users. Функция должна возвращать номер пользователя.
-- Предыдущую задачу решить с помощью процедуры и обернуть 
-- используемые команды в транзакцию внутри процедуры.
-- * Написать триггер, который проверяет новое появляющееся 
-- сообщество. Длина названия сообщества (поле name) должна 
-- быть не менее 5 символов. Если требование не выполнено, 
-- то выбрасывать исключение с пояснением.

DROP FUNCTION IF EXISTS delete_user;

DELIMITER //
CREATE FUNCTION delete_user(num INT)
RETURNS INT
READS SQL DATA
BEGIN
DELETE FROM friend_requests WHERE initiator_user_id = num OR target_user_id = num;
DELETE FROM messages WHERE from_user_id = num OR to_user_id = num;
DELETE FROM users_communities WHERE user_id = num;
DELETE FROM likes WHERE media_id IN (SELECT id FROM media WHERE user_id = num);
DELETE FROM profiles WHERE photo_id IN (SELECT id FROM media WHERE user_id = num);
DELETE FROM media WHERE user_id = num;
DELETE FROM likes WHERE user_id = num;
DELETE FROM users WHERE id = num;
RETURN num;
END //
DELIMITER ;

SELECT delete_user(1);

DROP PROCEDURE IF EXISTS delete_user_from_vk;

DELIMITER //
CREATE PROCEDURE delete_user_from_vk(num int)
BEGIN
START TRANSACTION;
DELETE FROM friend_requests WHERE initiator_user_id = num OR target_user_id = num;
DELETE FROM messages WHERE from_user_id = num OR to_user_id = num;
DELETE FROM users_communities WHERE user_id = num;
DELETE FROM likes WHERE media_id IN (SELECT id FROM media WHERE user_id = num);
DELETE FROM profiles WHERE photo_id IN (SELECT id FROM media WHERE user_id = num);
DELETE FROM media WHERE user_id = num;
DELETE FROM likes WHERE user_id = num;
DELETE FROM users WHERE id = num;
COMMIT;
END //
DELIMITER ;

CALL delete_user_from_vk(2);

SELECT * FROM users;