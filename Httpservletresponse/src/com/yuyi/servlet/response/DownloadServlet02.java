package com.yuyi.servlet.response;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DownloadServlet02
 */
public class DownloadServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DownloadServlet02() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 獲取下載文件名稱
		String filename = request.getParameter("filename");
		// 下载文件类型
		response.setContentType(this.getServletContext().getMimeType(filename));
		// 告诉浏览器直接下载
		response.setHeader("Content-Disposition", "attachment;filename=" + filename);

		// 获取文件绝对路径
		String path = this.getServletContext().getRealPath("source/" + filename);
		
		System.out.println(path);

		InputStream in = new FileInputStream(path);
		// response获取字节输出流
		ServletOutputStream out = response.getOutputStream();
		int length = 0;
		byte[] bt = new byte[1024];
		while ((length = in.read(bt)) > 0) {
			out.write(bt, 0, length);
		}

		in.close();
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
