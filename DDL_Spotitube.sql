DROP DATABASE Spotitube;

CREATE DATABASE Spotitube;

USE Spotitube;

CREATE TABLE Playlist (
	owner				varchar(255)	NOT NULL,
    name				varchar(255)	NOT NULL,
    PRIMARY KEY			(owner, name)
);

CREATE TABLE Track (
	performer			varchar(255)	NOT NULL,
    title				varchar(255)	NOT NULL,
    url					varchar(512)	NOT NULL,
    duration			float			NOT NULL,
    PRIMARY KEY			(performer, title)
);

CREATE TABLE Song (
	performer			varchar(255)	NOT NULL,
    title				varchar(255)	NOT NULL,
    album				varchar(255)	NOT NULL,
    PRIMARY KEY			(performer, title),
    FOREIGN KEY			(performer, title) REFERENCES Track(performer, title)
);

CREATE TABLE Video (
	performer			varchar(255)	NOT NULL,
    title				varchar(255)	NOT NULL,
	playCount			int				NOT NULL,
    publicationDate		DATE			NOT NULL,
    description			varchar(512)	NOT NULL,
    PRIMARY KEY			(performer, title),
    FOREIGN KEY			(performer, title) REFERENCES Track(performer, title)
);

CREATE TABLE Availability (
	performer			varchar(255)	NOT NULL,
    title				varchar(255)	NOT NULL,
	offlineAvailable	boolean			NOT NULL,
    PRIMARY KEY			(performer, title),
    FOREIGN KEY			(performer, title) REFERENCES Track(performer, title)
);

CREATE TABLE TrackinPlaylist(
	performer			varchar(255)	NOT NULL,
    title				varchar(255)	NOT NULL,
	owner				varchar(255)	NOT NULL,
    name				varchar(255)	NOT NULL,
    PRIMARY KEY 		(performer, title, owner, name),
	FOREIGN KEY			(performer, title) REFERENCES Track(performer, title),
    FOREIGN KEY			(owner, name) REFERENCES Playlist(owner, name)
)