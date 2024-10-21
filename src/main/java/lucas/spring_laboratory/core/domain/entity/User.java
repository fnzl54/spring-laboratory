package lucas.spring_laboratory.core.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lucas.spring_laboratory.core.domain.share.BaseEntity;

@ToString
@Getter
@Setter
@SuperBuilder
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

  private String name;

  private String email;

  @OneToMany(mappedBy = "user")
  private List<Post> posts = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Comment> comments = new ArrayList<>();
}