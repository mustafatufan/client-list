drop table if exists user;
drop table if exists country;
drop table if exists client;

create table user (
	username	varchar(100)	not null,
	password	varchar(100)	not null,
	constraint pk_username primary key (username)
);

create table country (
	country_id		identity,
	country_name	varchar(100)	not null,
	unique key uk_country_name (country_name)
);

create table client (
	client_username	varchar(100)	not null,
	username		varchar(100)	not null,
	first_name		varchar(100)	not null,
	last_name		varchar(100)	not null,
	email			varchar(255)	null,
	address			varchar(1000)	not null,
	country_id		bigint			not null,
	foreign key (username) references user(username),
	foreign key (country_id) references country(country_id),
	constraint pk_client_username primary key (client_username)
);