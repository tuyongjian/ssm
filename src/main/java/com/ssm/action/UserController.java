package com.ssm.action;

import com.ssm.model.User;
import com.ssm.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by len on 2018/3/20.
 */
@Controller
@RequestMapping(value = "user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserService userService;

    @RequestMapping(value="/index",method= RequestMethod.GET)
    public String index(ModelMap model){
        return "index";
    }

    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test(ModelMap model){
        return "test";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(ModelMap model,
                           @RequestParam(value="userName")String userName,
                           @RequestParam(value = "password")String password){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        this.userService.addUser(user);
        model.addAttribute("success","true");
    }

    @RequestMapping(value="/query",method= RequestMethod.POST)
    public @ResponseBody User queryById(ModelMap model){
        User user = new User();
        user.setUserName("test");
        user.setPassword("123");
        user.setAge(1);
        return user;
    }

    @RequestMapping(value="/queryById",method= RequestMethod.POST)
    public @ResponseBody List<User> queryById(ModelMap model,
                   @RequestParam(value = "age")int age){
        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("age",age);
        List<User> list =  userService.getList(map);
        return list;
    }
}
