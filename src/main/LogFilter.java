package main;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by yy on 17/1/15.
 */

public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
        //��ó�ʼ������
        String site = config.getInitParameter("Site");
        //�����ʼ������
        System.out.println("��վ���ƣ�" + site);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //���վ������
        System.out.println("վ����ַ��http://www.runoob.com");
        //�����󴫻ع�����
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        /* �� Filter ʵ���� Web �����ӷ����Ƴ�֮ǰ���� */
    }
}
