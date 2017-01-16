package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yy on 17/1/12.
 */
public class LoginServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=GB2312");
        request.setCharacterEncoding("GB2312");
        PrintWriter out = response.getWriter();
        //取得客户端提交的数据
        String name = request.getParameter("userName");
        String pwd = request.getParameter("passWord");

        //
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>");
        out.println("Name : " + name + " " + "Password : " + pwd);
        out.println("</h1>");
        out.println("<body>");
        out.println("<html>");
        out.flush();    //刷新写入。
    }

}
