package com.caowei.dao.impl;

import com.caowei.dao.GoodsDao;
import com.caowei.domain.Goods;
import com.caowei.utils.DataScorceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {
    @Override
    public long getCount(String condition) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        String sql = "select count(*) from tb_goods";
        if (condition!=null){
            sql+=" where "+condition;
            System.out.println(sql);
            try {
                return  (Long) qr.query(sql,new ScalarHandler<>());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return 0;
    }

    @Override
    public List<Goods> findByWhere(int pageN, int pageS, String condition) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        String sql = "select * from tb_goods";
        if(condition!=null){
            sql+=" where "+condition;
        }
        sql+=" order by id limit ?,?";
        try {
            return qr.query(sql,new BeanListHandler<>(Goods.class),(pageN-1)*pageS,pageS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
