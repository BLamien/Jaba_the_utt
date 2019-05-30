CREATE TABLE Ecole(
    ID_Ecole int(11) PRIMARY KEY AUTO_INCREMENT,
	Nom_Ecole varchar(255) NOT NULL,
	Annee_Fondation int(11) NOT NULL
);

CREATE TABLE Classe(
    ID_Classe int(11) PRIMARY KEY AUTO_INCREMENT,
    Niveau varchar(255) NOT NULL,
    ID_Ecole int(11),
    ID_AnneeScolaire int(11),
    FOREIGN KEY (ID_Ecole) REFERENCES Ecole(ID_Ecole),
    FOREIGN KEY (ID_AnneeScolaire) REFERENCES Ecole(ID_AnneeScolaire)
);

CREATE TABLE AnneeScolaire(
    ID_AnneeScolaire int(11) PRIMARY KEY AUTO_INCREMENT,
    Debut_AnneeScolaire int(11) NOT NULL,
    Fin_AnneeScolaire int(11) NOT NULL
);

CREATE TABLE Trimestre(
    ID_Trimestre int(11) PRIMARY KEY AUTO_INCREMENT,
    Numero int(11) NOT NULL,
    Debut_Trimestre date NOT NULL,
    Fin_Trimestre date NOT NULL,
    ID_AnneeScolaire int(11),
    FOREIGN KEY (ID_AnneeScolaire) REFERENCES AnneeScolaire(ID_AnneeScolaire)
);

CREATE TABLE Bulletin(
    ID_Bulletin int(11) PRIMARY KEY AUTO_INCREMENT,
    Moyenne_Trimestre float NOT NULL,
    ID_Trimestre int(11),
    ID_Eleve int(11),
    Appreciation_Bulletin varchar(255) NOT NULL,
    FOREIGN KEY (ID_Trimestre) REFERENCES Trimestre(ID_Trimestre),
    FOREIGN KEY (ID_Eleve) REFERENCES Eleve(ID_Eleve)
);

CREATE TABLE DetailBulletin(
    ID_DetailBulletin int(11) PRIMARY KEY AUTO_INCREMENT,
    Moyenne_Enseignement float NOT NULL,
    ID_Bulletin int(11),
    ID_Enseignement int(11),
    Appreciation_DetailBulletin varchar(255) NOT NULL,
    FOREIGN KEY (ID_Bulletin) REFERENCES Bulletin (ID_Bulletin),
    FOREIGN KEY (ID_Enseignement) REFERENCES Enseignement(ID_Enseignement)
);

CREATE TABLE Devoir(
    ID_Devoir int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_DetailBulletin int(11),
    Note int(11) NOT NULL,
    Appreciation_Devoir varchar(255) NOT NULL,
    FOREIGN KEY (ID_DetailBulletin) REFERENCES DetailBulletin(ID_DetailBulletin)
);

CREATE TABLE Discipline(
    ID_Discipline int(11) PRIMARY KEY AUTO_INCREMENT,
    Nom_Discipline varchar(255) NOT NULL
);

CREATE TABLE Enseignement(
    ID_Enseignement int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_Classe int(11),
    ID_Discipline int(11),
    ID_Enseignant int(11),
    FOREIGN KEY (ID_Classe) REFERENCES Classe(ID_Classe),
    FOREIGN KEY (ID_Discipline) REFERENCES Discipline(ID_Discipline),
    FOREIGN KEY (ID_Enseignant) REFERENCES Enseignant(ID_Enseignant)
);

CREATE TABLE Enseignant(
    ID_Enseignant int(11) PRIMARY KEY AUTO_INCREMENT,
    Nom varchar(255) NOT NULL,
    Prenom varchar(255) NOT NULL,
    Login varchar(255) NOT NULL,
    Mdp varchar(255) NOT NULL
);

CREATE TABLE Eleve(
    ID_Eleve int(11) PRIMARY KEY AUTO_INCREMENT,
    Nom varchar(255) NOT NULL,
    Prenom varchar(255) NOT NULL,
    Login varchar(255) NOT NULL,
    Mdp varchar(255) NOT NULL,
    ID_Classe int(11),
    FOREIGN KEY (ID_Classe) REFERENCES Classe(ID_Classe)
);

INSERT INTO Ecole VALUES (1, 'Ece Paris', 1919);

INSERT INTO Enseignant VALUES (1, 'Rossard', 'Jacques', 'JacquesRossard', 'oklm');
INSERT INTO Enseignant VALUES (2, 'Cabrel', 'Francis', 'FrancisCabrel', 'eaucalme');
INSERT INTO Enseignant VALUES (3, 'Lacour', 'Bernard', 'BernardLacour', 'calmwater');

INSERT INTO Eleve VALUES (1, 'Lemercier', 'Thomas', 'ThomasLemercier', 'couscous1', 1);
INSERT INTO Eleve VALUES (2, 'Devincre', 'Leonard', 'LeonardDevincre', 'couscous2', 1);
INSERT INTO Eleve VALUES (3, 'Aymard', 'Victor', 'VictorAymard', 'couscous3', 2);

INSERT INTO AnneeScolaire VALUES (1, 2018, 2019);

INSERT INTO Trimestre VALUES (1, 1, '2018-09-01', '2018-12-01', 1);
INSERT INTO Trimestre VALUES (2, 2, '2019-01-01', '2019-04-01', 1);
INSERT INTO Trimestre VALUES (3, 3, '2019-04-01', '2018-07-01', 1);

INSERT INTO Classe VALUES (1, '6emeA', 1, 1);
INSERT INTO Classe VALUES (2, '6emeB', 1, 1);

INSERT INTO Discipline VALUES (1, 'Maths');
INSERT INTO Discipline VALUES (2, 'Francais');
INSERT INTO Discipline VALUES (3, 'Musique');

INSERT INTO Enseignement VALUES (1, 1, 1, 3);
INSERT INTO Enseignement VALUES (2, 1, 2, 2);
INSERT INTO Enseignement VALUES (3, 1, 3, 1);
INSERT INTO Enseignement VALUES (4, 2, 1, 3);
INSERT INTO Enseignement VALUES (5, 2, 2, 2);
INSERT INTO Enseignement VALUES (6, 2, 3, 1);

INSERT INTO Bulletin VALUES (1, 15, 1, 1, 'OK');
INSERT INTO DetailBulletin VALUES (1, 12, 1, 1, 'Ca passe');
INSERT INTO Devoir VALUES (1, 1, 12, 'Ca passe');
INSERT INTO DetailBulletin VALUES (2, 15, 1, 2, 'Bien');
INSERT INTO Devoir VALUES (2, 2, 15, 'Bien');
INSERT INTO DetailBulletin VALUES (3, 19, 1, 3, 'TB');
INSERT INTO Devoir VALUES (3, 3, 19, 'TB');

INSERT INTO Bulletin VALUES (2, 16, 1, 2, 'Bien');
INSERT INTO DetailBulletin VALUES (4, 11, 2, 1, 'Moyen');
INSERT INTO Devoir VALUES (4, 4, 11, 'Moyen');
INSERT INTO DetailBulletin VALUES (5, 18, 2, 2, 'TB');
INSERT INTO Devoir VALUES (5, 5, 18, 'TB');
INSERT INTO DetailBulletin VALUES (6, 17, 2, 3, 'Bien');
INSERT INTO Devoir VALUES (6, 6, 17, 'Bien');

INSERT INTO Bulletin VALUES (3, 13, 1, 3, 'Assez Bien');
INSERT INTO DetailBulletin VALUES (7, 9, 3, 1, 'Difficulte');
INSERT INTO Devoir VALUES (7, 7, 9, 'DIfficulte');
INSERT INTO DetailBulletin VALUES (8, 16, 3, 2, 'Bien');
INSERT INTO Devoir VALUES (8, 8, 16, 'Bien');
INSERT INTO DetailBulletin VALUES (9, 12, 3, 3, 'Assez Bien');
INSERT INTO Devoir VALUES (9, 9, 12, 'Assez Bien');




