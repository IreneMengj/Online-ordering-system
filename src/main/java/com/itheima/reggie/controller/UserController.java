package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.service.UserService;
import com.itheima.reggie.utils.ValidateCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map,HttpSession session){
        String key = map.get("phone").toString();
        //save code in redis
        stringRedisTemplate.opsForValue().set(key,map.get("code").toString(),5, TimeUnit.MINUTES);

        log.info(map.toString());
        String phone = map.get("phone").toString();
        String code = map.get("code").toString();
        //Object codeInSession = session.getAttribute(key);
        //get code from redis
        String codeInsession = stringRedisTemplate.opsForValue().get(key);
        if(codeInsession != null && codeInsession.equals(code)){
            LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(User::getPhone,phone);
            User user = userService.getOne(queryWrapper);
            if(user==null){
                user = new User();
                user.setPhone(phone);
                user.setStatus(1);
                userService.save(user);
            }
            session.setAttribute("user",user.getId());
            //if the user has logged in successfully, delete from redis
            stringRedisTemplate.delete(key);
            return R.success(user);

        }
        return R.error("log in unsuccessfully");
    }



}
