drop table if exists author_books;
drop table if exists book;
drop table if exists author;

create table author(
                       id serial8,
                       name varchar(30) not null,
                       last_name varchar(30) not null,
                       primary key (id)
);
insert into author(name, last_name)
values ('Marta', 'Kors'),
       ('Bob', 'Mart');

create table book(
                     id serial8,
                     name_book varchar(50) not null,
                     date date not null,
                     primary key (id)
);
insert into book(name_book, date)
values ('sea', '2020-12-15'),
       ('soul', '2022-10-11');

create table author_books(
                             id serial8,
                             author_id int8,
                             book_id int8,
                             primary key (author_id, book_id),
                             foreign key (author_id) references author(id),
                             foreign key (book_id) references book(id)
);
insert into author_books(author_id, book_id)
values (1, 1),
       (1, 2),
       (2, 2);