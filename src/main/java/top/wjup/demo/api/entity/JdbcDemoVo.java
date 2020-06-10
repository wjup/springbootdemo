package top.wjup.demo.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Create by wjup on 2020/5/15 8:49
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JdbcDemoVo {

    private String uuid;
    private String username;
    private String age;
    private String school;
    private String sex;

}
