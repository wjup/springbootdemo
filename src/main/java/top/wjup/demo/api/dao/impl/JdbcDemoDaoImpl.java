package top.wjup.demo.api.dao.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import top.wjup.demo.api.dao.JdbcDemoDao;
import top.wjup.demo.api.entity.JdbcDemoVo;

import java.util.List;
import java.util.Map;

/**
 * Create by wjup on 2020/5/15 8:47
 */
@Slf4j
@Repository
public class JdbcDemoDaoImpl implements JdbcDemoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<JdbcDemoVo> getDataList() {
        StringBuffer sql = new StringBuffer();
        sql.append("select uuid,username,sex,school from sys_user");
        log.info("getDataList query sql：" + sql.toString());
        return jdbcTemplate.query(sql.toString(), new BeanPropertyRowMapper<>(JdbcDemoVo.class));
    }

    @Override
    public List<Map<String, Object>> getDataListMap() {
        StringBuffer sql = new StringBuffer();
        sql.append("select uuid,username,sex,school from sys_user");
        log.info("getDataListMap query sql：" + sql.toString());

        return jdbcTemplate.queryForList(sql.toString());
    }
}
