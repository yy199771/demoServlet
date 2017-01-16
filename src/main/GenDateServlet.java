package main;

/**
 * Created by yy on 17/1/12.
 */
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class GenDateServlet extends GenericServlet {
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        //设置响应内容类型
        servletResponse.setContentType("text/html");
        //获取文本写入流
        PrintWriter out = servletResponse.getWriter();
        //给客户端回应的html文本
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello world!</h1>");
        out.println("<body>");
        out.println("<html>");
        out.flush();    //刷新写入。
    }
}
