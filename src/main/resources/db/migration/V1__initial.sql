-- create user table
create table "user" (
                        id bigint primary key not null,
                        user_name varchar(150) not null,
                        password varchar(150) not null,
                        email varchar(150) not null ,
                        created_at timestamp
);
-- create a sequence for user ide
create sequence user_sequence as integer increment 1;

-- create user_detail table
create table user_detail (
                             id bigint primary key not null,
                             first_name varchar(100) not null,
                             last_name varchar(100) not null,
                             age integer,
                             birth_day date,
                             user_id bigint
);
-- create a sequence for user ide
create sequence user_detail_sequence as integer increment 1;

alter table user_detail add constraint FK_User_Detail_RefUser foreign key (user_id)
    references "user"(id) on delete restrict on update restrict;

----------------- create rol table
create table rol (
                     id integer primary key not null,
                     name varchar(100) not null
);
-- create a sequence for user ide
create sequence rol_sequence as integer increment 1;

-- create user table
create table user_rol (
                          id integer primary key not null,
                          active boolean not null,
                          created_at timestamp not null,
                          user_id bigint,
                          rol_id integer
);
-- create a sequence for user ide
create sequence user_rol_sequence as integer increment 1;

alter table user_rol add constraint FK_User_Rol_RefUser foreign key (user_id)
    references "user"(id) on delete restrict on update restrict;

alter table user_rol add constraint FK_User_Rol_RefRol foreign key (rol_id)
    references rol(id) on delete restrict on update restrict;