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
        //如果不存在session会话，则创建一个session对象
        HttpSession session = request.getSession(true);
        //获取session创建时间
        Date createTime = new Date(session.getCreationTime());
        //获取该网页的最后一次访问时间
        Date lastAccessTime = new Date(session.getLastAccessedTime());
        //设置日期输出的格式
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String title = "Servlet Session 实例 - 菜鸟教程";
            Integer visitCount = new Integer(0);
            String visitCountKey = new String("visitCountKey");
            String userIDKey = new String("userID");
            String userID = new String("Runoob");

        //检查网页上是否有新的访问者
        if(session.isNew()){
            title = "Servlet Session 实例 - 菜鸟教程";
            session.setAttribute(userIDKey, userID);
        }else{

        }
    }
}
