-- �������� �������, ������� ������� ��� ���������� �� ��������� 
-- ������������ �� �� vk. ������������ �������� �� id. ������� 
-- ����� ��� ���������, �����, ����� ������, ������� � ������ 
-- �� ������� users. ������� ������ ���������� ����� ������������.
-- ���������� ������ ������ � ������� ��������� � �������� 
-- ������������ ������� � ���������� ������ ���������.
-- * �������� �������, ������� ��������� ����� ������������ 
-- ����������. ����� �������� ���������� (���� name) ������ 
-- ���� �� ����� 5 ��������. ���� ���������� �� ���������, 
-- �� ����������� ���������� � ����������.

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