package com.myself.sso2.service;

import com.myself.sso2.dataobject.User;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:51 2018\9\16 0016
 */
public interface UserService {

    User find(Integer id);

    User findByUsername(String username);

}
