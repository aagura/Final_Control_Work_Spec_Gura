USE HumanFriends;
SELECT 
    COALESCE(HF.id, C.id, D.id, H.id, P.id, PY.id, EQ.id) AS id,
    HF.name,
    HF.birthDate,
    HF.commands,
    PY.age_months,
    EQ.type,
    COALESCE(HF.table_name, 'Cat', 'Dog', 'Hamster', 'PackAnimals', 'Pets', 'YoungAnimals', 'Equine') AS table_name
FROM HumanFriends HF
LEFT JOIN Cat C ON HF.id = C.id
LEFT JOIN Dog D ON HF.id = D.id
LEFT JOIN Hamster H ON HF.id = H.id
LEFT JOIN PackAnimals P ON HF.id = P.id
LEFT JOIN Pets PY ON HF.id = PY.id
LEFT JOIN YoungAnimals PY ON HF.id = PY.id
LEFT JOIN Equines EQ ON HF.id = EQ.id;

