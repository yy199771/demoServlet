package main;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by yy on 17/1/12.
 * 第一个servlet，负责业务
 */
public class ForwardA extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("=== This is forward A===");

        //讲业务部分的数据存储在request对象中，传递给下一个servlet使用

        Date d = new Date();
        request.setAttribute("date", d);
        /* 注意转发的过程
            首先获取一个知道下一棒地址的接力棒对象，然后将这个接力棒传递给下一个servlet，这样便将请求转发了。
         */
        RequestDispatcher disp = request.getRequestDispatcher("/forwardB");
        disp.forward(request, response);
    }
}
