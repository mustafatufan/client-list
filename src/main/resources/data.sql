-- password: avalah
insert into user (username, password)
values ('egonraamat', '$2a$10$.OLAWuFla7VgmDLkNkZeaOdFZrEKGxMwHlzCpa0wjq.90Lp84XJvC');
insert into user (username, password)
values ('jooseptruu', '$2a$10$.OLAWuFla7VgmDLkNkZeaOdFZrEKGxMwHlzCpa0wjq.90Lp84XJvC');
insert into user (username, password)
values ('avalah', '$2a$10$.OLAWuFla7VgmDLkNkZeaOdFZrEKGxMwHlzCpa0wjq.90Lp84XJvC');

insert into country (country_name)
values ('Estonia');
insert into country (country_name)
values ('Latvia');
insert into country (country_name)
values ('Lithuania');

insert into client (client_username, username, first_name, last_name, email, address, country_id)
values ('mustafatufan', 'avalah', 'Mustafa', 'Tufan', 'mustafa.tufan@eesti.ee', 'Dede Efendi 15, Balcova, Izmir', 1);

insert into client (client_username, username, first_name, last_name, email, address, country_id)
values ('amyacker', 'avalah', 'Amy', 'Acker', 'amy.acker@eesti.ee', 'Bla bla 22, Tallinn', 1);

insert into client (client_username, username, first_name, last_name, email, address, country_id)
values ('michaelfassbender', 'avalah', 'Michael', 'Fassbender', 'mikey@eesti.ee', 'Easy Peasy 45, Tallinn', 1);