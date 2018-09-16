package com.myself.sso1.service.impl;

import com.myself.sso1.dataobject.User;
import com.myself.sso1.repository.UserRepository;
import com.myself.sso1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 12:36 2018\9\16 0016
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User find(Integer id) {
        return repository.getOne(id);
    }

    @Override
    public User findByUsername(String username) {
        return repository.findByUsername(username);
    }
}
