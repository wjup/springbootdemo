package top.wjup.demo.api.dao;

import top.wjup.demo.api.entity.JdbcDemoVo;

import java.util.List;
import java.util.Map;

/**
 * Create by wjup on 2020/5/15 8:47
 */
public interface JdbcDemoDao {
    List<JdbcDemoVo> getDataList();

    List<Map<String, Object>> getDataListMap();

}
