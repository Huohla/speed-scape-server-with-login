DROP TABLE IF EXISTS product_transaction_ref;
DROP TABLE IF EXISTS transaction;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS sub_category;
DROP TABLE IF EXISTS category;
DROP TABLE IF EXISTS game_user;

CREATE TABLE IF NOT EXISTS game_user (
    id uuid primary key,
    username varchar(255) not null,
    email varchar(320) not null,
    password varchar(255) not null,
    points bigint not null default 0,
    role text not null,

    UNIQUE (username),
    UNIQUE (email)
);

CREATE TABLE IF NOT EXISTS category (
    id uuid primary key,
    name text not null,

    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS sub_category (
    id uuid primary key,
    name text not null,
    parent_id uuid references category (id),

    UNIQUE (name)
);

CREATE TABLE IF NOT EXISTS product (
    id uuid primary key,
    name text not null,
    price int not null,
    description text not null,
    image uuid not null,
    sub_category uuid not null references sub_category (id)
);

CREATE TABLE IF NOT EXISTS transaction (
    id uuid primary key,
    user_id uuid references game_user (id) not null,
    type text not null
);

CREATE TABLE IF NOT EXISTS product_transaction_ref (
    id uuid primary key,
    product_id uuid not null references product (id),
    transaction_id uuid not null references transaction (id),

    UNIQUE (product_id, transaction_id)
);
