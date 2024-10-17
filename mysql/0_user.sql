CREATE TABLE IF NOT EXISTS user
(
    id         BINARY(16)   NOT NULL COMMENT 'ID',
    name       VARCHAR(255) NULL COMMENT '유저아름',
    email      VARCHAR(255) NULL COMMENT '유저아름',
    created_at DATETIME     NULL COMMENT '생성일시',
    updated_at DATETIME     NULL COMMENT '수정일시',
    deleted    BOOLEAN      NOT NULL DEFAULT 0 COMMENT '삭제여부 0:미삭제, 1:삭제',
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_unicode_ci COMMENT '유저';

-- 테스트 데이터
INSERT INTO user (id, name, email, created_at, updated_at, deleted)
VALUES (uuid_to_bin(uuid(), 1), '일식이', 'one@gmail.com', now(), now(), false),
       (uuid_to_bin(uuid(), 1), '이식이', 'two@gmail.com', now(), now(), false),
       (uuid_to_bin(uuid(), 1), '삼식이', 'three@gmail.com', now(), now(), false);