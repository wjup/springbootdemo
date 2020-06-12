package top.wjup.demo.base.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author wjup
 *
 * 请求日志打印
 */
@Aspect
@Component
public class LogAspect {
    protected Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Pointcut("execution(* top.wjup.demo.api.controller.*.*(..))")
    public void webLog() {
    }

    @Before("webLog()")
    public void deBefore(JoinPoint joinPoint) throws Throwable {
        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("--------------------------------------------------");
        log.info("【请求地址】: " + request.getRequestURL().toString());
        log.info("【请求类型】 : " + request.getMethod());
        log.info("【请求入参】 : " + Arrays.toString(joinPoint.getArgs()));
        log.info("【请求者IP】 : " + request.getRemoteAddr());
        log.info("【响应方法】 : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    public void doAfterReturning(Object ret) throws Throwable {
        // 处理完请求，返回内容
        log.info("【请求结果】 : " + ret);
        log.info("--------------------------------------------------\n");
    }

    @AfterThrowing("webLog()")
    public void throwss(JoinPoint jp) {
        log.info("【方法异常】↓↓↓↓↓↓");
    }

}