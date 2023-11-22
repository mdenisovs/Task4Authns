INSERT INTO customers (name, contact_name, email, phone) values ('Acme', 'Wylie Coyote', 'wcoyote@acme.com', '1-515-555-2348');
INSERT INTO customers (name, contact_name, email, phone)
values ('Spacely Space Sprockets', 'George Jettson', 'gjettson@spacely.com', '1-515-555-2350');
INSERT INTO customers (name, contact_name, email, phone)
values ('Callahan Auto', 'Thomas Callhan', 'tcallahan@callhhanauto.com', '1-515-555-2333');
INSERT INTO customers (name, contact_name, email, phone)
values ('Dundler Mifflin Inc', 'Michael Scott', 'mscott@dundlermifflin.com', '1-515-555-2320');
INSERT INTO customers (name, contact_name, email, phone)
values ('Stark Industries', 'Tony Stark', 'tstark@stark.com', '1-515-555-7777');
INSERT INTO customers (name, contact_name, email, phone)
values ('Initech', 'Peter Gibbons', 'pgibbons@initec.com', '1-515-555-0666');
INSERT INTO customers (name, contact_name, email, phone)
values ('Wayne Enterprises', 'Bruce Wayne', 'bwayne@wayne.com', '1-515-555-1111');

INSERT INTO users (username, password, enabled)
values ('user1', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', true);
INSERT INTO users (username, password, enabled)
values ('user2', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', true);
INSERT INTO users (username, password, enabled)
values ('admin', '{bcrypt}$2a$10$XlkdPQQhYcolx8bgp6nL3uNvDs8ZwDXA4KFaDencZsIhjMQO3j5lq', true);


INSERT INTO authorities (username, authority)
values ('user1', 'ROLE_USER');
INSERT INTO authorities (username, authority)
values ('user1', 'VIEW_INFO');
INSERT INTO authorities (username, authority)
values ('user2', 'ROLE_USER');
INSERT INTO authorities (username, authority)
values ('user2', 'VIEW_ADMIN');

INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_USER');
INSERT INTO authorities (username, authority)
values ('admin', 'ROLE_ADMIN');
INSERT INTO authorities (username, authority)
values ('admin', 'VIEW_INFO');
INSERT INTO authorities (username, authority)
values ('admin', 'VIEW_ADMIN');