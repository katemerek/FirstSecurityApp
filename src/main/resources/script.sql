create table person
(
    id            integer generated by default as identity
        primary key,
    username      varchar(30)  not null,
    year_of_birth integer      not null,
    password      varchar(500) not null,
    role          varchar(100) not null
);


