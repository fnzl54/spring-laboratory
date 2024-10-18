package lucas.spring_laboratory.core.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
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

  @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
  private Set<Post> posts = new HashSet<>();
}