package com.ssm.serviceImpl;

import com.ssm.dao.UserDao;
import com.ssm.model.User;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by len on 2018/3/20.
 */
@Service
public class UserServiceImpl implements IUserService {


    @Autowired
    private UserDao userDao;

    public List<User> getList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    public User getUser(int id){
        return userDao.selectByPrimaryKey(id);
    }

    public int addUser(User user){
        return this.userDao.insert(user);
    }
}
