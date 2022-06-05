package com.itheima.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class JDBCdemo2 {

    @Test
        public void testDML() throws Exception {

        //1.注册驱动
//        Class.forName("com.mysql.cj.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql:///test";
        String username = "root";
        String password = "13579";
        Connection con = DriverManager.getConnection(url, username, password);
        //3.定义SQL语句
        String sql1 = "update account set money = 3000 where id = 1";
        String sql2 = "update account set money = 3000 where id = 2";

        //4.获取SQL对象
        Statement stmt = con.createStatement();

        try {
            //开启事务
            con.setAutoCommit(false);
            //5.执行SQL
            int count1 = stmt.executeUpdate(sql1);

            //5.执行SQL
            int count = stmt.executeUpdate(sql2);
            //6.处理返回结果
            if (count > 0) {
                System.out.println("修改成功");

            } else {
                System.out.println("修改失败");

            }
            //提交事务
            con.commit();
        } catch (Exception e) {
            //回滚事务
            con.rollback();
            e.printStackTrace();
        }

        //7.释放资源
        stmt.close();
        con.close();
    }

    public static void main(String[] args) {

        new JDBCdemo2();
    }
}
