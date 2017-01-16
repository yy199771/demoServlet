package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yy on 17/1/16.
 */
public class ErrorHandler extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Throwable throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) request.getAttribute("javax.servlet.error.servlet_name");
        if(servletName == null){
            servletName = "Unkown";
        }
        String requestUri = (String) request.getAttribute("javax.servlet.error.request_uri");
        if(requestUri == null){
            requestUri ="Unkown";
        }
        //������Ӧ��������
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String title = "����̳� Error/Exception ��Ϣ";

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n");
        out.println("<h1>����̳��쳣��Ϣʵ����ʾ</h1>");
        if(throwable == null && statusCode ==null){
            out.println("<h2>������Ϣ��ʧ</h2>");
            out.println("�뷵�� <a href=\"" +
            response.encodeURL("http://localhost:8080/") +"\">��ҳ</a>��");
        }else if(statusCode != null){
            out.println("������� : " + statusCode);
        }else{
            out.println("<h2>������Ϣ</h2>");
            out.println("Servlet Name : " + servletName + "</br></br>");
            out.println("�쳣���� : " + throwable.getClass( ).getName( ) + "</br></br>");
            out.println("���� URI: " + requestUri + "<br><br>");
            out.println("�쳣��Ϣ: " + throwable.getMessage( ));
        }
        out.println("</body>");
        out.println("</html>");
        }
        // ���� POST ��������ķ���
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
        }
    }

