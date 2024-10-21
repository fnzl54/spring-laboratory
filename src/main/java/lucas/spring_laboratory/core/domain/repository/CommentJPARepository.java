package lucas.spring_laboratory.core.domain.repository;

import java.util.UUID;
import lucas.spring_laboratory.core.domain.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentJPARepository extends JpaRepository<Comment, UUID> {

}
