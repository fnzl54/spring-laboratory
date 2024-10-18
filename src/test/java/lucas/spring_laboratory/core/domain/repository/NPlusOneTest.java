package lucas.spring_laboratory.core.domain.repository;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import lucas.spring_laboratory.core.domain.entity.Post;
import lucas.spring_laboratory.core.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@SpringBootTest
@ActiveProfiles("localhost")
public class NPlusOneTest {

  @Autowired
  private UserJPARepository userJPARepository;

  @Test
  void Eager_type_사용_시_User_전체_조회_시_Post_조회에서_N_plus_1_발생() {
    System.out.println("== start ==");
    List<User> users = userJPARepository.findAll();
    System.out.println("== end ==");
  }

  @Test
  @Transactional
  void Lazy_type_사용_시_User_조회_후_Post_사용에서_N_plus_1_발생() {
    log.info("== start ==");
    List<User> users = userJPARepository.findAll();
    log.info("== end ==");

    for (User user : users) {
      user.getPosts().stream()
          .map(Post::getTitle)
          .forEach(title -> log.info("User: {}, Post Title: {}", user.getName(), title));
    }
  }


  @Test
  @Transactional
  void 단순_join_사용_시_N_plus_1_발생() {
    log.info("== start ==");
    List<User> users = userJPARepository.findAllJoin();
    log.info("== end ==");

    for (User user : users) {
      user.getPosts().stream()
          .map(Post::getTitle)
          .forEach(title -> log.info("User: {}, Post Title: {}", user.getName(), title));
    }
  }


  @Test
  @Transactional
  void 단순_join과_연관관계_FetchType_EAGER_사용_시_N_plus_1_발생() {
    log.info("== start ==");
    List<User> users = userJPARepository.findAllJoin();
    log.info("== end ==");

    for (User user : users) {
      user.getPosts().stream()
          .map(Post::getTitle)
          .forEach(title -> log.info("User: {}, Post Title: {}", user.getName(), title));
    }
  }
}
