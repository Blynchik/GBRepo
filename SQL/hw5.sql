-- �������� ������������� � ������������ SELECT-�������� �� ������� ������ [CREATE VIEW] 
-- �������� ������, ��������� ���������� ������������� [SELECT]
-- ������� ������������� [DROP VIEW]
-- * ������� �������� (������� � ������� media) � ������� ������������? ������� ����: 
-- news_count (���������� ��������), user_id (����� ������������), user_email (email 
-- ������������). ����������� ������ � ������� CTE ��� � ������� �������� JOIN.

USE vk;

CREATE VIEW groups_num AS
SELECT user_id, COUNT(*) FROM users_communities
GROUP BY user_id;

SELECT * FROM groups_num;

DROP VIEW groups_num;