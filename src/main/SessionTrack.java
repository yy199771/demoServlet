package main;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yy on 17/1/16.
 */
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

        }
    }
}
