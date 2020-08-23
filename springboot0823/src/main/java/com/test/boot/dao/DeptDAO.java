package com.test.boot.dao;

import com.test.boot.pojo.Dept;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptDAO {
    List<Dept> getDeptList();

//    @Insert("insert into dept(name) values(#{name})")
//    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    void addDept(Dept dept);
}
