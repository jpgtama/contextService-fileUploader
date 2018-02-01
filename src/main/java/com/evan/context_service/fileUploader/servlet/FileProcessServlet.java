/**
 * 
 */
package com.evan.context_service.fileUploader.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author evan
 *
 */
@WebServlet(name = "FileProcessServlet", value = "/fileProcess")
public class FileProcessServlet extends HttpServlet {

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
		super.doPost(req, resp);
	}

}
