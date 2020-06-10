package top.wjup.demo.api.controller;

import com.alibaba.fastjson.JSONObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.wjup.demo.api.entity.JdbcDemoVo;
import top.wjup.demo.api.service.JdbcDemoService;
import top.wjup.demo.base.entity.R;

import java.util.List;
import java.util.Map;

/**
 * Create by wjup on 2020/5/15 8:45
 *
 * 三个接口响应json均一样
 * [
 *     {
 *         "school": "山东科技大学",
 *         "sex": "0",
 *         "username": "wjup",
 *         "uuid": "1"
 *     },
 *     {
 *         "school": "华北理工大学",
 *         "sex": "1",
 *         "username": "test006",
 *         "uuid": "2"
 *     }
 * ]
 */
@Api("jdbc操作用例")
@RestController
@RequestMapping("/jdbc")
public class JdbcDemoController {

    @Autowired
    private JdbcDemoService jdbcDemoService;

    @GetMapping("/strTest")
    @ApiOperation(value = "实体类返回list，转成json返回前端", notes = "实体类返回list，转成json返回前端", produces = "application/json")
    public String strTest() {

        List<JdbcDemoVo> list = jdbcDemoService.getDataList();

        return JSONObject.toJSONString(list);
    }

    @GetMapping("/listTest")
    @ApiOperation(value = "实体类返回list，直接返回前端", notes = "实体类返回list，直接返回前端", produces = "application/json")
    public List<JdbcDemoVo> listTest() {

        List<JdbcDemoVo> list = jdbcDemoService.getDataList();

        return list;
    }

    @GetMapping("/listMapTest")
    @ApiOperation(value = "Map返回list，直接返回前端", notes = "Map返回list，直接返回前端", produces = "application/json")
    public List<Map<String,Object>> listMapTest() {

        List<Map<String,Object>> listMap = jdbcDemoService.getDataListMap();

        return listMap;
    }

    @PostMapping("/restfulTest")
    @ApiOperation(value = "restful风格接口", notes = "restful风格接口", produces = "application/json")
    public R restfulTest() {

        List<Map<String,Object>> listMap = jdbcDemoService.getDataListMap();

        return R.ok(listMap);
    }


}
