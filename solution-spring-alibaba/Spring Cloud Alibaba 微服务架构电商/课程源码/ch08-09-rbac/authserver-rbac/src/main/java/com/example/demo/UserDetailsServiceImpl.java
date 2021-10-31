package com.example.demo;

import com.example.demo.mapper.PermissionMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.TbPermission;
import com.example.demo.model.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// todo 【用户服务】步骤9：创建用户详情服务
@Service("myUserDetailService")
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PermissionMapper permissionMapper;

    // todo 【用户服务】步骤10：实现 UserDetailsService 接口中的 loadUserByUsername 方法，获取用户信息，以及此用户的权限信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 调用 mapper，根据 username 获取用户信息
        TbUser user = userMapper.findByUsername(username);

        // 如果没有取得用户信息，返回 null
        if(user == null)
            return null;

        // 创建一个授权对象列表
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();

        // 调用 mapper，根据 user ID 获取权限列表
        List<TbPermission> permissionList = permissionMapper.findByUserId(user.getId());

        // 遍历权限列表，构建授权对象，放入授权对象列表
        permissionList.forEach(tbPermission -> {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
            grantedAuthorityList.add(grantedAuthority);
        });

        // 构建用户对象，返回
        return new User(user.getUsername(), user.getPassword(), grantedAuthorityList);
    }
}

