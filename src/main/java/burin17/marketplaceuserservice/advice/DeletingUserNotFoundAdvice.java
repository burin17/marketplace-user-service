package burin17.marketplaceuserservice.advice;

import burin17.marketplaceuserservice.exception.UserNotFoundException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DeletingUserNotFoundAdvice {
    @AfterThrowing(pointcut = "execution(* burin17.marketplaceuserservice.service.UserService.deleteUser(java.lang.Long))",
            throwing = "ex")
    public void throwCustomException(JoinPoint jp, EmptyResultDataAccessException ex) {
        throw new UserNotFoundException((Long) jp.getArgs()[0]);
    }
}
