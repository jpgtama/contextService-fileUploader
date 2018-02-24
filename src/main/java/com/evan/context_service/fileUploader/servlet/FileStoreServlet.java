/**
 * 
 */
package com.evan.context_service.fileUploader.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * @author evan
 *
 */
@WebServlet(name = "FileStoreServlet", value = "/fileStore")
public class FileStoreServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * get a file, return file path? or file content
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.getWriter().println("HELLO");

	}

	/**
	 * accept new file:
	 * 
	 * need:
	 * 
	 * <ol>
	 * <li>process id: make process mideng</li>
	 * <li>system id</li>
	 * <li>file</li>
	 * 
	 * </ol>
	 * 
	 * 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);

		if (isMultipart) {
			System.out.println("True");

			// 创建工厂（这里用的是工厂模式）
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// 获取汽车零件清单与组装说明书（从ServletContext中得到上传来的数据）
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = new File("C:/temp");
			if (!repository.exists()) {
				repository.mkdirs();
			}

			// 工厂把将要组装的汽车的参数录入工厂自己的系统，因为要根据这些参数开设一条生产线（上传来的文件的各种属性）
			factory.setRepository(repository);
			// 此时工厂中已经有了汽车的组装工艺、颜色等属性参数（上传来的文件的大小、文件名等）
			// 执行下面的这一行代码意味着根据组装工艺等开设了一条组装生产线
			ServletFileUpload upload = new ServletFileUpload(factory);

			// 解析请求
			try {
				// 把零件送给生产线，出来的就是一辆组装好的汽车（把request转成FileItem的实例）
				List<FileItem> items = upload.parseRequest(req);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();

					//
					if (item.isFormField()) {

					} else {

					}

					// 打印List中的内容（每一个FileItem的实例代表一个文件，执行这行代码会打印该文件的一些基本属性，文件名，大小等）
					System.out.println(item);
				}
				System.out.println("循环输出完成");
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("False");
		}

	}

}
