drop table abonnement

Create table abonnement (
	abonneenaam  varchar(255) not null,
    dienstnaam  varchar(255) not null,
    abonneedelen1  varchar(255)  null,
	abonneedelen2  varchar(255)  null,  
	startdatum   date   not null,
    verdubbeld   boolean    not null,
    abonnementsoort enum('MAAND', 'HALFJAAR', 'JAAR'),
    abonnementstatus enum('PROEF', 'ACTIEF', 'OPGEZEGD'),
    primary key (abonneenaam, dienstnaam),
    foreign key (abonneenaam) references abonnee(abonneenaam) on delete cascade on update cascade,
    foreign key (abonneedelen1) references abonnee(abonneenaam) on delete cascade on update cascade,
    foreign key (abonneedelen2) references abonnee(abonneenaam) on delete cascade on update cascade,
    foreign key (dienstnaam) references dienst(dienstnaam) on delete cascade on update cascade
);


insert into abonnement (abonneenaam, dienstnaam, abonneedelen1, abonneedelen2, startdatum, verdubbeld, abonnementsoort, abonnementstatus)
values("Jorg Lubbers", "Mobiele telefonie 100", "Ege Saraydar", "Jordy Veldhuizen", "2016-01-01", false, 'MAAND', 'ACTIEF'),
("Jorg Lubbers", "HBO Plus", null, null, "2016-02-05", true, 'JAAR', 'ACTIEF'),
("Jordy Veldhuizen", "Mobiele telefonie 250", "Ege Saraydar", null, "2015-01-01", false, 'MAAND', 'ACTIEF'),
("Ege Saraydar", "Eredivisie Live 1,2,3,4 en 5", "Jorg Lubbers", null, "2013-10-11", true, 'HALFJAAR', 'ACTIEF'),
("Ege Saraydar", "Glasvezel-internet", "Jorg Lubbers", null, "2016-08-21", false, 'MAAND', 'PROEF'),
("Jorg Lubbers", "Kabel-internet", "Jorg Lubbers", null, "2015-03-31", true, 'MAAND', 'ACTIEF'),
("Jordy Veldhuizen", "Mobiele telefonie 100", "Jorg Lubbers", null, "2016-01-01", true, 'HALFJAAR', 'PROEF');