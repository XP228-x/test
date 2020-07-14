package com.bosssoft.hr.train.jsp.example.dao.daoImpl;

import com.bosssoft.hr.train.jsp.example.util.DBUtil;
import com.bosssoft.hr.train.jsp.example.dao.UserDao;
import com.bosssoft.hr.train.jsp.example.pojo.Query;
import com.bosssoft.hr.train.jsp.example.pojo.User;
import lombok.extern.slf4j.Slf4j;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: Administrator
 * @create: 2020-05-30 10:42
 * @since
 **/

@Slf4j
public class UserDaoImpl implements UserDao {
    @Override
    public int insert(User user) throws SQLException {
        if (!queryByCondition(new Query(null, user.getId())).isEmpty()) {
            return -1;
        }

        StringBuilder sql = new StringBuilder();
        sql.append("INSERT INTO jsp_user (id, name, code, password) VALUES (");
        sql.append("'").append(user.getId()).append("',");
        sql.append("'").append(user.getName()).append("',");
        sql.append("'").append(user.getCode()).append("',");
        sql.append("'").append(user.getPassword()).append("')");

        log.info("DAO-Insert-" + sql.toString());
        return DBUtil.executeUpdate(sql.toString());
    }

    @Override
    public int deleteById(Integer id) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("DELETE FROM jsp_user where id = ");
        sql.append("'" + id + "'");

        log.info("DAO-DELETE-" + sql.toString());

        return DBUtil.executeUpdate(sql.toString());
    }

    @Override
    public int update(User user) throws SQLException {
        StringBuilder sql = new StringBuilder();
        sql.append("UPDATE jsp_user SET ");
        sql.append("name = '" + user.getName() + "',");
        sql.append("code = '" + user.getCode() + "',");
        sql.append("password = '" + user.getPassword() + "' ");
        sql.append("WHERE id='" + user.getId() + "'");

        log.info("DAO-UPDATE-" + sql.toString());
        return DBUtil.executeUpdate(sql.toString());
    }

    @Override
    public List<User> queryByCondition(Query queryCondition) throws SQLException {
        String code = queryCondition.getCode();
        Integer id = queryCondition.getId();
        List<User> users = new ArrayList<>();

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM jsp_user WHERE 1=1 ");
        if (code != null) {
            sql.append("AND code = '" + code + "' ");
        }
        if (id != null) {
            sql.append("AND id = '" + id + "' ");
        }

        log.info("DAO-QUERY-" + sql.toString());
        ResultSet resultSet = DBUtil.executeQuery(sql.toString());
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getInt("id"));
            user.setName(resultSet.getString("name"));
            user.setCode(resultSet.getString("code"));
            user.setPassword(resultSet.getString("password"));
            users.add(user);
        }

        DBUtil.closeResource();

        return users;
    }
}
