package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yy on 17/1/14.
 */

/**
 * Servlet implementation class HelloForm
 */

// @WebServlet("/HelloForm")

public class HelloForm extends HttpServlet {

    private static final long seriaVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */

    public HelloForm() {
        super();
        //TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest, HttpServletResponse)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置响应内容类型
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String title = "使用GET方法读取表单数据";

        //注意：如果表单提交的数据中有中文数据则需要转码：
        String name = new String(request.getParameter("name").getBytes("ISO8859-1"), "UTF-8");

        String docType = "<!DOCTYPE html> \n";

        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>" +
                "<body bgcolor=\"#f0f0f0\"> \n" +
                "<h1 align = \"center\">" + title + "</h1> \n" +
                "<u1> \n " +
                "<li><b>站点名</b>: "
                + name + "\n" +
                "<li><b>网址</b>: "
                + request.getParameter("url") + "\n" +
                "</u1>\n " +
                "</body></html>"
        );
    }

    //处理POST方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
