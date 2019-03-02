drop table if exists user;
drop table if exists country;
drop table if exists client;

create table user (
	user_id		identity,
	username	VARCHAR(100)	not null,
	password	VARCHAR(100)	not null,
	unique key us_username (username)
);

create table country (
	country_id		identity,
	country_name	varchar(100),
	unique key country_name (country_name)
);

create table client (
	client_id	identity,
	user_id		bigint			not null,
	first_name	varchar(100)	not null,
	last_name	varchar(100)	not null,
	username	varchar(100)	not null,
	email		varchar(255)	not null,
	address		varchar(1000)	not null,
	country_id	bigint			not null,
	foreign key (user_id) references user(user_id),
	foreign key (country_id) references country(country_id),
	unique key cl_username (username)
);