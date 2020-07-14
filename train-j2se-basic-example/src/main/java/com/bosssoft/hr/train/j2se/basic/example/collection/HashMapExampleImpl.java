package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * @description: 该类主要是为了测试 Hashmap 注意如果多线程访问 请将put，remove加上
 * list**,synchronized 关键字，如多线程做读并发访问不需要加 synchronized
 * @author: Administrator
 * @create: 2020-05-28 20:58
 * @since
 **/
@Slf4j
public class HashMapExampleImpl implements HashMapExample<Role, Resource> {
    /**
     * 定义 HashMap对象用于测试
     * 基于哈希表的实现的Map接口。 此实现提供了所有可选的地图操作，
     * <br>并允许null的值和null键。 （ HashMap类大致相当于Hashtable ，
     * <br>除了它是不同步的，并允许null）。这个类不能保证地图的顺序;
     * <br>特别是，它不能保证订单在一段时间内保持不变。
     */
    private Map<Role,Resource> map=new HashMap<>();
    @Override
    public Resource put(Role key, Resource value) {
        // 允许 null 值 null 键
        return map.put(key,value);
    }

    @Override
    public Resource remove(Role key) {
        // 因为 重写了 Role 的 equal 和 hashcode 所以保证根据id删除
        return map.remove(key);
    }

    @Override
    public boolean containsKey(Role key) {
        return map.containsKey(key);
    }

    @Override
    public void visitByEntryset() {
        Set<Map.Entry<Role,Resource>> set=map.entrySet();
        for(Map.Entry<Role,Resource> entry : set){
            log.info(Constraint.LOG_TAG,entry.getKey()+"####"+entry.getValue());
        }
    }

    @Override
    public void visitByKeyset() {
        if (null!=map) {
            Set<Role> set = map.keySet();
            Iterator<Role> iterator = set.iterator();
            while (iterator.hasNext()) {
                Role role = iterator.next();
                log.info(Constraint.LOG_TAG, role);
                log.info(Constraint.LOG_TAG, map.get(role));
            }
        }
    }

    @Override
    public void visitByValues(){
        Collection<Resource> collection=map.values();
        Iterator<Resource> iterator= collection.iterator();
        for(;iterator.hasNext();){
            Resource resource=iterator.next();
            log.info(Constraint.LOG_TAG,resource);
        }
    }
}
