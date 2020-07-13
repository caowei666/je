package com.caowei.dao.impl;

import com.caowei.dao.StudentDao;
import com.caowei.domain.Student;
import com.caowei.utils.DataScorceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findByPage(Integer pageNum, Integer pageSize) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataSource());
        try {
            return qr.query("select * from student order by studentNo limit ?,?",new BeanListHandler<Student>(Student.class),(pageNum-1)*pageSize,pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public long getCount() {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataSource());
        try {
            return qr.query("select count(*) from student",new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public void add(Student student) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataSource());
        Object[] params = {student.getStudentNo(),student.getLoginPwd(),student.getStudentName(),student.getSex(),student.getBornDate()};
        try {
            qr.update("insert into student values(?,?,?,?,?)",params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
