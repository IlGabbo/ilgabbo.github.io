create database film;

use film;

create table genere (
    nome varchar(50),
    id int auto_increment primary key
);

create table film (
    id int auto_increment primary key,
    titolo varchar(50),
    sinossi varchar(50)
);

create table persona (
    id int auto_increment primary key,
    nome varchar(50),
    secondoNome varchar(50) default null,
    cognome varchar(50),
    dataN date

    categoria enum('attore', 'regista'),
);

create table intepreta (
    attore int,
    film int,

    primary key (attore, film),
    foreign key (film) references film(id),
    foreign key (attore) references persona(id)
);

create table regista (
    regista int,
    film int,

    primary key (regista, film),
    foreign key (film) references film(id),
    foreign key (regista) references persona(id)
);

create table generi (
    genere int,
    film int,

    primary key (genere, film),
    foreign key (film) references film(id),
    foreign key (genere) references genere(id)
)