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
        //������Ӧ��������
        servletResponse.setContentType("text/html");
        //��ȡ�ı�д����
        PrintWriter out = servletResponse.getWriter();
        //���ͻ��˻�Ӧ��html�ı�
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello world!</h1>");
        out.println("<body>");
        out.println("<html>");
        out.flush();    //ˢ��д�롣
    }
}
