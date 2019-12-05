
create schema if not exists DB_BOOKS;



create table DB_BOOKS.AUTHORS
(
    NAME     VARCHAR(255) not null,
    AUTHORID INTEGER  auto_increment
);

create unique index DB_BOOKS.AUTHORS_AUTHORID_UINDEX
    on DB_BOOKS.AUTHORS (AUTHORID);

create unique index DB_BOOKS.PRIMARY_KEY_4
    on DB_BOOKS.AUTHORS (AUTHORID);

alter table DB_BOOKS.AUTHORS
    add constraint AUTHORS_PK
        primary key (AUTHORID);




create table DB_BOOKS.PUBLISHING
(
    NAME         VARCHAR(255) not null,
    PUBLISHINGID INTEGER auto_increment,
    constraint PUBLISHINGS_PK
        primary key (PUBLISHINGID)
);



create table DB_BOOKS.BOOKS
(
    TITLE      VARCHAR(255)   not null,
    AUTHOR     INTEGER        not null,
    PUBLISHING INTEGER        not null,
    YEAR       INTEGER        not null,
    COST       DECIMAL(15, 2) not null,
    BOOKID     INTEGER auto_increment,
    constraint BOOKS_AUTHORS_AUTHORID_FK
        foreign key (AUTHOR) references DB_BOOKS.AUTHORS,
    constraint BOOKS_PUBLISHINGS_PUBLISHINGID_FK
        foreign key (PUBLISHING) references DB_BOOKS.PUBLISHING
);

create unique index DB_BOOKS.BOOKS_BOOKID_UINDEX
    on DB_BOOKS.BOOKS (BOOKID);

create unique index DB_BOOKS.PRIMARY_KEY_3
    on DB_BOOKS.BOOKS (BOOKID);

alter table DB_BOOKS.BOOKS
    add constraint BOOKS_PK
        primary key (BOOKID);

create unique index DB_BOOKS.PUBLISHINGS_PUBLISHINGID_UINDEX
    on DB_BOOKS.PUBLISHING (PUBLISHINGID);

