package com.imooc.passbook.vo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午8:59
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一的错误信息
 * @param <T>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo<T>{

    //错误码
    public static final Integer ERROR = -1;

    //特定错误码
    private Integer code;

    //错误信息
    private String Message;

    //请求url
    private String url;

    //请求返回的数据
    private T data;

}
