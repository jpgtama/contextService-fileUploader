/**
 * 
 */
package com.evan.context_service.fileUploader.servlet;

import java.io.File;
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
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

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

		// usingTraditionalWay(req);

		usingStreamingAPI(req);

	}

	private void usingStreamingAPI(HttpServletRequest request) {
		// Check that we have a file upload request
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

		if (isMultipart) {
			System.out.println("is Multipart request");

			try {
				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload();

				// Parse the request
				FileItemIterator iter = upload.getItemIterator(request);
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					String name = item.getFieldName();
					InputStream stream = item.openStream();
					if (item.isFormField()) {
						System.out.println(
								"Form field " + name + " with value " + Streams.asString(stream) + " detected.");
					} else {
						System.out.println("File field " + name + " with file name " + item.getName() + " detected.");
						// Process the input stream
						
						// TODO 
						// save file
						byte[] bs = IOUtils.toByteArray(stream);
						System.out.println("bs length: "+ bs.length);
						
						FileUtils.writeByteArrayToFile(new File("C:\\temp\\fileupload\\001.pdf"), bs);
						System.out.println("File saved.");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			System.out.println("not Multipart request");
		}

	}

	private void usingTraditionalWay(HttpServletRequest request) {
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);

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
				List<FileItem> items = upload.parseRequest(request);
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
