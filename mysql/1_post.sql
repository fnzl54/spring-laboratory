CREATE TABLE IF NOT EXISTS post
(
    id         BINARY(16)   NOT NULL COMMENT 'ID',
    user_id    BINARY(16)   NOT NULL COMMENT '작성자 ID',
    title      VARCHAR(255) NULL COMMENT '게시글 제목',
    content    VARCHAR(255) NULL COMMENT '게시글 이름',
    created_at DATETIME     NULL COMMENT '생성일시',
    updated_at DATETIME     NULL COMMENT '수정일시',
    deleted    BOOLEAN      NOT NULL DEFAULT 0 COMMENT '삭제여부 0:미삭제, 1:삭제',
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '유저';

-- 테스트 데이터
INSERT INTO post (id, user_id, title, content, created_at, updated_at, deleted)
VALUES (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1be6-349b-9a32-0242c0a89002'), '일식이 제목1',
        '일식이 내용1', now(), now(), false),
       (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-4b30-9a32-0242c0a89002'), '이식이 제목1',
        '일식이 내용1', now(), now(), false),
       (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-4b30-9a32-0242c0a89002'), '이식이 제목2',
        '일식이 내용2', now(), now(), false),
       (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-8ed1-9a32-0242c0a89002'), '삼식이 제목1',
        '삼식이 내용1', now(), now(), false),
       (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-8ed1-9a32-0242c0a89002'), '삼식이 제목2',
        '삼식이 내용2', now(), now(), false),
       (uuid_to_bin(uuid(), 1), uuid_to_bin('11ef8c53-1bea-8ed1-9a32-0242c0a89002'), '삼식이 제목3',
        '삼식이 내용3', now(), now(), false);
