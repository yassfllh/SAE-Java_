-- Calcul des Scores des Athlètes
SELECT nomA, prenomA, (forceA + enduranceA + agiliteA) / 3 AS score FROM Athlete;

-- Classement des Athlètes par Épreuve
SELECT P.idEpreuve, A.nomA, A.prenomA, (A.forceA + A.enduranceA + A.agiliteA) / 3 AS score 
FROM Athlete A 
JOIN Participation P ON A.idAthletes = P.idAthlete 
ORDER BY P.idEpreuve, score DESC;

-- Attribution des Médailles

-- Médaille d'Or
SELECT P.idEpreuve, A.nomA, A.prenomA, 'Or' AS medaille 
FROM Athlete A 
JOIN Participation P ON A.idAthletes = P.idAthlete 
WHERE (A.forceA + A.enduranceA + A.agiliteA) / 3 = (
    SELECT MAX((A2.forceA + A2.enduranceA + A2.agiliteA) / 3) 
    FROM Athlete A2 
    JOIN Participation P2 ON A2.idAthletes = P2.idAthlete 
    WHERE P2.idEpreuve = P.idEpreuve);

-- Médaille d'Argent
SELECT P.idEpreuve, A.nomA, A.prenomA, 'Argent' AS medaille 
FROM Athlete A 
JOIN Participation P ON A.idAthletes = P.idAthlete 
WHERE (A.forceA + A.enduranceA + A.agiliteA) / 3 = (
    SELECT MAX((A2.forceA + A2.enduranceA + A2.agiliteA) / 3) 
    FROM Athlete A2 
    JOIN Participation P2 ON A2.idAthletes = P2.idAthlete 
    WHERE P2.idEpreuve = P.idEpreuve 
    AND (A2.forceA + A2.enduranceA + A2.agiliteA) / 3 < (
        SELECT MAX((A3.forceA + A3.enduranceA + A3.agiliteA) / 3) 
        FROM Athlete A3 
        JOIN Participation P3 ON A3.idAthletes = P3.idAthlete 
        WHERE P3.idEpreuve = P.idEpreuve));

-- Médaille de Bronze
SELECT P.idEpreuve, A.nomA, A.prenomA, 'Bronze' AS medaille 
FROM Athlete A 
JOIN Participation P ON A.idAthletes = P.idAthlete 
WHERE (A.forceA + A.enduranceA + A.agiliteA) / 3 = (
    SELECT MAX((A2.forceA + A2.enduranceA + A2.agiliteA) / 3) 
    FROM Athlete A2 
    JOIN Participation P2 ON A2.idAthletes = P2.idAthlete 
    WHERE P2.idEpreuve = P.idEpreuve 
    AND (A2.forceA + A2.enduranceA + A2.agiliteA) / 3 < (
        SELECT MAX((A3.forceA + A3.enduranceA + A3.agiliteA) / 3) 
        FROM Athlete A3 
        JOIN Participation P3 ON A3.idAthletes = P3.idAthlete 
        WHERE P3.idEpreuve = P.idEpreuve 
        AND (A3.forceA + A3.enduranceA + A3.agiliteA) / 3 < (
            SELECT MAX((A4.forceA + A4.enduranceA + A4.agiliteA) / 3) 
            FROM Athlete A4 
            JOIN Participation P4 ON A4.idAthletes = P4.idAthlete 
            WHERE P4.idEpreuve = P.idEpreuve)));

-- Résumé des Médailles par Pays
SELECT P.nomPays, 
    SUM(CASE WHEN A.medailleA = 'Or' THEN 1 ELSE 0 END) AS nbOr, 
    SUM(CASE WHEN A.medailleA = 'Argent' THEN 1 ELSE 0 END) AS nbArgent, 
    SUM(CASE WHEN A.medailleA = 'Bronze' THEN 1 ELSE 0 END) AS nbBronze 
FROM Athlete A 
JOIN Pays P ON A.idPays = P.idPays 
GROUP BY P.nomPays;

-- Consultation des Résultats
-- Médailles

-- Médaille d'Or
SELECT P.idEpreuve, A.nomA, A.prenomA, (A.forceA + A.enduranceA + A.agiliteA) / 3 AS score, 'Or' AS medaille 
FROM Athlete A 
JOIN Participation P ON A.idAthletes = P.idAthlete 
WHERE P.idEpreuve = 1
AND (A.forceA + A.enduranceA + A.agiliteA) / 3 = (
    SELECT MAX((A2.forceA + A2.enduranceA + A2.agiliteA) / 3) 
    FROM Athlete A2 
    JOIN Participation P2 ON A2.idAthletes = P2.idAthlete 
    WHERE P2.idEpreuve = P.idEpreuve)
UNION ALL
-- Médaille d'Argent
SELECT P.idEpreuve, A.nomA, A.prenomA, (A.forceA + A.enduranceA + A.agiliteA) / 3 AS score, 'Argent' AS medaille 
FROM Athlete A 
JOIN Participation P ON A.idAthletes = P.idAthlete 
WHERE P.idEpreuve = 1
AND (A.forceA + A.enduranceA + A.agiliteA) / 3 = (
    SELECT MAX((A2.forceA + A2.enduranceA + A2.agiliteA) / 3) 
    FROM Athlete A2 
    JOIN Participation P2 ON A2.idAthletes = P2.idAthlete 
    WHERE P2.idEpreuve = P.idEpreuve 
    AND (A2.forceA + A2.enduranceA + A2.agiliteA) / 3 < (
        SELECT MAX((A3.forceA + A3.enduranceA + A3.agiliteA) / 3) 
        FROM Athlete A3 
        JOIN Participation P3 ON A3.idAthletes = P3.idAthlete 
        WHERE P3.idEpreuve = P.idEpreuve))
UNION ALL
-- Médaille de Bronze
SELECT P.idEpreuve, A.nomA, A.prenomA, (A.forceA + A.enduranceA + A.agiliteA) / 3 AS score, 'Bronze' AS medaille 
FROM Athlete A 
JOIN Participation P ON A.idAthletes = P.idAthlete 
WHERE P.idEpreuve = 1
AND (A.forceA + A.enduranceA + A.agiliteA) / 3 = (
    SELECT MAX((A2.forceA + A2.enduranceA + A2.agiliteA) / 3) 
    FROM Athlete A2 
    JOIN Participation P2 ON A2.idAthletes = P2.idAthlete 
    WHERE P2.idEpreuve = P.idEpreuve 
    AND (A2.forceA + A2.enduranceA + A2.agiliteA) / 3 < (
        SELECT MAX((A3.forceA + A3.enduranceA + A3.agiliteA) / 3) 
        FROM Athlete A3 
        JOIN Participation P3 ON A3.idAthletes = P3.idAthlete 
        WHERE P3.idEpreuve = P.idEpreuve 
        AND (A3.forceA + A3.enduranceA + A3.agiliteA) / 3 < (
            SELECT MAX((A4.forceA + A4.enduranceA + A4.agiliteA) / 3) 
            FROM Athlete A4 
            JOIN Participation P4 ON A4.idAthletes = P4.idAthlete 
            WHERE P4.idEpreuve = P.idEpreuve)))
ORDER BY score DESC;