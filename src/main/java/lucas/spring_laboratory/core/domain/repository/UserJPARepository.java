package lucas.spring_laboratory.core.domain.repository;

import java.util.List;
import java.util.UUID;
import lucas.spring_laboratory.core.domain.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User, UUID> {

  @Query("select distinct u from User u left join u.posts")
  List<User> findAllJoin();

  @Query("select distinct u from User u left join fetch u.posts")
  List<User> findAllFetchJoin();

  @Query("select distinct u from User u left join fetch u.posts")
  Page<User> findAllFetchJoinPage(Pageable pageable);

  @Query("select distinct u from User u left join u.posts")
  Page<User> findAllJoinPage(Pageable pageable);

  @Query("select distinct u from User u left join fetch u.posts p left join fetch u.comments")
  List<User> findAllWithPostsAndCommentsFetchJoin();
}
