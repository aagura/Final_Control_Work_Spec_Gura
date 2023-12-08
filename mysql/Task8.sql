DROP database humanfriends;
CREATE DATABASE HumanFriends;
USE HumanFriends; 
-- Таблица HumanFriends
CREATE TABLE HumanFriends (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    birthDate DATE NOT NULL,
    commands JSON
);

-- Таблица Pets
CREATE TABLE Pets (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES HumanFriends(id) ON DELETE CASCADE
);

-- Таблицы конкретных домашних животных (Cat, Dog, Hamster)
CREATE TABLE Cat (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Pets(id) ON DELETE CASCADE
);

CREATE TABLE Dog (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Pets(id) ON DELETE CASCADE
);

CREATE TABLE Hamster (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES Pets(id) ON DELETE CASCADE
);

-- Таблица PackAnimals
CREATE TABLE PackAnimals (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES HumanFriends(id) ON DELETE CASCADE
);

-- Таблицы конкретных рабочих животных (Horse, Donkey, Camel)
CREATE TABLE Horse (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES PackAnimals(id) ON DELETE CASCADE
);

CREATE TABLE Donkey (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES PackAnimals(id) ON DELETE CASCADE
);

CREATE TABLE Camel (
    id INT PRIMARY KEY,
    FOREIGN KEY (id) REFERENCES PackAnimals(id) ON DELETE CASCADE
);

SHoW tables;

