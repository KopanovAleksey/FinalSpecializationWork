drop database if exists HumanFriends;
create database HumanFriends;
use HumanFriends;

drop table if exists Cats;
create table Cats (
	id int auto_increment primary key,
    name varchar(45),
    birthDate date,
    commands varchar(100)
);
drop table if exists Dogs;
create table Dogs (
	id int auto_increment primary key,
    name varchar(45),
    birthDate date,
    commands varchar(100)
);
drop table if exists Hamsters;
create table Hamsters (
	id int auto_increment primary key,
    name varchar(45),
    birthDate date,
    commands varchar(100)
);
drop table if exists Horses;
create table Horses (
	id int auto_increment primary key,
    name varchar(45),
    birthDate date,
    commands varchar(100)
);
drop table if exists Donkeys;
create table Donkeys (
	id int auto_increment primary key,
    name varchar(45),
    birthDate date,
    commands varchar(100)
);
drop table if exists Camels;
create table Camels (
	id int auto_increment primary key,
    name varchar(45),
    birthDate date,
    commands varchar(100)
);
insert into Dogs (name, birthDate, commands)
values 
('Fido', '2020-01-01', 'Sit, Stay, Fetch'),
('Buddy', '2018-12-10', 'Sit, Paw, Bark'),
('Bella', '2019-11-11', 'Sit, Stay, Roll');

insert into Hamsters (name, birthDate, commands)
values 
('Hammy', '2021-03-10', 'Roll, Hide'),
('Peanut', '2021-08-01', 'Roll, Spin');

insert into Cats (name, birthDate, commands)
values 
('Wiskers', '2019-05-15', 'Sit, Pounce'),
('Smudge', '2020-02-20', 'Sit, Pounce, Scratch'),
('Oliver', '2020-06-30', 'Meow, Scratch, Jump');

insert into Horses (name,  birthDate, commands)
values 
('Thunder', '2015-07-21', 'Trot, Canter, Gallop'),
('Storm', '2014-05-05', 'Trot, Canter'),
('Blaze', '2016-02-29', 'Trot, Jump, Gallop');

insert into Camels (name,  birthDate, commands)
values 
('Sandy', '2016-11-03', 'Walk, Carry Load'),
('Dune', '2018-12-12', 'Walk, Sit'),
('Sahara', '2015-08-14', 'Walk, Run');

insert into Donkeys (name,  birthDate, commands)
values 
('Eeyore', '2017-09-18', 'Walk, Carry Load, Bray'),
('Burro', '2019-01-23', 'Walk, Bray, Kick');

delete from Camels;

select * from Horses
union
select * from Donkeys;

with Animals as ( 
select * from Horses
union
select * from Donkeys
union
select * from Cats
union
select * from Dogs
union
select * from Hamsters
union
select * from Camels
)
select *, (year(current_date())-year(birthDate) - 
case
	when month(birthDate) > month(current_date()) or 
		 month(birthDate) = month(current_date()) and day(birthdate) > day(current_date())
	then 1
	else 0
end) as Age from Animals 
having Age between 1 and 3;

with Animals as ( 
select *, 'Horse' as Type from Horses
union
select *, 'Donkey' from Donkeys
union
select *, 'Cat' from Cats
union
select *, 'Dog' from Dogs
union
select *, 'Hamster' from Hamsters
union
select *, 'Camel' from Camels
)
select id, name, Type, birthDate, commands  from Animals;
