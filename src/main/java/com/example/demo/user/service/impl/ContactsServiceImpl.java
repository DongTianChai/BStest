package com.example.demo.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.user.entity.Contacts;
import com.example.demo.user.entity.QueryPageUser;
import com.example.demo.user.mapper.ContactsMapper;
import com.example.demo.user.service.ContactsService;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;

@Service
public class ContactsServiceImpl extends ServiceImpl<ContactsMapper, Contacts> implements ContactsService {

    @Resource
    private ContactsMapper contactsMapper;
    @Override
    public Page<Contacts> getPageUser(QueryPageUser quseryPageUser) {
        // 初始化page对象
        Page<Contacts> page = new Page<>(quseryPageUser.getPageNumber(), quseryPageUser.getPageSize());

        // 根据page对象做分页查询
        QueryWrapper<Contacts> queryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(quseryPageUser.getName())) {
            queryWrapper.like("name", quseryPageUser.getName());
        }
        if (!ObjectUtils.isEmpty(quseryPageUser.getPhone())) {
            queryWrapper.like("phone", quseryPageUser.getPhone());
        }
        Page<Contacts> p = this.page(page, queryWrapper);


        // 调用MyBatis-Plus的分页查询方法
        return p;
    }

    @Override
    public boolean addUser(Contacts addUser) {
        return this.save(addUser);
    }

    @Override
    public boolean updateUser(Contacts updateUser) {
        return this.updateById(updateUser);
    }
}
