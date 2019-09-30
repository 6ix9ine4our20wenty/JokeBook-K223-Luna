BEGIN;

Insert Into Role(role_name) values ('Joker');

Insert Into User(username, password, roleidfs_role_id) values('Tester', '12345', 1);


COMMIT;