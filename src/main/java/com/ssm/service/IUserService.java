package com.ssm.service;

import com.ssm.dao.UserDao;
import com.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by len on 2018/3/20.
 */
public interface IUserService {

    public List<User> getList(Map<String, Object> map);

}
