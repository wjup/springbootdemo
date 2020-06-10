package top.wjup.demo.api.aspect;

import java.lang.annotation.*;

/**
 * Create by wjup on 2020/6/9 14:59
 * @author wjup
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface TestAop {

    String value() default "";

    String type() default "method";

    boolean show() default true;

}
