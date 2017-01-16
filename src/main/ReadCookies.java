package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by yy on 17/1/16.
 */
@WebServlet("/ReadCookies")
public class ReadCookies extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadCookies() {
        super();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie cookie = null;
        Cookie[] cookies = null;

        //获取与该域相关的Cookie的数组
        cookies = request.getCookies();
        // 设置响应内容类型
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        String title = "Delete Cookie Example";

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" );

        if(cookies != null){
            out.println("<h2>Cookies 名称和值</h2>");
            for(int i=0;i<cookies.length; i++){
                cookie = cookies[i];
                if(cookie.getName().compareTo("name") == 0){
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    out.println("已删除的cookies：" + cookie.getName() + "<br/>");
                }
            out.println("名称：" + cookie.getName() + "，");
            out.println("值：" + URLDecoder.decode(cookie.getValue(), "UTF-8") + "<br/>");
            }
        }else{
            out.println("<h2 class=\"tutheader\">No Cookie founds</h2>");
        }
        out.println("</body>");
        out.println("</html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}
