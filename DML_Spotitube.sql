USE Spotitube;

INSERT INTO PLaylist VALUES ('Flamiee', 'Speeksel'),
							('Turbotondel', 'Joni'),
                            ('Mephisto', 'Vape');

INSERT INTO Track VALUES 	('Ed Sheeran', 'Shape of You', 'https://www.youtube.com/watch?v=JGwWNGJdvx8', 4.24),
							('PSY', 'Gangnam Style', 'https://www.youtube.com/watch?v=9bZkp7q19f0', 4.13),
                            ('Macklemore & Ryan Lewis', 'Cant hold us', 'https://www.youtube.com/watch?v=2zNSgSzhBfM', 7.17),
                            ('Queen', 'Radio Ga Ga', 'https://www.youtube.com/watch?v=azdwsXLmrHE', 5.53);

INSERT INTO Video VALUES	('Ed Sheeran', 'Shape of You', 10, CURDATE(), 'Nieuwe track van Ed Sheeran'),
							('PSY', 'Gangnam Style', 100, CURDATE(), 'Nieuwe track van PSY');
                            
INSERT INTO Song VALUES		('Macklemore & Ryan Lewis', 'Cant hold us', 'The Heist'),
							('Queen', 'Radio Ga Ga', 'The Works');
                            
INSERT INTO Availability VALUES ('Ed Sheeran', 'Shape of You', true),
								('PSY', 'Gangnam Style', false);

INSERT INTO TrackinPlaylist VALUES ('Ed Sheeran', 'Shape of You', 'Flamiee', 'Speeksel'),
								   ('Macklemore & Ryan Lewis', 'Cant hold us', 'Flamiee', 'Speeksel'),
                                   ('Macklemore & Ryan Lewis', 'Cant hold us', 'Turbotondel', 'Joni');