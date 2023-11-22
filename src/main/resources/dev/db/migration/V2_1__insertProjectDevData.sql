INSERT INTO users(id,user_name,password,email,created_at)VALUES (0,'JessRod','jess123','jessrod@gmail.com','2023-11-20 10:30:00.123456');
INSERT INTO rol(id,name) VALUES (0,'estudiante');
INSERT INTO user_rol(id,active,created_at,user_id,rol_id) VALUES (0,true,'2023-11-20 10:30:00.123456',0,0);
INSERT INTO user_detail(id,first_name,last_name,age,birth_day,user_id) VALUES (0,'Jessica','Rodriguez',23,'2023-11-20',0);