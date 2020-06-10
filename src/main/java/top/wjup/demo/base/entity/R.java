package top.wjup.demo.base.entity;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serializable;


/**
 * 响应信息主体
 *
 * @param <T>
 * @author wjup
 */
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String msg;


	@Getter
	@Setter
	private T data;

	public static <T> R<T> ok() {
		return restResult(null, 200, null);
	}

	public static <T> R<T> ok(T data) {
		return restResult(data, 200, null);
	}

	public static <T> R<T> ok(T data, String msg,int code) {
		return restResult(data, code, msg);
	}

	public static <T> R<T> failed() {
		return restResult(null, 400, null);
	}

	public static <T> R<T> failed(String msg,int code) {
		return restResult(null, code, msg);
	}

	public static <T> R<T> failed(T data,int code) {
		return restResult(data, code, null);
	}

	public static <T> R<T> failed(T data, String msg,int code) {
		return restResult(data, code, msg);
	}

	private static <T> R<T> restResult(T data, int code, String msg) {
		R<T> apiResult = new R<>();
		apiResult.setCode(code);
		apiResult.setData(data);
		apiResult.setMsg(msg);
		return apiResult;
	}
}