package lucas.spring_laboratory.core.domain.repository;

import java.util.List;
import lucas.spring_laboratory.core.domain.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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

}
