CREATE TABLE IF NOT EXISTS comment
(
    id         BINARY(16)   NOT NULL COMMENT 'ID',
    user_id    BINARY(16)   NOT NULL COMMENT '작성자 ID',
    post_id    BINARY(16)   NOT NULL COMMENT '게시글 ID',
    content    VARCHAR(255) NULL COMMENT '댓글 내용',
    created_at DATETIME     NULL COMMENT '생성일시',
    updated_at DATETIME     NULL COMMENT '수정일시',
    deleted    BOOLEAN      NOT NULL DEFAULT 0 COMMENT '삭제여부 0:미삭제, 1:삭제',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE,
    FOREIGN KEY (post_id) REFERENCES post (id) ON DELETE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '댓글';

-- 테스트 데이터
INSERT INTO comment (id, user_id, post_id, content, created_at, updated_at, deleted)
VALUES (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-8ed1-9a32-0242c0a89002'),
        uuid_to_bin('11ef8c56-24af-0880-9a32-0242c0a89002'),
        '삼식이가 일식이한테1', now(), now(), false),
       (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-8ed1-9a32-0242c0a89002'),
        uuid_to_bin('11ef8c56-24af-2d23-9a32-0242c0a89002'),
        '삼식이가 이식이한테1', now(), now(), false),
       (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-8ed1-9a32-0242c0a89002'),
        uuid_to_bin('11ef8c56-24af-2d23-9a32-0242c0a89002'),
        '삼식이가 이식이한테2', now(), now(), false)