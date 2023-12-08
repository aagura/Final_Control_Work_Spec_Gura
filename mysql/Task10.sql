USE HumanFriends;
DELETE FROM HumanFriends WHERE id IN (SELECT id FROM PackAnimals WHERE id IN (SELECT id FROM Camel));
DROP TABLE IF EXISTS Equines;
CREATE TABLE Equines (
    id INT PRIMARY KEY,
    type ENUM ('Horse', 'Donkey') NOT NULL,
    -- Добавьте другие поля, если необходимо
    FOREIGN KEY (id) REFERENCES PackAnimals(id) ON DELETE CASCADE
);
-- Скопировать данные лошадей
INSERT INTO Equines (id, type)
SELECT id, 'Horse' FROM Horse;

-- Скопировать данные ослов
INSERT INTO Equines (id, type)
SELECT id, 'Donkey' FROM Donkey;
DROP TABLE Horse;
DROP TABLE Donkey;
SELECT * FROM Equines;