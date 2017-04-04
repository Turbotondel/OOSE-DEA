
Create table abonnee (
	abonneenaam varchar(255) not null,
    emailadres varchar(255)  not null,
    primary key (abonneenaam)
);

Create table dienst (
	bedrijf   varchar(255)not null,
    dienstnaam  varchar(255)not null,
    beschrijving varchar(255)not null,
    maandprijs  integer  not null,
    halfjaarprijs integer  not null,
    jaarprijs  integer not null,
    deelbaar  bit not null,
    verdubbelbaar bit not null,
    primary key (dienstnaam)
);


Create table abonnement (
	abonneenaam  varchar(255) not null,
    dienstnaam  varchar(255) not null,
    abonneedelen1  varchar(255)  null,
	abonneedelen2  varchar(255)  null,  
	startdatum   date   not null,
    verdubbeld   bit    not null, 
    abonnementsoort VARCHAR(50)NOT NULL CHECK(abonnementsoort IN ('MAAND', 'HALFJAAR', 'JAAR')),
    abonnementstatus VARCHAR(50)NOT NULL CHECK(abonnementstatus IN('PROEF', 'ACTIEF', 'OPGEZEGD')),
    primary key (abonneenaam, dienstnaam),
    foreign key (abonneenaam) references abonnee(abonneenaam),
    foreign key (abonneedelen1) references abonnee(abonneenaam) ,
    foreign key (abonneedelen2) references abonnee(abonneenaam),
    foreign key (dienstnaam) references dienst(dienstnaam)
);


insert into abonnee (abonneenaam, emailadres)
values('Jorg Lubbers', 'jorglubbers@hotmail.com'),
('Ege Saraydar', 'egesaraydar@hotmail.com'),
('Jordy Veldhuizen', 'jordyveldhuizen@hotmail.com');


insert into dienst (bedrijf, dienstnaam, beschrijving, maandprijs, halfjaarprijs, jaarprijs, deelbaar, verdubbelbaar)
values('Vodafone', 'Mobiele telefonie 100', '100 minuten, SMS of GB', 5, 25, 45, 0, 0),
('Vodafone', 'Mobiele telefonie 250', '250 minuten, SMS of GB', 10, 50, 90, 0, 1),
('Vodafone', 'Glasvezel-internet', 'download 500 Mbps', 40, 200, 360, 0, 1),
('Ziggo', 'Kabel-internet', 'download 300 Mbps', 30, 150, 270, 0, 0),
('Ziggo', 'Eredivisie Live 1,2,3,4 en 5', 'beschrijving', 10, 50, 90, 1, 0),
('Ziggo', 'HBO Plus', 'HBO Plus - beschrijving', 15, 75, 135, 1, 0);

insert into abonnement (abonneenaam, dienstnaam, abonneedelen1, abonneedelen2, startdatum, verdubbeld, abonnementsoort, abonnementstatus)
values('Jorg Lubbers', 'Mobiele telefonie 250', 'Ege Saraydar', 'Jordy Veldhuizen', '2016-01-01', 0, 'MAAND', 'ACTIEF'),
('Jorg Lubbers', 'Glasvezel-internet', null, null, '2016-02-05', 1, 'JAAR', 'ACTIEF'),
('Jordy Veldhuizen', 'Mobiele telefonie 250', 'Ege Saraydar', null, '2015-01-01', 0, 'MAAND', 'ACTIEF'),
('Ege Saraydar', 'Eredivisie Live 1,2,3,4 en 5', 'Jorg Lubbers', null, '2013-10-11', 1, 'HALFJAAR', 'ACTIEF'),
('Ege Saraydar', 'Glasvezel-internet', 'Jorg Lubbers', null, '2016-08-21', 0, 'MAAND', 'PROEF'),
('Jorg Lubbers', 'Kabel-internet', 'Jorg Lubbers', null, '2015-03-31', 1, 'MAAND', 'ACTIEF'),
('Jordy Veldhuizen', 'Mobiele telefonie 100', 'Jorg Lubbers', null, '2016-01-01', 1, 'HALFJAAR', 'PROEF')



