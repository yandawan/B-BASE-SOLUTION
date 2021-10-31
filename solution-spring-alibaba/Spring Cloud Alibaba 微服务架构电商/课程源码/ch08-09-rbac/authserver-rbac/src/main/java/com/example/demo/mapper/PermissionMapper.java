package com.example.demo.mapper;

import com.example.demo.model.TbPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionMapper {
    // todo {数据库操作} 步骤7：- 根据 user ID 查询权限列表

    @Select(
            "select p.* " +
            "from tb_user_role ur left join tb_role_permission rp on ur.role_id=rp.`role_id` " +
            "left join `tb_permission` p on p.id = rp.`permission_id` " +
            "where ur.user_id=#{userId}"
    )
    List<TbPermission> findByUserId(@Param(value="userId") Long userId);
}
