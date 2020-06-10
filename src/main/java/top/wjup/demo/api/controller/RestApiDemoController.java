package top.wjup.demo.api.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Create by wjup on 2020/5/13 9:43
 *
 * 本接口示例了 @ApiOperation 和 @ApiImplicitParam 两个注解的使用。
 * https://www.jianshu.com/p/c79f6a14f6c9
 * Swagger 通过注解定制接口对外展示的信息，这些信息包括接口名、请求方法、参数、返回信息等。更多注解类型：
 *
 * @Api：修饰整个类，描述Controller的作用
 * @ApiOperation：描述一个类的一个方法，或者说一个接口
 * @ApiParam：单个参数描述
 * @ApiModel：用对象来接收参数
 * @ApiProperty：用对象接收参数时，描述对象的一个字段
 * @ApiResponse：HTTP响应其中1个描述
 * @ApiResponses：HTTP响应整体描述
 * @ApiIgnore：使用该注解忽略这个API
 * @ApiError ：发生错误返回的信息
 * @ApiImplicitParam：描述一个请求参数，可以配置参数的中文含义，还可以给参数设置默认值
 * @ApiImplicitParams：描述由多个
 * @ApiImplicitParam 注解的参数组成的请求参数列表
 *
 */
@Api("测试接口用例")
@RestController
@RequestMapping("/api")
@Slf4j
public class RestApiDemoController {

    @Value("${api.data}")
    private String data;

    @ApiOperation(value = "发送解析文本", notes = "发送解析文本", produces = "application/json")
    @RequestMapping(value = "/sendText", method = RequestMethod.GET)
    public String hello() {
        log.info("发送文本内容：" + data);

        return "";
    }

    @ApiOperation(value = "查询单词计数", notes = "查询单词计数", produces = "application/json")
    @ApiImplicitParam(name = "word", value = "单词", paramType = "query", required = true, dataType = "String")
    @RequestMapping(value = "/queryWordCount", method = RequestMethod.POST)
    public String queryWordCount(@RequestBody String word) {
        log.info("查询单词计数：{}", word);

        return "SUCESS";
    }
}
