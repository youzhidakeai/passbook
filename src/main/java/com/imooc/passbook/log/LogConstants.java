package com.imooc.passbook.log;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: kkc
 * Email: wochiyouzhi@gmail.com
 * Date: 2018-11-10
 * Time: 下午4:52
 */

/**
 * 日志记录常量定义
 */
public class LogConstants {

    //用户动作名称
    public class ActionName{

        //用户查看优惠券信息
        public static final String USER_PASS_INFO = "UserPassInfo";

        //用户查看已使用的优惠券信息
        public static final String USER_USED_PASS_INFO = "UserUsedPassInfo";

        //用户使用优惠券
        public static final String USER_USE_PASS = "UserUserPass";

        //用户获取库存信息
        public static final String INVENTORY_INFO = "InventoryInfo";

        //用户领取优惠券
        public static final String GAIN_PASS_TEMPLATE = "GainPassTemplate";

        //用户创建评论
        public static final String CREATE_FEEDBACK = "CreateFeedback";

        //用户获取评论
        public static final String GET_FEEDBACk = "GetFeedback";

        //创建用户
        public static final String CREATE_USER = "CreateUser";
    }
}
