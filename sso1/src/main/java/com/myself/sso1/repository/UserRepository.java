package com.myself.sso1.repository;

import com.myself.sso1.dataobject.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 11:51 2018\9\16 0016
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);

}
