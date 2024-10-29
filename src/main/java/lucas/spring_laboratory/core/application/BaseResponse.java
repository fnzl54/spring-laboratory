package lucas.spring_laboratory.core.application;

import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lucas.spring_laboratory.core.exception.BaseErrorCode;

@Getter
@SuperBuilder
public class BaseResponse<E extends BaseErrorCode<?>> {

  @Builder.Default
  private boolean success = true;

  private E errorCode;
}

