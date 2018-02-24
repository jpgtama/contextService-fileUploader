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

			// ���������������õ��ǹ���ģʽ��
			DiskFileItemFactory factory = new DiskFileItemFactory();
			// ��ȡ��������嵥����װ˵���飨��ServletContext�еõ��ϴ��������ݣ�
			ServletContext servletContext = this.getServletConfig().getServletContext();
			File repository = new File("C:/temp");
			if (!repository.exists()) {
				repository.mkdirs();
			}

			// �����ѽ�Ҫ��װ�������Ĳ���¼�빤���Լ���ϵͳ����ΪҪ������Щ��������һ�������ߣ��ϴ������ļ��ĸ������ԣ�
			factory.setRepository(repository);
			// ��ʱ�������Ѿ�������������װ���ա���ɫ�����Բ������ϴ������ļ��Ĵ�С���ļ����ȣ�
			// ִ���������һ�д�����ζ�Ÿ�����װ���յȿ�����һ����װ������
			ServletFileUpload upload = new ServletFileUpload(factory);

			// ��������
			try {
				// ������͸������ߣ������ľ���һ����װ�õ���������requestת��FileItem��ʵ����
				List<FileItem> items = upload.parseRequest(req);
				Iterator<FileItem> iter = items.iterator();
				while (iter.hasNext()) {
					FileItem item = iter.next();

					//
					if (item.isFormField()) {

					} else {

					}

					// ��ӡList�е����ݣ�ÿһ��FileItem��ʵ������һ���ļ���ִ�����д�����ӡ���ļ���һЩ�������ԣ��ļ�������С�ȣ�
					System.out.println(item);
				}
				System.out.println("ѭ��������");
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("False");
		}

	}

}
