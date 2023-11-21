INSERT INTO "user"(id,user_name,password,email,created_at)VALUES (1,'JessRod','jess123','jessrod@gmail.com','2023-11-20 10:30:00.123456');
INSERT INTO rol(id,name) VALUES (1,'estudiante');
INSERT INTO user_rol(id,active,created_at,user_id,rol_id) VALUES (1,true,'2023-11-20 10:30:00.123456',1,1);
INSERT INTO user_detail(id,first_name,last_name,age,birth_day,user_id) VALUES (1,'Jessica','Rodriguez',23,'2023-11-20',1);