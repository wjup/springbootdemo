package top.wjup.demo.api.controller;

import com.alibaba.fastjson.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.wjup.demo.base.entity.R;

/**
 * Create by wjup on 2020/5/13 11:30
 */
@RequestMapping("/alarm")
@Controller
public class AlarmController {

    @ResponseBody
    @RequestMapping("/data")
    public R getData() {
        String jsonStr = "[\n" +
                "            {\n" +
                "                \"cabinet_num\": 4,\n" +
                "                \"cabinet_size\": \"168U\",\n" +
                "                \"network_type\": \"太原政务外\"\n" +
                "            },\n" +
                "            {\n" +
                "                \"cabinet_num\": 4,\n" +
                "                \"cabinet_size\": \"168U\",\n" +
                "                \"network_type\": \"太原互联网\"\n" +
                "            }\n" +
                "        ]";
        return R.ok(JSONArray.parseArray(jsonStr));
    }
}
