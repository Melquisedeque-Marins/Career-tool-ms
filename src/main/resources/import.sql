INSERT INTO tb_user (first_name, last_name, birth_date, email, password) VALUES ('melck', 'Marins', '1989-03-01', 'melck@email.com', '$2a$10$ZZ./S5htgyr2hhKo07jYueZZchGDT8.JFum9YyAY0O7FBv.KtaMO6');
INSERT INTO tb_role (authority) VALUES ('ROLE_ADMIN');
INSERT INTO tb_role (authority) VALUES ('ROLE_CLIENT');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);