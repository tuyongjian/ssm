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
    public String index(ModelMap model,
                       @RequestParam(value = "age")int age){

        Map<String,Object> map  = new HashMap<String,Object>();
        map.put("age",age);
        List<User> list =  userService.getList(map);

        logger.info(list.toString());
        model.addAttribute("list", list);
        return "index";
    }

    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test(ModelMap model){
        return "/WEB-INF/view/test.ftl";
    }
}
