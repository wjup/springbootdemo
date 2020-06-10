package top.wjup.demo.api.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.wjup.demo.api.dao.JdbcDemoDao;
import top.wjup.demo.api.entity.JdbcDemoVo;
import top.wjup.demo.api.service.JdbcDemoService;

import java.util.List;
import java.util.Map;

/**
 * Create by wjup on 2020/5/15 8:46
 */
@Service
public class JdbcDemoServiceImpl implements JdbcDemoService {

    @Autowired
    private JdbcDemoDao jdbcDemoDao;

    @Override
    public List<JdbcDemoVo> getDataList() {
        return jdbcDemoDao.getDataList();
    }

    @Override
    public List<Map<String, Object>> getDataListMap() {
        return jdbcDemoDao.getDataListMap();
    }
}
