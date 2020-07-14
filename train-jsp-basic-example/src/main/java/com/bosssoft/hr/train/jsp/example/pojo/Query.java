package com.bosssoft.hr.train.jsp.example.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-29 14:09
 * @since
 **/
@Data
@AllArgsConstructor
public class Query {
    private String code;
    private Integer id;

    public String getCode() {
        return code;
    }

    public Integer getId() {
        return id;
    }
}
