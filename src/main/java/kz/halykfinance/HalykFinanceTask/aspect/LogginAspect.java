package kz.halykfinance.HalykFinanceTask.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LogginAspect {
    @Pointcut("@annotation(kz.halykfinance.tasksample.annotation.CustomLogging)")
    public void customLoggingPointcut() {
    }
    @Before("customLoggingPointcut()")
    public void logBefore(JoinPoint joinPoint) {
        String arguments = getArgumentsAsString(joinPoint.getArgs());
        log.info("Method Start: " + joinPoint.getSignature() + " with arguments: " + arguments);
    }

    @After("customLoggingPointcut()")
    public void logAfter(JoinPoint joinPoint) {
        String arguments = getArgumentsAsString(joinPoint.getArgs());
        log.info("Method End: " + joinPoint.getSignature() + " with arguments: " + arguments);
    }

    private String getArgumentsAsString(Object[] args) {
        if (args == null || args.length == 0) {
            return "no arguments";
        }
        StringBuilder sb = new StringBuilder();
        for (Object arg : args) {
            if (arg != null) {
                sb.append(arg.toString()).append(", ");
            } else {
                sb.append("null, ");
            }
        }
        return sb.length() > 0 ? sb.substring(0, sb.length() - 2) : "no arguments";
    }
}
