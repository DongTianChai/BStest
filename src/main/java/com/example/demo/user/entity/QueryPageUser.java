package com.example.demo.user.entity;

import lombok.Data;

@Data
public class QueryPageUser {
    private Long pageNumber;
    private Long pageSize;
    //条件查询
    private String name;
    private String phone;
}
