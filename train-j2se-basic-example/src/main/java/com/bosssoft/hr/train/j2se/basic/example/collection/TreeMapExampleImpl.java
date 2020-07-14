package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
@Slf4j
public class TreeMapExampleImpl implements TreeMapExample<Role, Resource> {
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
