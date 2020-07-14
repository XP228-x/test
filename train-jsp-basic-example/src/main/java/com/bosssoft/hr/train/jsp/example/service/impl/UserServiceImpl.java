package com.bosssoft.hr.train.jsp.example.service.impl;

import com.bosssoft.hr.train.jsp.example.dao.UserDao;
import com.bosssoft.hr.train.jsp.example.dao.daoImpl.UserDaoImpl;
import com.bosssoft.hr.train.jsp.example.exception.BusinessException;
import com.bosssoft.hr.train.jsp.example.pojo.Query;
import com.bosssoft.hr.train.jsp.example.pojo.User;
import com.bosssoft.hr.train.jsp.example.service.UserService;

import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:24
 * @since
 **/


public class UserServiceImpl implements UserService {

    private static final String EXCEPTION_CODE = "10001";
    private UserDao userDao = new UserDaoImpl();

    @Override
    public boolean save(User user) {
        try {

            return userDao.insert(user) > -1;
        }catch (Exception ex){
            throw new BusinessException(EXCEPTION_CODE,ex.getMessage(),ex);
        }

    }

    @Override
    public boolean remove(User user) {
        try {
            userDao.deleteById(user.getId());
            return true;
        }catch (Exception ex){
            throw new BusinessException(EXCEPTION_CODE,ex.getMessage(),ex);
        }
    }

    @Override
    public boolean update(User user) {
        try {
            userDao.update(user);
            return true;
        }catch (Exception ex){
            throw new BusinessException(EXCEPTION_CODE,ex.getMessage(),ex);
        }
    }

    @Override
    public List<User> queryByCondition(Query queryCondition) {
        try {
            return userDao.queryByCondition(queryCondition);
        }catch (Exception ex){
            throw new BusinessException(EXCEPTION_CODE,ex.getMessage(),ex);
        }
    }

    @Override
    public boolean authentication(User user) {
        try {
            Query query = new Query(user.getCode(), null);
            List<User> users = userDao.queryByCondition(query);
            if (users.isEmpty()) {
                return false;
            }

            return users.get(0).getPassword().equals(user.getPassword());

        }catch (Exception ex){
            throw new BusinessException(EXCEPTION_CODE,ex.getMessage(),ex);
        }
    }
}
