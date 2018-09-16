package com.myself.sso1.constant;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 10:18 2018\6\13 0013
 */
public interface RedisConstant {

    String ZSETNAME = "search";

    String TOKEN_PREFIX = "token_%s";

    String WX_TONEKN_PREFIX = "wx_token_%s";

    String WX_USER_SEARCH = "wx_user_%s";

    String WX_KEY = "wx_key_%s";

    Integer EXPIRE = 1800;//半小时

    Integer WX_USER_EXPIRE = 86400;//24小时

}
