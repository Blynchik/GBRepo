-- �������� ������, ������������ ������ ���� (������ firstname) ������������� ��� ���������� � ���������� �������. [ORDER BY]
-- �������� ���������� ������ ������ 35 ��� [COUNT].
-- ������� ������ � ������ � ������ �������? (������� friend_requests) [GROUP BY]
-- * �������� ����� ������������, ������� �������� ������ ���� ������ � ������ (������� friend_requests) [LIMIT].
-- * �������� �������� � ������ �����, ����� ������� ������� �� 5 �������� [LIKE].

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