package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

/**
 * Created by yy on 17/1/16.
 */
@WebServlet("/HelloFormCookies")
public class HelloFormCookies extends HttpServlet {
    public HelloFormCookies() {
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Ϊ���ֺ����ϴ���Cookies
        Cookie name = new Cookie("name", URLEncoder.encode(request.getParameter("name"),"UTF-8"));//����ת��
        Cookie url = new Cookie("url", request.getParameter("url"));

        //Ϊ����cookies���ù�������Ϊ24Сʱ��
        name.setMaxAge(60*60*24);
        url.setMaxAge(60*60*24);

        //����Ӧͷ���������Cookie
        response.addCookie(name);
        response.addCookie(url);

        //������Ӧ��������
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "���� Cookie ʵ��";
        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<ul>\n" +
                "  <li><b>վ������</b>��"
                + request.getParameter("name") + "\n</li>" +
                "  <li><b>վ�� URL��</b>��"
                + request.getParameter("url") + "\n</li>" +
                "</ul>\n" +
                "</body></html>");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
