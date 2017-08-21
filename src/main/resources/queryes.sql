INSERT INTO user_activ (imei_fk, song_date, song_name_artist, song_name, song_name_album, song_name_genre, song_name_author, song_duration, song_status)
VALUES (123456, 20170802, 'Deftones', 'Beware', 'Test Album', 'Alternative Rock', 'Deftones', 87, 1);

INSERT INTO user (imei) VALUES (1);
INSERT INTO user (imei) VALUES (2);
INSERT INTO user (imei) VALUES (3);
INSERT INTO user (imei) VALUES (4);

CREATE TABLE user (
  id   INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
  imei INT(11)        NOT NULL,
  PRIMARY KEY (imei)
);

CREATE TABLE user_activ (
  id               INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
  imei_fk             INT(11)        NOT NULL,
  song_date        VARCHAR(45)    NOT NULL,
  song_name_artist VARCHAR(45),
  song_name        VARCHAR(45),
  song_name_album  VARCHAR(45),
  song_name_genre  VARCHAR(45),
  song_name_author VARCHAR(45),
  song_duration    INT(11)        NOT NULL,
  song_status      INT(11)        NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (imei_fk) REFERENCES user (imei)
);

CREATE TABLE album (
  id                    INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
  id_user_fk            INT(11)        NOT NULL,
  album                 VARCHAR(45),
  album_n               INT(11)        NOT NULL,
  album_reward_n        DOUBLE(7, 7),
  album_reward_plus_one DOUBLE(7, 7),
  time_learning         DOUBLE(7, 7),
  PRIMARY KEY (id),
  FOREIGN KEY (id_user_fk) REFERENCES user (id)
);

CREATE TABLE author (
  id                     INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
  id_user_fk             INT(11)        NOT NULL,
  author                 VARCHAR(45),
  author_n               INT(11)        NOT NULL,
  author_reward_n        DOUBLE(7, 7),
  author_reward_plus_one DOUBLE(7, 7),
  time_learning          DOUBLE(7, 7),
  PRIMARY KEY (id),
  FOREIGN KEY (id_user_fk) REFERENCES user (id)
);

CREATE TABLE genre (
  id                    INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
  id_user_fk            INT(11)        NOT NULL,
  genre                 VARCHAR(45),
  genre_n               INT(11)        NOT NULL,
  genre_reward_n        DOUBLE(7, 7),
  genre_reward_plus_one DOUBLE(7, 7),
  time_learning         DOUBLE(7, 7),
  PRIMARY KEY (id),
  FOREIGN KEY (id_user_fk) REFERENCES user (id)
);

CREATE TABLE track (
  id                    INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
  id_user_fk            INT(11)        NOT NULL,
  track_date            VARCHAR(45)    NOT NULL,
  track_name_artist     VARCHAR(45), #UNIQUE,
  track_name            VARCHAR(45), #UNIQUE,
  track_n               INT(11)        NOT NULL,
  track_reward_n        DOUBLE(7, 7),
  track_reward_plus_one DOUBLE(7, 7),
  time_learning         DOUBLE(7, 7),
  PRIMARY KEY (id_user_fk, track_name_artist, track_name),
  FOREIGN KEY (id_user_fk) REFERENCES user (id)
);

-- # для начал только с оценкой трека. После с оценками жанра, альбома и автора.
CREATE TABLE for_recommendation (
  id             INT(11) UNIQUE NOT NULL AUTO_INCREMENT,
  id_user_fk     INT(11)        NOT NULL,
  id_track_fk    INT(11)        NOT NULL,
  id_genre_fk    INT(11)        NOT NULL,
  id_album_fk    INT(11)        NOT NULL,
  id_author_fk   INT(11)        NOT NULL,
  track_reward_n DOUBLE(7, 7),
  PRIMARY KEY (id),
  FOREIGN KEY (id_user_fk) REFERENCES user (id),
  FOREIGN KEY (id_track_fk) REFERENCES track (id),
  FOREIGN KEY (id_genre_fk) REFERENCES genre (id),
  FOREIGN KEY (id_album_fk) REFERENCES album (id),
  FOREIGN KEY (id_author_fk) REFERENCES author (id)
);

DROP TABLE for_recommendation;
DROP TABLE author;
DROP TABLE album;
DROP TABLE track;
DROP TABLE genre;
DROP TABLE user_activ;
DROP TABLE user;


INSERT INTO user (imei) VALUES (1);
INSERT INTO user (imei) VALUES (123456);

INSERT INTO user (imei) VALUES (234);

INSERT INTO user_activ (imei_fk, song_date, song_name_artist, song_name, song_name_album, song_name_genre, song_name_author, song_duration, song_status)
VALUES (1, 2017 / 01 / 01, 'oneArtistTest', 'oneSongTest', 'oneAlbumTest', 'oneGenreTest', 'oneAuthorTest', 67, 0);

INSERT INTO user_activ (imei_fk, song_date, song_name_artist, song_name, song_name_album, song_name_genre, song_name_author, song_duration, song_status)
VALUES (123456, 2017 / 01 / 01, 'oneArtistTest', 'oneSongTest', 'oneAlbumTest', 'oneGenreTest', 'oneAuthorTest', 67, 0);

SELECT
  user.imei,
  user_activ.id
FROM user
  LEFT JOIN user_activ USING (imei_fk);


INSERT INTO track (id_user_fk, track_date, track_name_artist, track_name, track_reward_n, track_reward_plus_one, time_learning)
VALUES (19, 2017 / 01 / 01, 'Deftones', 'Beware', 0.0, 0.0, 0.0);
INSERT INTO track (id_user_fk, track_date, track_name_artist, track_name, track_reward_n, track_reward_plus_one, time_learning)
VALUES (1, 2017 / 01 / 01, 'Deftones', 'Knife Party', 0.0, 0.0, 0.0);

SELECT *
FROM user_activ;

SELECT id_user_fk, user.imei, song_duration, song_status
FROM track JOIN user JOIN user_activ
     WHERE track.id_user_fk = user.id
 AND user.imei IN (SELECT imei FROM user_activ) AND track.id_user_fk = 13 AND track.track_name_artist = 'oneArtistTest' AND track.track_name='oneSongTest'
GROUP BY user.imei;

SELECT *
  FROM user u JOIN user_activ s ON u.imei = s.imei_fk WHERE s.imei_fk=2;


SELECT imei
  from user WHERE user.id = 2;

insert into track(id_user_fk, track_date, track_name_artist, track_name, track_n, track_reward_n, track_reward_plus_one, time_learning)
VALUES (1, 20171111, 'Placebo', 'Battle for the sun', 1, NULL , NULL , NULL );