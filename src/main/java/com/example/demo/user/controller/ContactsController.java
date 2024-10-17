package com.example.demo.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.result.Result;
import com.example.demo.user.entity.Contacts;
import com.example.demo.user.entity.QueryPageUser;
import com.example.demo.user.service.ContactsService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController

@RequestMapping("/user/contacts")
public class ContactsController {

    @Resource
    private ContactsService contactsService;


    @GetMapping("/page")
    public Result<?> page(QueryPageUser queryPageUser) {
        Page<Contacts> pageUser = contactsService.getPageUser(queryPageUser);

        JSONObject obj = new JSONObject();
        obj.put("total", pageUser.getTotal());
        obj.put("rows", pageUser.getRecords());

        return new Result<>().success().put(obj);
    }

    @PostMapping("/add")
    public Result<?> addUser(@RequestBody Contacts addUser) {
        boolean success = contactsService.addUser(addUser);
        return success ? new Result<>().success().put("添加成功") : new Result<>().error().put("添加失败");
    }

    @PostMapping("/update")
    public Result<?> updateUser(@RequestBody Contacts updateUser) {
        boolean success = contactsService.updateUser(updateUser);
        return success ? new Result<>().success().put("修改成功") : new Result<>().error().put("修改失败");
    }

    @GetMapping("/delate")
    public Result<?> deleteUser(Integer id) {
        boolean success = contactsService.removeById(id);
        return success ? new Result<>().success().put("删除成功") : new Result<>().error().put("删除失败");
    }
}
