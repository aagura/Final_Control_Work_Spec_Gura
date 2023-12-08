USE HumanFriends;
SELECT 
    id,
    name,
    birthDate,
    commands,
    NULL AS age_months,
    NULL AS type,
    'HumanFriends' AS table_name
FROM HumanFriends

UNION

SELECT 
    id,
    NULL AS name,
    NULL AS birthDate,
    NULL AS commands,
    NULL AS age_months,
    NULL AS type,
    'Cat' AS table_name
FROM Cat

UNION

SELECT 
    id,
    NULL AS name,
    NULL AS birthDate,
    NULL AS commands,
    NULL AS age_months,
    NULL AS type,
    'Dog' AS table_name
FROM Dog

UNION

SELECT 
    id,
    NULL AS name,
    NULL AS birthDate,
    NULL AS commands,
    NULL AS age_months,
    NULL AS type,
    'Hamster' AS table_name
FROM Hamster

UNION

SELECT 
    id,
    NULL AS name,
    NULL AS birthDate,
    NULL AS commands,
    NULL AS age_months,
    NULL AS type,
    'PackAnimals' AS table_name
FROM PackAnimals

UNION

SELECT 
    id,
    NULL AS name,
    NULL AS birthDate,
    NULL AS commands,
    NULL AS age_months,
    NULL AS type,
    'Pets' AS table_name
FROM Pets

UNION

SELECT 
    id,
    NULL AS name,
    NULL AS birthDate,
    NULL AS commands,
    age_months,
    NULL AS type,
    'YoungAnimals' AS table_name
FROM YoungAnimals

UNION

SELECT 
    id,
    NULL AS name,
    NULL AS birthDate,
    NULL AS commands,
    NULL AS age_months,
    type,
    'Equine' AS table_name
FROM Equines;
