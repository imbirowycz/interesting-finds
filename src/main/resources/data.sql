insert INTO user(email, first_name, last_name, nick, password)
  VALUES ("email@pl.pl","andrzej","imbirowycz","Gringo", "12345"),
         ("orane@pl.pl","maks","Owczarek","Master", "12345");

insert into user_role(role, description)
  VALUES ("ROLE_USER", "default role for user");

insert into discovery(description, down_vote, title, upvote, url, ranking, user_id)
VALUES("Strona internetowa o:", 2, "Olx", 1, "http://google.pl", 5, 1),
("Strona internetowa o:", 0, "Facebook", 5, "http://google.pl", 6, 1),
("Strona internetowa o:", 1, "Allegro", 1, "http://google.pl", 1, 2),
("Strona internetowa o:", 4, "Trivago", 2, "http://google.pl", 3, 2);
