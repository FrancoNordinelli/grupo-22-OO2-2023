use bd_smartcity;

insert into `user` values (1, '2023-06-25', true, '$2a$10$5rbU5WuZWvCvRLDD6yHBUuXW.0YZYd.q1b2vae54AEGhtnvaLNhj6',NOW(), 'administrador'); 

insert into `user_role` values (1, NOW(), 'ROLE_ADMIN', NOW(), 1); 

insert into `user` values (2, '2023-06-25', true, '$2a$10$5rbU5WuZWvCvRLDD6yHBUuXW.0YZYd.q1b2vae54AEGhtnvaLNhj6', NOW(), 'auditor'); 


insert into `user_role` values (2, NOW(), 'ROLE_USER', NOW(), 2);
 