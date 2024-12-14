package com.ott.ott_service.aspect;

import com.ott.ott_service.exception.DuplicateDataException;
import com.ott.ott_service.exception.NotFoundException;
import com.ott.ott_service.exception.UnauthorizedException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MemberServiceAspect {

    @Pointcut("execution(* com.ott.ott_service.service.MemberService.*(..))")
    public void memberServiceMethods() {
    }

    @AfterReturning(pointcut = "memberServiceMethods()", returning = "result")
    public void logMemberService(JoinPoint joinPoint, Object result) {
        log.info("Successfully executed: {} with result = {}", joinPoint.getSignature(), result);
    }

    @Around("memberServiceMethods()")
    public Object logServiceException(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            return joinPoint.proceed();
        } catch (NotFoundException | UnauthorizedException | DuplicateDataException | DataAccessException ex) {
            // 비즈니스 예외 및 데이터 접근 예외는 그대로 던짐 (글로벌 예외 처리기에서 처리)
            throw ex;
        } catch (RuntimeException ex) {
            // 이미 RuntimeException으로 래핑된 경우 그대로 던짐
            throw ex;
        } catch (Exception ex) {
            // 예측하지 못한 예외를 로깅하고 RuntimeException으로 래핑하여 던짐 (글로벌 예외 처리기에서 처리)
            log.error("Unexpected exception in {}.{}() with cause = {}",
                    joinPoint.getSignature().getDeclaringType(),
                    joinPoint.getSignature().getName(),
                    ex.getCause() != null ? ex.getCause() : "NULL",
                    ex);
            throw new RuntimeException("Unexpected error occurred in service layer", ex);
        }
    }
}