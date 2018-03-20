package com.ssm.dao;

import com.ssm.model.User;

import java.util.List;
import java.util.Map;

/**
 * Created by len on 2018/3/20.
 */
public interface UserDao {

    public List<User> queryList(Map<String, Object> map);
}
