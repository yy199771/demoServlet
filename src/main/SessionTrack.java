package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yy on 17/1/16.
 */
@WebServlet("/SessionTrack")
public class SessionTrack extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //���������session�Ự���򴴽�һ��session����
        HttpSession session = request.getSession(true);
        //��ȡsession����ʱ��
        Date createTime = new Date(session.getCreationTime());
        //��ȡ����ҳ�����һ�η���ʱ��
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        //������������ĸ�ʽ
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String title = "Servlet Session ʵ�� - ����̳�";
            Integer visitCount = new Integer(0);
            String visitCountKey = new String("visitCountKey");
            String userIDKey = new String("userID");
            String userID = new String("Runoob");

        //�����ҳ���Ƿ����µķ�����
        if(session.isNew()){
            title = "Servlet Session ʵ�� - ����̳�";
            session.setAttribute(userIDKey, userID);
        }else{
            visitCount = (Integer)session.getAttribute(visitCountKey);
            visitCount =visitCount + 1;
            userID = (String) session.getAttribute(userIDKey);
        }
        session.setAttribute(visitCountKey, visitCount);
        // ������Ӧ��������
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String docType = "<!DOCTYPE html>\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + title + "</h1>\n" +
                "<h2 align=\"center\">Session ��Ϣ</h2>\n" +
                "<table border=\"1\" align=\"center\">\n" +
                "<tr bgcolor=\"#949494\">\n" +
                "  <th>Session ��Ϣ</th><th>ֵ</th></tr>\n" +
                "<tr>\n" +
                "  <td>id</td>\n" +
                "  <td>" + session.getId() + "</td></tr>\n" +
                "<tr>\n" +
                "  <td>����ʱ��</td>\n" +
                "  <td>" +  df.format(createTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>������ʱ��</td>\n" +
                "  <td>" + df.format(lastAccessTime) +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>�û� ID</td>\n" +
                "  <td>" + userID +
                "  </td></tr>\n" +
                "<tr>\n" +
                "  <td>����ͳ�ƣ�</td>\n" +
                "  <td>" + visitCount + "</td></tr>\n" +
                "</table>\n" +
                "</body></html>");
    }
}
