package com.caowei.dao.impl;

import com.caowei.dao.GoodsTypeDao;
import com.caowei.domain.GoodsType;
import com.caowei.utils.DataScorceUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
    @Override
    public List<GoodsType> findByLevel(int level) {
        QueryRunner qr = new QueryRunner(DataScorceUtils.getDataScource());
        try {
            return qr.query("select * from tb_goods_type where level=?",new BeanListHandler<>(GoodsType.class),level);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("查询商品类别失败");
        }
    }
}
