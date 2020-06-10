package top.wjup.demo.api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wjup.demo.api.aspect.TestAop;
import top.wjup.demo.base.entity.R;

/**
 * Create by wjup on 2020/6/9 15:24
 */
@Slf4j
@RestController
@RequestMapping("/aspect")
public class AspectDemoController {

    @TestAop(value = "test",show = false,type = "class")
    @RequestMapping("/test")
    public R aspect() {
        log.info("测试");
        return R.ok();
    }

}
