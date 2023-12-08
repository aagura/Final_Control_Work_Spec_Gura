USE HumanFriends;
-- Cat
INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Vasya', '2020-10-01', '{"commands": ["bring", "jump"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Cat (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Stefan', '2021-01-10', '{"commands": ["mew", "bring"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Cat (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Bob', '2022-12-12', '{"commands": ["jump", "mew"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Cat (id)
VALUES 
    (LAST_INSERT_ID())
;

-- Dog
INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Bobik', '2007-01-01', '{"commands": ["bring", "fas", "fu"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Dog (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Tuzik', '2008-01-01', '{"commands": ["bring", "fas", "fu"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Dog (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Sharik', '2009-01-01', '{"commands": ["bring", "fas", "fu"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Dog (id)
VALUES 
    (LAST_INSERT_ID())
;

-- Hamster
INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Orange', '2023-05-05', '{"commands": ["run"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Hamster (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Brown', '2023-05-05', '{"commands": ["roll"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Hamster (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Sosige', '2023-05-05', '{"commands": ["die"]}')
;

INSERT INTO Pets (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Hamster (id)
VALUES 
    (LAST_INSERT_ID())
;

-- PackAnimals
-- Camel
INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Camel1', '2001-01-01', '{"commands": ["sit", "go"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Camel (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Camel2', '2002-01-01', '{"commands": ["sit", "go"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Camel (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Camel3', '2003-01-01', '{"commands": ["sit", "go"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Camel (id)
VALUES 
    (LAST_INSERT_ID())
;

-- Horse
INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Red', '2004-08-05', '{"commands": ["go", "stop"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Horse (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Black', '2014-09-06', '{"commands": ["go", "stop"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Horse (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('White', '2020-10-05', '{"commands": ["go", "stop"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Horse (id)
VALUES 
    (LAST_INSERT_ID())
;

-- Donkey
INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Jack', '2004-08-05', '{"commands": ["go", "stop"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Donkey (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Ass', '2014-09-06', '{"commands": ["go", "stop"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Donkey (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO HumanFriends (name, birthDate, commands)
VALUES 
    ('Hole', '2020-10-05', '{"commands": ["go", "stop"]}')
;

INSERT INTO PackAnimals (id)
VALUES 
    (LAST_INSERT_ID())
;

INSERT INTO Donkey (id)
VALUES 
    (LAST_INSERT_ID())
;

   
SELECT * FROM HumanFriends;
select * from Camel;