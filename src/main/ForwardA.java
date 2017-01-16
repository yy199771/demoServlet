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
 * ��һ��servlet������ҵ��
 */
public class ForwardA extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("=== This is forward A===");

        //��ҵ�񲿷ֵ����ݴ洢��request�����У����ݸ���һ��servletʹ��

        Date d = new Date();
        request.setAttribute("date", d);
        /* ע��ת���Ĺ���
            ���Ȼ�ȡһ��֪����һ����ַ�Ľ���������Ȼ��������������ݸ���һ��servlet�������㽫����ת���ˡ�
         */
        RequestDispatcher disp = request.getRequestDispatcher("/forwardB");
        disp.forward(request, response);
    }
}
