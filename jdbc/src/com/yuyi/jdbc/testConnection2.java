package com.yuyi.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

public class testConnection2 {
	public static void main(String[] args) throws SQLException {
		Connection connection = null;
		try {
			QueryRunner queryRunner=new QueryRunner();
			connection=c3p0Utils.getConnection();
			connection.setAutoCommit(false);
			queryRunner.update("insert into users values(45,'gg','GG','123456789','gg@qq.com')");
			connection.commit();
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}
	}
}
