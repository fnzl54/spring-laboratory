package lucas.spring_laboratory.core.domain.repository;

import java.util.UUID;
import lucas.spring_laboratory.core.domain.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostJPARepository extends JpaRepository<Post, UUID> {

}
