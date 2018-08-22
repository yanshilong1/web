package org;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="check")
public class check implements Servlet {
   int i=0;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest  req, ServletResponse respon) throws ServletException, IOException {

    //servletRequest.getParameter();


   String text=req.getParameter("text");
     System.out.println(text);
//     PrintWriter printWriter=respon.getWriter();
//     printWriter.println("这是后台返回的信息。。。。。");
//
//
//        printWriter.flush();
        req.getRequestDispatcher("inde2.html").forward(req,respon);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
