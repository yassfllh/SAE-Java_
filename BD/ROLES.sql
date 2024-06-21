-- Création des rôles
CREATE ROLE administrateur;
CREATE ROLE journaliste;
CREATE ROLE organisateur;

-- ATTRIBUTION DES DROITS

-- ADMINISTRATEUR
GRANT ALL ON JeuxOlympiques.* TO administrateur;

-- JOURNALISTE
GRANT SELECT ON JeuxOlympiques.* TO journaliste;

-- ORGANISATEUR
GRANT SELECT, INSERT, UPDATE ON JeuxOlympiques.Athlete TO organisateur;
GRANT SELECT, INSERT, UPDATE ON JeuxOlympiques.Equipe TO organisateur;
GRANT SELECT, INSERT, UPDATE ON JeuxOlympiques.Epreuve TO organisateur;
GRANT SELECT, INSERT, UPDATE ON JeuxOlympiques.Participation TO organisateur;
GRANT SELECT ON JeuxOlympiques.Pays TO organisateur;
GRANT SELECT ON JeuxOlympiques.Sport TO organisateur;

-- Création des utilisateurs
CREATE USER administrateur IDENTIFIED BY 'password';
CREATE USER journaliste IDENTIFIED BY 'password';
CREATE USER organisateur IDENTIFIED BY 'password';

-- Attribution des rôles
GRANT administrateur TO administrateur;
GRANT journaliste TO journaliste;
GRANT organisateur TO organisateur;