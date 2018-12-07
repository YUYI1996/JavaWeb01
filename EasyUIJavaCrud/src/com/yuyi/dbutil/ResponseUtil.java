package com.yuyi.dbutil;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class ResponseUtil {

	public void write(HttpServletResponse response,Object o) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.write(o.toString());
		out.flush();
		out.close();
	}
}
