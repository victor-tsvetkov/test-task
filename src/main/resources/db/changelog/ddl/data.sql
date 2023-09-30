--liquibase formatted sql
--changeset tsvetkov:create-tables

create table if not exists users (
    id uuid default gen_random_uuid() primary key not null,
    name varchar,
    age integer,
    password varchar
);

create table if not exists houses (
    id uuid default gen_random_uuid() primary key not null,
    address text,
    id_owner uuid references users(id) not null
);