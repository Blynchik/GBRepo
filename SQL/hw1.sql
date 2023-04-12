-- Создайте таблицу с мобильными телефонами, используя графический 
--интерфейс. Необходимые поля таблицы: product_name (название товара), 
--manufacturer (производитель), product_count (количество), price (цена).
-- Заполните БД произвольными данными.

-- Напишите SELECT-запрос, который выводит название товара, производителя
-- и цену для товаров, количество которых превышает 2

-- Выведите SELECT-запросом весь ассортимент товаров марки “Samsung”

-- 4.* С помощью SELECT-запроса с оператором LIKE / REGEXP найти:
-- 4.1.* Товары, в которых есть упоминание "Iphone"
-- 4.2.* Товары, в которых есть упоминание "Samsung"
-- 4.3.* Товары, в названии которых есть ЦИФРЫ
-- 4.4.* Товары, в названии которых есть ЦИФРА "8"

CREATE DATABASE GB_DB;

CREATE TABLE GB_DB.PHONE(
    ID INT AUTO_INCREMENT PRIMARY KEY,
    PRODUCT_NAME VARCHAR(100),
    MANUFACTURER VARCHAR(100),
    PRODUCT_COUNT INT,
    PRICE INT
);

INSERT INTO GB_DB.PHONE(PRODUCT_NAME, MANUFACTURER, PRODUCT_COUNT, PRICE)
VALUES  ('Best Phone', 'Best Company', 3, 600),
        ('Iphone', 'Apple', 1, 500),
        ('Smartphone', 'Samsung', 2, 300),
        ('T1000', 'Skynet', 1, 0),
        ('Hateful 8', 'Tarantino', 8, 100);

SELECT PRODUCT_NAME, MANUFACTURER, PRICE 
        FROM GB_DB.PHONE WHERE PRODUCT_COUNT>2;

SELECT * FROM GB_DB.PHONE WHERE MANUFACTURER='Samsung';

SELECT * FROM GB_DB.PHONE WHERE PRODUCT_NAME LIKE ('Iphone') 
        OR MANUFACTURER LIKE ('Iphone'); 

SELECT * FROM GB_DB.PHONE WHERE PRODUCT_NAME REGEXP '[0-9]'; 

SELECT * FROM GB_DB.PHONE WHERE PRODUCT_NAME REGEXP '[8]'; 






