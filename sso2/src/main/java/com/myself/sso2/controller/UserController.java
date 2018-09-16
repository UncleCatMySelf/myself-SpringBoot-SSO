package com.myself.sso2.controller;

import com.myself.sso2.constant.CookieConstant;
import com.myself.sso2.constant.RedisConstant;
import com.myself.sso2.dataobject.User;
import com.myself.sso2.service.UserService;
import com.myself.sso2.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author:UncleCatMySelf
 * @Email：zhupeijie_java@126.com
 * @QQ:1341933031
 * @Date:Created in 12:43 2018\9\16 0016
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/login")
    public ModelAndView login(Map<String, Object> map){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        // 查询cookie
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null){
            return new ModelAndView("login/login");
        }
        //去Redis里查询
        String tokenValue = redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_PREFIX,cookie.getValue()));
        if (StringUtils.isEmpty(tokenValue)){
            return new ModelAndView("login/login");
        }
        User user = userService.findByUsername(tokenValue);
        if (user == null){
            return new ModelAndView("login/login");
        }else{
            map.put("username",user.getUsername());
            return new ModelAndView("msg/msg",map);
        }
    }

    @PostMapping("/to_login")
    public ModelAndView toLogin(@RequestParam("buName") String buName,
                                @RequestParam("buPassword") String buPassword,
                                HttpServletResponse response, Map<String, Object> map){
        if (buName.isEmpty() | buPassword.isEmpty()){
            //参数错误，统一返回登录界面
            return new ModelAndView("login/login");
        }
        User user = userService.findByUsername(buName);
        if (user == null){
            //参数错误，统一返回登录界面
            return new ModelAndView("login/login");
        }
        if (!buPassword.equals(user.getPassword())){
            //密码错误，统一返回登录界面
            return new ModelAndView("login/login");
        }else{
            // 设置token至redis
            String token = UUID.randomUUID().toString();
            Integer expire = RedisConstant.EXPIRE;
            redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_PREFIX ,token),user.getUsername(),expire, TimeUnit.SECONDS);
            // 设置token至cookie
            CookieUtil.set(response, CookieConstant.TOKEN,token,expire);
            map.put("username",user.getUsername());
            return new ModelAndView("msg/msg",map);
        }
    }

}
