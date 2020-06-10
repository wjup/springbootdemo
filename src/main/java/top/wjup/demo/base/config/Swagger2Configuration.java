package top.wjup.demo.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create by wjup on 2020/5/13 9:47
 *
 * http://${host}:${port}/swagger-ui.html
 *
 * 本接口示例了 @ApiOperation 和 @ApiImplicitParam 两个注解的使用。
 *
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
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    //api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "top.wjup.demo.api.controller";

    public static final String VERSION = "1.0.0";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())// 可以根据url路径设置哪些请求加入文档，忽略哪些请求
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Spring boot demo by wjup")//设置文档的标题
                .description("demo API 接口文档")// 设置文档的描述
                .version(VERSION)// 设置文档的版本信息-> 1.0.0 Version information
                .termsOfServiceUrl("https://blog.wjup.top")// 设置文档的License信息->1.3 License information
                .build();
    }

}
