//package com.test.dao;
//
//import com.test.pojo.Dept;
//import org.mybatis.spring.support.SqlSessionDaoSupport;
//
//public class DeptDaoImpl extends SqlSessionDaoSupport implements DeptDAO {
//    @Override
//    public Dept getDeptById(Integer id) {
//        return super.getSqlSession().selectOne("DEPT.getDeptById",id);
//    }
//}
