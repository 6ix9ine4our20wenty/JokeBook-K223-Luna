BEGIN;

Insert Into Role(role_name) values ('Joker');

Insert Into User(username, password, roleidfs_role_id) values('Tester', '12345', 1);

INSERT INTO `jokedb`.`category` (`category_id`, `category_name`) VALUES ('1', 'flatjokes');
INSERT INTO `jokedb`.`joke` (`joke_id`, `joke_name`, `categoryidfs_category_id`) VALUES ('1', 'Wie nennt man einen Aal, der immer geradeaus schwimmt?... LINEAAL!', '1');
INSERT INTO `jokedb`.`joke` (`joke_id`, `joke_name`, `categoryidfs_category_id`) VALUES ('2', 'Was ist blau und steht am Strassenrand?... Eine Frostituierte!!', '1');
INSERT INTO `jokedb`.`joke` (`joke_id`, `joke_name`, `categoryidfs_category_id`) VALUES ('3', 'Welche Sprache spricht man in der Sauna?... Schwitzerdeutsch!', '1');
INSERT INTO `jokedb`.`joke` (`joke_id`, `joke_name`, `categoryidfs_category_id`) VALUES ('4', 'Wie nennt man Albino Mammut?...Hellmut!', '1');


COMMIT;