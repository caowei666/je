package dao;

import org.apache.ibatis.annotations.*;
import pojo.Dept;

public interface DeptMapper {
    @Insert("insert into dept(name) values (#{name})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    int addDept(String name);

    @Update("update dept set name=#{name} where id=#{id}")
    int update(Dept dept);

    @Delete("delete from dept where id = #{id}")
    int deleteById(int id);

    @Select("select id,name from dept where id=#{id}")
    Dept getDeptById(int id);
}
