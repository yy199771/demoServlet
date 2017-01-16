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
    //处理GET请求方法
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //设置错误代码和原因
        response.sendError(407, "Need authentication!!!");
    }
    //处理POST方法请求的方法
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
