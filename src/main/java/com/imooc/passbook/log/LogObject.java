package com.imooc.passbook.log;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午5:01
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 日志对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogObject {

    // 日志动作类型
    private String action;

    //  用户 id
    private Long userId;

    //  当前时间戳
    private Long timestamp;

    //  客户端 ip 地址
    private String remoteIp;

    // 日志信息
    private Object info = null;
}
