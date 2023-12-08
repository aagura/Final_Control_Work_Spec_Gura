USE HumanFriends;
-- Проверим существование таблицы "YoungAnimals" и удалим ее, если она существует
DROP TABLE IF EXISTS YoungAnimals;

-- Создадим таблицу "YoungAnimals"
CREATE TABLE YoungAnimals (
    id INT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    age_months INT NOT NULL
);

-- Вставим данные из HumanFriends
INSERT INTO YoungAnimals (id, name, age_months)
SELECT
    id,
    name,
    TIMESTAMPDIFF(MONTH, birthDate, CURDATE()) AS age_months
FROM HumanFriends
WHERE birthDate <= DATE_SUB(CURDATE(), INTERVAL 1 YEAR) AND birthDate > DATE_SUB(CURDATE(), INTERVAL 3 YEAR);

SELECT * FROM YoungAnimals;
