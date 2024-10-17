package lucas.spring_laboratory.core.domain.repository;

import java.util.UUID;
import lucas.spring_laboratory.core.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User, UUID> {

}
