package com.bosssoft.hr.train.j2se.basic.example.annotation;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @param
 * @description:
 * @author: Administrator
 * @create: 2020-05-28 22:42
 * @since
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@Table(value="t_user")
public class UserModel extends BaseModel
{
    @Id(value="id")
    private Integer id;
    @Column(value="name")
    private String name;
    @Column(value="age")
    private Integer age;
}
