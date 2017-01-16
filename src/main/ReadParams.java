package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * Created by yy on 17/1/15.
 */
@WebServlet("/ReadParams")
public class ReadParams extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ReadParams(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //������Ӧ��������
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();

        String title = "��ȡ���еı�����";
        String docType =
                "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";

        out.println(docType +
                "<html>\n" +
                "<head><meta charset=\"utf-8\"><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<table width=\"100%\" border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "<th>��������</th><th>����ֵ</th>\n"+
                "</tr>\n");

        Enumeration paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()){
            String paramName = (String)paramNames.nextElement();
            out.print("<tr><td>" + paramName + "</td> \n");
            String[] paramValues = request.getParameterValues(paramName);
            //��ȡ����ֵ������
            if(paramValues.length ==1){
                String paramValue = paramValues[0];
                if(paramValues.length == 0){
                    out.println("<td><i>û��ֵ</i></td>");
                }else{
                    out.println("<td>" + paramValue + "</td>");
                }
            }else{
                //��ȡ���ֵde����
                out.println("<td><u1>");
                for(int i = 0; i < paramValues.length; i++){
                    out.println("<li>" + paramValues[i]);
                }
                out.println("</u1></td>");
            }
            out.println("</tr>");
        }
        out.println("\n</table>\n</body></html>");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }
}
