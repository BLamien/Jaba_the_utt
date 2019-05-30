CREATE TABLE Ecole(
    ID_Ecole int(11) PRIMARY KEY AUTO_INCREMENT,
	Nom_Ecole varchar(255) NOT NULL,
	Annee_Fondation int(11) NOT NULL
);

CREATE TABLE Classe(
    ID_Classe int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_Ecole int(11),
    ID_Niveau int(11),
    ID_AnneeScolaire int(11),
    FOREIGN KEY (ID_Ecole) REFERENCES Ecole(ID_Ecole),
    FOREIGN KEY (ID_Niveau) REFERENCES Niveau(ID_Niveau),
    FOREIGN KEY (ID_AnneeScolaire) REFERENCES Ecole(ID_AnneeScolaire)
);

CREATE TABLE Effectif(
    ID_Effectif int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_Classe int(11),
    ID_Personne int(11),
    FOREIGN KEY (ID_Classe) REFERENCES Classe(ID_Classe),
    FOREIGN KEY (ID_Personne) REFERENCES Personne(ID_Personne)
);

CREATE TABLE Niveau(
    ID_Niveau int(11) PRIMARY KEY AUTO_INCREMENT,
    Nom_Niveau varchar(255) NOT NULL
);
CREATE TABLE AnneeScolaire(
    ID_AnneeScolaire int(11) PRIMARY KEY AUTO_INCREMENT,
    Debut_AnneeScolaire int(11) NOT NULL,
    Fin_AnneeScolaire int(11) NOT NULL
);

CREATE TABLE Trimestre(
    ID_Trimestre int(11) PRIMARY KEY AUTO_INCREMENT,
    Numero int(11) NOT NULL,
    Debut_Trimestre int(11) NOT NULL,
    Debut_Trimestre int(11) NOT NULL,
    ID_AnneeScolaire int(11),
    FOREIGN KEY (ID_AnneeScolaire) REFERENCES AnneeScolaire(ID_AnneeScolaire)
);

CREATE TABLE Bulletin(
    ID_Bulletin int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_Trimestre int(11),
    ID_Effectif int(11),
    Appreciation_Bulletin varchar(255) NOT NULL,
    FOREIGN KEY (ID_Trimestre) REFERENCES Trimestre(ID_Trimestre),
    FOREIGN KEY (ID_Effectif) REFERENCES Effectif(ID_Effectif)
);

CREATE TABLE DetailBulletin(
    ID_DetailBulletin int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_Bulletin int(11),
    ID_Enseignement int(11),
    Appreciation_DetailBulletin varchar(255) NOT NULL,
    FOREIGN KEY (ID_Bulletin) REFERENCES Bulletin (ID_Bulletin),
    FOREIGN KEY (ID_Cours) REFERENCES Enseignement(ID_Enseignement)
);

CREATE TABLE Evaluation(
    ID_Evaluation int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_DetailBulletin int(11),
    Note int(11) NOT NULL,
    Appreciation_Evaluation varchar(255) NOT NULL,
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
    ID_Personne int(11),
    FOREIGN KEY (ID_Classe) REFERENCES Classe(ID_Classe),
    FOREIGN KEY (ID_Discipline) REFERENCES Discipline(ID_Discipline),
    FOREIGN KEY (ID_Personne) REFERENCES Personne(ID_Personne)
);

CREATE TABLE Personne(
    ID_Personne int(11) PRIMARY KEY AUTO_INCREMENT,
    Type_Personne varchar(255) NOT NULL,
    Nom varchar(255) NOT NULL,
    Prenom varchar(255) NOT NULL,
    Login varchar(255) NOT NULL,
    Mdp varchar(255) NOT NULL
);

CREATE TABLE Inscription(
    ID_Inscription int(11) PRIMARY KEY AUTO_INCREMENT,
    ID_Classe int(11),
    ID_Personne int(11),
    FOREIGN KEY (ID_Classe) REFERENCES Classe(ID_Classe),
    FOREIGN KEY (ID_Personne) REFERENCES Personne(ID_Personne)
);

