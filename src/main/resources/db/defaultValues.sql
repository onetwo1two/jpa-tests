DELETE FROM users;
DELETE FROM posts;
DELETE FROM comments;

ALTER SEQUENCE users_id_seq RESTART WITH 1;
ALTER SEQUENCE posts_id_seq RESTART WITH 1;
ALTER SEQUENCE comments_id_seq RESTART WITH 1;

INSERT INTO users (id, name) VALUES (1, 'user1');

INSERT INTO posts (id, title, user_id) VALUES (1, 'post1', 1);
INSERT INTO posts (id, title, user_id) VALUES (2, 'post2', 1);
INSERT INTO posts (id, title, user_id) VALUES (3, 'post3', 1);

INSERT INTO comments (id, text, post_id) VALUES (1, 'comment1', 1);
INSERT INTO comments (id, text, post_id) VALUES (2, 'comment2', 1);
INSERT INTO comments (id, text, post_id) VALUES (3, 'comment3', 2);
INSERT INTO comments (id, text, post_id) VALUES (4, 'comment4', 2);
