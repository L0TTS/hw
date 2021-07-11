create table Course
(
    id         serial primary key,
    name       varchar(20) not null,
    time  varchar(20) not null,
    id_teacher integer     not null
);

create table Lesson
(
    id        serial primary key,
    name      varchar(20) not null,
    time      varchar(20) not null,
    id_course integer     not null
);

create table Teacher
(
    id      serial primary key,
    name    varchar(20) not null,
    surname varchar(20) not null,
    exp     varchar(20) not null
);

create table Student
(
    id       serial primary key,
    name     varchar(20) not null,
    surname  varchar(20) not null,
    numGroup varchar(20) not null
);

create table public.student_course
(
    id         integer not null,
    id_course  integer not null,
    id_student integer not null
);