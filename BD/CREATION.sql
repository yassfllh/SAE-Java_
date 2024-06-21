DROP TABLE IF EXISTS Pays;
DROP TABLE IF EXISTS Sport;
DROP TABLE IF EXISTS Athlete;
DROP TABLE IF EXISTS Equipe;
DROP TABLE IF EXISTS Epreuve;
DROP TABLE IF EXISTS Participation;

CREATE DATABASE JeuxOlympiques;
USE JeuxOlympiques;

-- Table Pays
CREATE TABLE Pays (
    idPays INT AUTO_INCREMENT PRIMARY KEY,
    nomPays VARCHAR(255) NOT NULL
);

-- Table Sport
CREATE TABLE Sport (
    idSport INT AUTO_INCREMENT PRIMARY KEY,
    nomSport VARCHAR(255) NOT NULL,
    typeSport VARCHAR(255) NOT NULL
);

-- Table Athlete
CREATE TABLE Athlete (
    idAthletes INT AUTO_INCREMENT PRIMARY KEY,
    nomA VARCHAR(255) NOT NULL,
    prenomA VARCHAR(255) NOT NULL,
    sexeA CHAR(1) NOT NULL,
    forceA INT,
    enduranceA INT,
    agiliteA INT,
    medailleA VARCHAR(255),
    totalMedailes INT,
    idPays INT,
    FOREIGN KEY (idPays) REFERENCES Pays(idPays)
);

-- Table Equipe
CREATE TABLE Equipe (
    idEquipe INT AUTO_INCREMENT PRIMARY KEY,
    nomEquipe VARCHAR(255) NOT NULL,
    totalMedailes INT,
    medailleA VARCHAR(255),
    nbMax INT,
    idPays INT,
    FOREIGN KEY (idPays) REFERENCES Pays(idPays)
);

-- Table Epreuve
CREATE TABLE Epreuve (
    idEpreuve INT AUTO_INCREMENT PRIMARY KEY,
    nbParticipants INT,
    individuelle BOOLEAN,
    sexeEpreuve CHAR(1),
    idSport INT,
    FOREIGN KEY (idSport) REFERENCES Sport(idSport)
);

-- Table Participation
CREATE TABLE Participation (
    idParticipant INT AUTO_INCREMENT PRIMARY KEY,
    idAthlete INT,
    idEquipe INT,
    idEpreuve INT,
    FOREIGN KEY (idAthlete) REFERENCES Athlete(idAthletes),
    FOREIGN KEY (idEquipe) REFERENCES Equipe(idEquipe),
    FOREIGN KEY (idEpreuve) REFERENCES Epreuve(idEpreuve)
);

-- Insertion des données dans la table Pays
INSERT INTO Pays (nomPays) VALUES 
('Brésil'), 
('Allemagne'), 
('Chine'), 
('Australie'), 
('Kenya'), 
('France'), 
('Turquie'), 
('Japon'), 
('USA'), 
('Maroc');

-- Insertion des données dans la table Sport
INSERT INTO Sport (nomSport, typeSport) VALUES 
('Escrime épée', 'Individuelle'),
('Natation 100 brasse', 'Individuelle'),
('Athlétisme relais 400m', 'Équipe'),
('Natation relais libre', 'Équipe'),
('Escrime fleuret', 'Individuelle'),
('Athlétisme 110 haies', 'Individuelle'),
('Volley-Ball', 'Équipe'),
('Handball', 'Équipe');

-- Insertion des données dans la table Athlete
INSERT INTO Athlete (nomA, prenomA, sexeA, forceA, enduranceA, agiliteA, idPays) VALUES 
('Liu', 'Jun', 'F', 7, 13, 9, 1),
('Lambert', 'Léna', 'M', 6, 6, 20, 2),
('Lambert', 'Maëlys', 'M', 9, 15, 11, 3),
('Garcia', 'Mathis', 'F', 1, 20, 6, 2),
('Huang', 'Wu', 'F', 2, 4, 1, 4),
('Yamada', 'Asuka', 'F', 1, 13, 18, 3),
('Kondo', 'Hinata', 'M', 12, 13, 1, 4),
('Hasegawa', 'Kaito', 'M', 3, 4, 7, 5),
('Lange', 'Lina', 'M', 8, 1, 16, 3),
('Saito', 'Hana', 'M', 17, 8, 9, 6),
('Yamamoto', 'Riku', 'M', 7, 7, 3, 6),
('Zhou', 'Wu', 'M', 14, 17, 11, 1),
('Perez', 'Emma', 'F', 20, 12, 7, 1),
('Roux', 'Gabriel', 'M', 2, 17, 6, 5),
('Thomas', 'Hugo', 'F', 16, 18, 13, 3),
('Perez', 'Gabriel', 'F', 15, 8, 18, 4),
('Fontaine', 'Manon', 'M', 17, 17, 17, 5),
('Yamaguchi', 'Rina', 'F', 8, 12, 12, 7),
('Laurent', 'Léa', 'F', 6, 8, 15, 10),
('He', 'Shuang', 'M', 2, 3, 11, 2),
('Gao', 'Fang', 'M', 11, 11, 20, 10);

-- Insertion des données dans la table Equipe
INSERT INTO Equipe (nomEquipe, totalMedailes, medailleA, nbMax, idPays) VALUES 
('Equipe Escrime Epée Brésil', 0, NULL, 4, 1),
('Equipe Natation 100 Brasse Allemagne', 0, NULL, 4, 2),
('Equipe Athlétisme Relais 400m Chine', 0, NULL, 4, 3),
('Equipe Natation Relais Libre Australie', 0, NULL, 4, 4),
('Equipe Escrime Fleuret Kenya', 0, NULL, 4, 5),
('Equipe Athlétisme 110 Haies France', 0, NULL, 4, 6),
('Equipe Volley-Ball Turquie', 0, NULL, 6, 7),
('Equipe Handball Japon', 0, NULL, 7, 8),
('Equipe Athlétisme Relais 400m USA', 0, NULL, 4, 9),
('Equipe Volley-Ball Maroc', 0, NULL, 6, 10);

-- Insertion des données dans la table Epreuve
INSERT INTO Epreuve (nbParticipants, individuelle, sexeEpreuve, idSport) VALUES 
(32, TRUE, 'M', 1),
(32, TRUE, 'F', 2),
(8, FALSE, 'M', 3),
(8, FALSE, 'F', 4),
(32, TRUE, 'M', 5),
(32, TRUE, 'F', 6),
(12, FALSE, 'M', 7),
(14, FALSE, 'F', 8);

-- Insertion des données dans la table Participation
INSERT INTO Participation (idAthlete, idEquipe, idEpreuve) VALUES 
(1, 1, 1),
(2, 2, 2),
(3, 3, 3),
(4, 3, 3),
(5, 4, 4),
(6, 5, 5),
(7, 6, 6),
(8, 7, 7),
(9, 7, 7),
(10, 8, 8),
(11, 8, 8),
(12, 9, 3),
(13, 9, 3),
(14, 10, 7),
(15, 10, 7);