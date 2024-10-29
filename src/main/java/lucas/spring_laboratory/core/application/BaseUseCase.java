package lucas.spring_laboratory.core.application;

public interface BaseUseCase<Q extends BaseRequest, R extends BaseResponse> {

  R execute(Q request);
}
