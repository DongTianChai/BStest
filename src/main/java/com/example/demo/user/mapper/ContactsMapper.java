package com.example.demo.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.user.entity.Contacts;
import com.example.demo.user.entity.QueryPageUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sdx2009
 * @since 2024-10-16
 */
@Mapper
public interface ContactsMapper extends BaseMapper<Contacts> {


}
