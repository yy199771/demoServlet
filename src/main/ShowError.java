package main;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by yy on 17/1/15.
 */
@WebServlet("/ShowError")
public class ShowError extends HttpServlet {
    //����GET���󷽷�
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //���ô�������ԭ��
        response.sendError(407, "Need authentication!!!");
    }
    //����POST��������ķ���
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
