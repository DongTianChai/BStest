package com.example.demo.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.user.entity.Contacts;
import com.example.demo.user.entity.QueryPageUser;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sdx2009
 * @since 2024-10-16
 */
public interface ContactsService extends IService<Contacts> {
    Page<Contacts> getPageUser(QueryPageUser quseryPageUser);
    //存取头像

    boolean addUser(Contacts addUser);

    boolean updateUser(Contacts updateUser);
}
