create table users(
    id varchar(36) not null,
    username varchar(255) not null,
    email varchar(255) not null,
    password mediumtext,

    constraint user_pk primary key(id) default uuid()
);

create table address(
    id int not null primary key auto_increment,
    street varchar(255) ,
    postal_code varchar(255),
    neighborhood varchar(255),
    number int,
    user_id varchar(36) not null,

    constraint address_pk primary key(id) default uuid(),
    constraint address_user_fk foreign key(user_id) references users(id)
);


create table roles(
    id int not null primary key auto_increment,
    description varchar(90),
    user_id varchar(36) not null

    constraint role_pk primary key(id) auto_increment,
    constraint role_user_fk foreign key(user_id) references users(id)
);