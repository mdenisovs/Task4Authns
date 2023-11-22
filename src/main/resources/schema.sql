CREATE TABLE customers(
                          customer_id  bigint auto_increment primary key,
                          name         varchar(64)  not null,
                          contact_name varchar(128) not null,
                          email        varchar(128) not null,
                          phone        varchar(24)  not null
);

CREATE TABLE users
(
    username varchar_ignorecase(50) not null primary key,
    password varchar_ignorecase(500) not null,
    enabled  boolean not null
);

CREATE TABLE authorities
(
    authority_id  bigint auto_increment primary key,
    username  varchar_ignorecase(50) not null,
    authority varchar_ignorecase(50) not null,
    constraint fk_authorities_users foreign key (username) references users (username)
);

CREATE UNIQUE INDEX ix_auth_username on authorities (username, authority);