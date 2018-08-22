package org.work1;

import jdk.internal.org.objectweb.asm.Handle;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "/work1Servlet")
public class work1Servlet implements Servlet {
private ServletConfig  servletConfig;
@Override
    public void init(ServletConfig servletConfig) throws ServletException {
            this.servletConfig=servletConfig;


    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest Request, ServletResponse Response) throws ServletException, IOException {
//请求参数
        String username=Request.getParameter("username");
        String  password=Request.getParameter("password");


        //获取输入
ServletContext servletContext=servletConfig.getServletContext();
 String inituser=servletContext.getInitParameter("user");
 String initpassword=servletContext.getInitParameter("password");
        System.out.println(inituser);
        System.out.println(initpassword);

        System.out.println(username);
        System.out.println(password);
 PrintWriter printWriter=Response.getWriter();
 if(initpassword.equals(password)&&inituser.equals(username)){
//     printWriter.println("hello  " +username);
//     printWriter.flush();
     Request.getRequestDispatcher("index.html").forward(Request,Response);


 }else{
     printWriter.println("sorry "+username);
     printWriter.flush();

 }


        // 比对

        //响应






    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
