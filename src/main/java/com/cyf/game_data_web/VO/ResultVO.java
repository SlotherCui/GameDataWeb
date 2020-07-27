package com.cyf.game_data_web.VO;

import lombok.Data;
/**
 * 请求返回体
 * @param <T>
 */
@Data
public class ResultVO<T> {
    /** 错误码. */
    private Integer code;

    /** 提示信息. */
    private String msg;

    /** 具体内容. */
    private T data;
}
