package com.example;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class CommodityDao {
    private final static QueryRunner queryRunner;

    static {
        try (InputStream dbProfile = CommodityDao.class.getResourceAsStream("/druid.properties")) {
            Properties pro = new Properties();
            pro.load(dbProfile);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
            queryRunner = new QueryRunner(dataSource);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public List<Commodity> findAll() {
        String sql = "SELECT * FROM commodity";
        ResultSetHandler<List<Commodity>> resultSetHandler = new BeanListHandler<>(Commodity.class);
        try {
            return queryRunner.query(sql, resultSetHandler);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void add(Commodity commodity){
        String sql = "insert into commodity values(null, ?,?,?)";
        ResultSetHandler<Commodity> resultSetHandler = new BeanHandler<>(Commodity.class);
        try {
            queryRunner.insert(sql, resultSetHandler,commodity.getName(),commodity.getPrice(),commodity.getDescribe());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            queryRunner.execute("delete from commodity where id = ?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Commodity findByid(String id) {
        String sql = "select * from commodity where id = ?";
        ResultSetHandler<Commodity> resultSetHandler = new BeanHandler<>(Commodity.class);
        try {
            return queryRunner.query(sql, resultSetHandler,Long.parseLong(id));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Commodity commodity) {
        try {
            queryRunner.update("update commodity set commodity.name = ?,commodity.price = ?,commodity.describe = ? where id = ?", commodity.getName(),commodity.getPrice(),commodity.getDescribe(),commodity.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
