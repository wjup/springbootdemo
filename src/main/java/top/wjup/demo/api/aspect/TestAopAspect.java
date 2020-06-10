package top.wjup.demo.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Create by wjup on 2020/6/9 15:01
 *
 * 注解执行顺序@Around-->@Before-->@After(方法执行结束后)
 */
@Aspect
@Component
@Slf4j
public class TestAopAspect {

    @Pointcut("@annotation(TestAop)")
    public void annotationPointcut() {
        log.info("@Pointcut------>run");
    }

    @Before("annotationPointcut()")
    public void beforePointcut(JoinPoint joinPoint) {
        log.info("@Before------>run");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TestAop annotation = method.getAnnotation(TestAop.class);
        String value = annotation.value();
        log.info("准备" + value);
    }

    @Around("annotationPointcut()")
    public Object isAccessMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("@Around------>run");
        //获取访问目标方法
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = methodSignature.getMethod();

        TestAop annotation = method.getAnnotation(TestAop.class);
        String value = annotation.value();

        if ("test".equals(value)) {
            // 放行
            return proceedingJoinPoint.proceed();
        } else {
            // 报错，不向下执行
            throw new Exception("权限不够！");
        }

    }

    @After("annotationPointcut()")
    public void afterPointcut(JoinPoint joinPoint) {
        log.info("@After------>run");
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        TestAop annotation = method.getAnnotation(TestAop.class);
        String value = annotation.value();
        String type = annotation.type();
        boolean show = annotation.show();
        log.info("结束" + value);
    }

}
