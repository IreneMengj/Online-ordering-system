package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.Employee;
import com.itheima.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    //login
    @Autowired
    private EmployeeService employeeService;
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee){
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername,employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);
        if(emp==null){
            return R.error("username doesn't exist");
        }
        if(!emp.getPassword().equals(password)){
            return R.error("password wrong");
        }
        //to identify whether the user account has been locked
        if(emp.getStatus()==0){
            return R.error("account locked");
        }
        request.getSession().setAttribute("employee",emp.getId());

        return R.success(emp);
    }
    //logout
    @PostMapping("/logout")
    public R<String> logOut(HttpServletRequest request){
        request.getSession().removeAttribute("employee");
        return R.success("quit successfully");
    }
    //
    @PostMapping
    public R<String> save(HttpServletRequest request,@RequestBody Employee employee){
        log.info("add employees");
        //set initial password and encrypt it
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        //employee.setCreateTime(LocalDateTime.now());
        //employee.setUpdateTime(LocalDateTime.now());
        //Long employeeId = (Long)request.getSession().getAttribute("employee");
        //employee.setCreateUser(employeeId);
        //employee.setUpdateUser(employeeId);
        employeeService.save(employee);
        return R.success("add employee successfully");
    }
    //employee information pagination
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize,String name){
        log.info("page={},pageSize={},name={}",page,pageSize,name);
        //build pagination constructor
        Page pageInfo = new Page(page,pageSize);
        //build condition constructor
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
        //adding filter Conditions
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        //add order condition
        queryWrapper.orderByDesc(Employee::getUpdateTime);

        employeeService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    //change status of an employee(status 0 or 1)
    @PutMapping
    public R<String> update(HttpServletRequest request,@RequestBody Employee employee){
        log.info(employee.toString());
        long id = Thread.currentThread().getId();
        log.info("thread id is {}",id);
        //employee.setUpdateTime(LocalDateTime.now());
       // employee.setUpdateUser((Long) request.getSession().getAttribute("employee"));
        employeeService.updateById(employee);

        return R.success("employee information has been changed successfully");
    }
    //select employee information based on id
    @GetMapping("/{id}")
    public R<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if(employee!=null){
            return R.success(employee);
        }else{
            return R.error("unexpected error");
        }

    }
}
