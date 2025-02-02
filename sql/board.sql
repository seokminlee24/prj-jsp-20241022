USE jsp;

CREATE TABLE board
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    title    VARCHAR(200)  NOT NULL,
    content  VARCHAR(5000) NOT NULL,
    writer   VARCHAR(200)  NOT NULL,
    inserted DATETIME      NOT NULL DEFAULT NOW()
);

SELECT *
FROM board
ORDER BY id DESC;

SELECT COUNT(*)
FROM board;
# 페이징 연습용 게시물 복붙
INSERT INTO board
    (title, content, writer)
SELECT title, content, writer
FROM board;

# 게시물의 writer 값을 member에 있는 값으로 update
UPDATE board
SET writer = (SELECT id FROM member LIMIT 1)
WHERE id > 0;