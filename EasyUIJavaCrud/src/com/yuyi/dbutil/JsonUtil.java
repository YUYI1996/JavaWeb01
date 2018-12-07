package com.yuyi.dbutil;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class JsonUtil {

	public static JSONArray formatRsToJsonArray(ResultSet rs) throws SQLException {
		ResultSetMetaData md=rs.getMetaData();
		int num=md.getColumnCount();
		JSONArray array=new JSONArray();
		while(rs.next()) {
			JSONObject jo=new JSONObject();
			for(int i=0;i<=num;i++) {
				jo.put(md.getColumnName(i), rs.getObject(i));
			}
			array.add(jo);
		}
		return array;
		
	}
}
