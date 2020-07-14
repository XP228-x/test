package com.bosssoft.hr.train.j2se.basic.example.annotation;

import com.bosssoft.hr.train.j2se.basic.example.database.DBUtil;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author
 */
@Slf4j
public class BaseModel {

    public static final String RESULT_TAG = "Execute result - ";
    public static final String ID_VALUE_TAG = "idValue";

    public int save() throws IllegalAccessException {
        //sql存放最终返回的sql语句
        StringBuilder sql = new StringBuilder("insert into ");
        //存放sql语句中表名、列名、赋值部分
        StringBuilder tableName;
        StringBuilder columnName = new StringBuilder("(");
        StringBuilder values = new StringBuilder("(");

        Class<? extends BaseModel> clazz = this.getClass();
        //判断该User类是否有@Table注解
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if(isTable) {
            //获取User类@Table注解的值value
            Table t = clazz.getAnnotation(Table.class);
            tableName = new StringBuilder(t.value());
            sql.append(tableName).append(" ");

            //处理ID和Column
            Map<String, String> idField = getAnnotationId();
            if (!idField.isEmpty()) {
                columnName.append(idField.get("id")).append(", ");
                values.append("'").append(idField.get(ID_VALUE_TAG)).append("',");
            }

            List<Field> columnFields = getAnnotationColumn();

            //遍历属性列表，分别拿出属性列表中被@Id/Column注解的属性，并获取属性的值
            for(int i = 0; i < columnFields.size(); i++){
                Field f =  columnFields.get(i);
                Column column = f.getAnnotation(Column.class);
                f.setAccessible(true);
                Object columnValue = f.get(this);
                if(i == columnFields.size() - 1){
                    columnName.append(column.value()).append(") VALUES ");
                    values.append("'").append(columnValue).append("')");
                    sql.append(columnName);
                    sql.append(values);
                    continue;
                }
                columnName.append(column.value()).append(", ");
                values.append("'").append(columnValue).append("',");

            }
        }
        int result = -1;
        try {
            result = DBUtil.executeUpdate(sql.toString());
        } catch (SQLException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        log.info(RESULT_TAG + result);
        return result;
    }


    public int update() throws IllegalAccessException {
        //sql存放最终返回的sql语句
        StringBuilder sql = new StringBuilder("update ");
        //tableName存放sql语句中表名、设置值、查找部分
        StringBuilder tableName;
        StringBuilder updateValues = new StringBuilder("SET ");
        StringBuilder where = new StringBuilder();

        Class<? extends BaseModel> clazz = this.getClass();
        //判断该User类是否有@Table注解
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if(isTable) {
            //获取User类@Table注解的值value
            Table t = clazz.getAnnotation(Table.class);
            tableName = new StringBuilder(t.value());
            sql.append(tableName).append(" ");
            //处理ID和Column
            Map<String, String> idField = getAnnotationId();
            if (!idField.isEmpty()) {
                where.append(idField.get("id")).append("='").append(idField.get(ID_VALUE_TAG)).append("'");
            }

            List<Field> columnFields = getAnnotationColumn();
            for(int i = 0; i < columnFields.size(); i++){
                Field f = columnFields.get(i);
                Column column = f.getAnnotation(Column.class);
                f.setAccessible(true);
                Object columnValue = f.get(this);

                if(i == columnFields.size() - 1){
                    updateValues.append(column.value()).append("='").append(columnValue).append("' WHERE ");
                    sql.append(updateValues);
                    sql.append(where);
                    continue;
                }
                updateValues.append(column.value()).append("='").append(columnValue).append("',");
            }
        }

        int result = -1;
        try {
            result = DBUtil.executeUpdate(sql.toString());
        } catch (SQLException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        log.info(RESULT_TAG + result);
        return result;
    }

    public int remove() throws IllegalAccessException {
        //sql存放最终返回的sql语句
        StringBuilder sql = new StringBuilder("DELETE FROM ");
        //存放sql语句中表名部分与条件
        StringBuilder tableName;
        StringBuilder where = new StringBuilder("WHERE ");

        Class<? extends BaseModel> clazz = this.getClass();
        //判断该User类是否有@Table注解
        boolean isTable = clazz.isAnnotationPresent(Table.class);
        if (isTable) {
            //获取User类@Table注解的值value，该值我们定义为User表的表名称
            Table t = clazz.getAnnotation(Table.class);
            tableName = new StringBuilder(t.value());
            sql.append(tableName).append(" ");
            //获取user对象的属性列表
            Field[] fieldList = clazz.getDeclaredFields();
            //遍历属性列表，分别拿出属性列表中被@Id注解的属性，并获取属性的值
            for (Field f : fieldList) {
                boolean isId = f.isAnnotationPresent(Id.class);
                if (isId) {
                    Id id = f.getAnnotation(Id.class);
                    f.setAccessible(true);
                    Object idValue = f.get(this);
                    where.append(id.value()).append("='").append(idValue).append("'");
                    sql.append(where);
                }
            }
        }

        int result = -1;
        try {
            result = DBUtil.executeUpdate(sql.toString());

        } catch (SQLException e) {
            log.error(e.getLocalizedMessage(), e);
        }
        log.info(RESULT_TAG + result);
        return result;
    }

    public void queryForList() throws IllegalAccessException, SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append(getQuerySql());
        log.info(sb.toString());
        ResultSet rs = DBUtil.executeQuery(sb.toString());
        while(rs.next()){
            log.info("id:"+rs.getInt("id")+" name:"+rs.getString("name")+" age"+rs.getInt("age"));
        }
    }

    private String getQuerySql() throws IllegalAccessException {
        //sql存放最终返回的sql语句
        StringBuilder sql = new StringBuilder("SELECT * FROM ");
        //存放sql语句中表名、查询条件部分
        StringBuilder tableName;
        StringBuilder where = new StringBuilder("WHERE 1=1 ");

        Class<? extends BaseModel> clazz = this.getClass();
        //判断该User类是否有@Table注解
        boolean isTable = clazz.isAnnotationPresent(Table.class);

        if (!isTable) {
            return "";
        }

        //获取User类@Table注解的值value
        Table t = clazz.getAnnotation(Table.class);
        tableName = new StringBuilder(t.value());
        sql.append(tableName).append(" ");
        //获取user对象的属性列表
        Field[] fieldList = clazz.getDeclaredFields();
        //遍历属性列表，分别拿出属性列表中被@Column注解的属性，并获取属性的值
        for (Field f : fieldList) {
            boolean isColumn = f.isAnnotationPresent(Column.class);
            boolean isId = f.isAnnotationPresent(Id.class);

            if (isColumn || isId) {
                Column column = f.getAnnotation(Column.class);
                f.setAccessible(true);
                Object columnValue = f.get(this);
                if (columnValue != null) {
                    where.append("and ");
                    if (columnValue instanceof String) {
                        //String模糊查询
                        where.append(column.value()).append(" like '%").append(columnValue).append("%' ");
                    } else {
                        where.append(column.value()).append("='").append(columnValue).append("' ");
                    }

                }
            }
        }
        sql.append(where);

        return sql.toString();
    }

    private List<Field> getAnnotationColumn() {
        Class<? extends BaseModel> clazz = this.getClass();
        ArrayList<Field> fields = new ArrayList<>();

        //获取user对象的属性列表
        Field[] fieldList = clazz.getDeclaredFields();
        //遍历属性列表，分别拿出属性列表中被@Column注解的属性，并获取属性的值
        for (Field f : fieldList) {
            if (f.isAnnotationPresent(Column.class)) {
                fields.add(f);
            }
        }
        return fields;

    }

    private Map<String, String> getAnnotationId() throws IllegalAccessException {
        Class<? extends BaseModel> clazz = this.getClass();
        Map<String, String> idValueMap = new HashMap<>();

        //获取user对象的属性列表
        Field[] fieldList = clazz.getDeclaredFields();
        //遍历属性列表，分别拿出属性列表中被@Id注解的属性，并获取属性的值
        for (Field f : fieldList) {
            if (f.isAnnotationPresent(Id.class)) {
                Id id = f.getAnnotation(Id.class);
                f.setAccessible(true);
                Object idValue = f.get(this);
                idValueMap.put("id", id.value());
                idValueMap.put(ID_VALUE_TAG, idValue.toString());
            }
        }
        return idValueMap;
    }
}
