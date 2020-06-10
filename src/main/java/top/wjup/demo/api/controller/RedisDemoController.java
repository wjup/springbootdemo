package top.wjup.demo.api.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wjup.demo.api.entity.JdbcDemoVo;
import top.wjup.demo.api.service.JdbcDemoService;

import java.util.List;

/**
 * Create by wjup on 2020/5/15 9:20
 */
@RestController
@RequestMapping("/redis")
@Api("redis操作用例")
public class RedisDemoController {

    @Autowired
    private JdbcDemoService jdbcDemoService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @GetMapping("/test")
    @ApiOperation(value = "redis demo用例", notes = "redis demo用例", produces = "application/json")
    public String redisTest() {

        boolean redisTest = redisTemplate.hasKey("redis_test");

        if (redisTest) {
            return redisTemplate.opsForValue().get("redis_test");
        } else {
            List<JdbcDemoVo> dataList = jdbcDemoService.getDataList();
            String json = JSONObject.toJSONString(dataList);
            redisTemplate.opsForValue().set("redis_test", json);
            return json;
        }

    }
}
