package top.wjup.demo.base.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import top.wjup.demo.base.entity.R;
import top.wjup.demo.base.exception.ServiceException;

/**
 * 全局异常接管
 *
 * @author WJUP
 */
@RestControllerAdvice
public class ExceptionsHandler {

    /**
     * 注意：
     * 启用全局异常接管后，没有在此处定义拦截的异常都会默认返回500错误。
     * 若需要自定义拦截的异常，请在此处定义拦截。
     * 若需要输出异常的日志日志，请使用logger输出。
     */
    private final Logger logger = LoggerFactory.getLogger(ExceptionsHandler.class);

    /**
     * 基本异常
     */
    @ExceptionHandler(Exception.class)
    public R exception(Exception e) {
        logger.error(e.getMessage(), e);
        return R.failed("Error", 500);
    }

    /**
     * 请求路径无法找到异常
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public R notFoundException() {
        return R.failed("Not found", 404);
    }

    /**
     * 请求方法不支持异常
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public R httpRequestMethodNotSupportedException() {
        return R.failed("Method not allowed", 405);
    }

    /**
     * 请求参数异常
     */
    @ExceptionHandler({HttpMessageNotReadableException.class, MissingServletRequestParameterException.class, MissingServletRequestPartException.class, BindException.class})
    public R parameterException() {
        return R.failed("Parameter error", 403);
    }

    /**
     * 上传文件过大异常
     */
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public R maxUploadSizeExceededException() {
        return R.failed("File is too large", 403);
    }

    /**
     * 服务异常
     */
    @ExceptionHandler(ServiceException.class)
    public R serviceException(ServiceException e) {
        return R.failed(e.getData(), e.getMessage(), e.getCode());
    }

}