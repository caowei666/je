package com.test.boot.dao;

import com.test.boot.pojo.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PremissionDAO {
    void deleteRoleMenuByRoleId(Integer roleId);
    void addRoleMenu(@Param("roleId") Integer roleId, @Param("menuId") Integer menuId);
    List<Integer> getMenuByRoleId(Integer roleId);

    void deleteUserRoleById(Integer userId);
    void addUserRole(@Param("roleId") Integer roleId,@Param("userId") Integer userId);
    List<Integer> getUserRoleByUserId(Integer userId);

    List<Menu> getUserMenuList(Integer userId);

    List<String> getRoleIdsByMenuId(Integer roleId);
}
