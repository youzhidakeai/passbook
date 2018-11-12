package com.imooc.passbook.vo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-11
 * Time: 上午10:58
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Controller 统一的响应
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    //错误码： 正确返回0
    private Integer errorCode = 0;

    //错误信息，正确返回空字符串
    private String errorMsg =  "";

    //返回值对象
    private Object data;

    //正确的响应构造函数
    public Response(Object data){
        this.data = data;
    }

    //空响应
    public static Response success(){
        return new Response();
    }

    //错误响应
    public static Response failure(String errorMsg){
        return new Response(-1,errorMsg,null);
    }
}
