# Spring 실험실

## [N+1](https://chanyoung-kwon.notion.site/N-1-10fe5ea23d6b80029829c3db59bd51a3?pvs=4)

- JPA 즉시 로딩의 N+1 (Eager)
    - jpql을 우선적으로 select -> 즉시로딩을 이후에 보고 또다른 쿼리가 날아가 N+1 발생

- JPA 지연 로딩의 N+1 (Lazy)
    - 지연로딩된 값을 select -> 따로 쿼리가 날아가 N+1
    - 트랜잭션 관련 예외 발생 (LazyInitializationException)

- fetch join
    - 지연로딩의 해결책
    - 사용 시 하나의 join문을 통해 조회
    - 문제점
        - Pagination
            - limit, offset 사용한 쿼리가 아닌 인메모리에 가져와 application단에서 처리
            - OOM(Out of Memory) 발생 가능성 존재
        - 2개 이상의 collection join
            - MultipleBagFetchException 예외 발생

- Pagination 해결책
    - BatchSize를 통해 원하는 크기의 쿼리를 날림
    - 쿼리는 날아가지만 N번믜 쿼리는 발생되지 않음

- 2개 이상의 Collection join 해결책
    - Set를 사용한다면 해결 -> Pagination 오류 발생
    - BatchSize를 사용한다면 해결 -> Pagination 해결
