package org;

import redis.clients.jedis.Jedis;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

@WebServlet(name="loginServlet")
public class loginSerevlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest req, ServletResponse respon) throws ServletException, IOException {

      String  flag="1";
        System.out.println("请求来了");
//PrintWriter print=respon.getWriter();
//print.write("123242234523445");

        System.out.println(req);
   //req.getParameter("user");获取字符串

        String user=req.getParameter("user");
        String pa=req.getParameter("password");
       // JedisTest jedisTest=new JedisTest();
        System.out.println(user);
        System.out.println(pa);



        //jedisTest.jedis= (Jedis) jedisTest.jedis.keys("*");
        //Set set=jedisTest.
//          Jedis jedis=new Jedis("localhost");
////
//        System.out.println("数据库连接成功.....");
//        Set set=jedis.keys("*");
//          Iterator ss=set.iterator();
//         while (ss.hasNext()){
//
//            String k= (String) ss.next();
//            String v=jedis.get(k);
//            System.out.println(v);
//            if (k==user){
//                flag="0";
//
//            }



        System.out.println("前台用户名"+user);
        System.out.println("前台密码"+pa);




//        String[] values=req.getParameterValues("爱好");
//        for(String aa:values){
//           System.out.println(" 他的爱好是   "+aa);
//       }


      //eq.getParameterNames();获取一个k-v对
       Enumeration<String> names=req.getParameterNames();
       while (names.hasMoreElements()){
           String na=names.nextElement();
           String nnn=req.getParameter(na);
           System.out.println("----"+na+"    ---"+nnn);

       }


       //req.getParameterMap()获取一个K，一个V V是一个对象数组
        Map<String,String[]> map=req.getParameterMap();
       for(Map.Entry<String,String[]> entry:map.entrySet()  ){
           System.out.println("  iiii      "+entry.getKey()+"nnnnnn     "+ Arrays.asList(entry.getValue()));
       }

       //获取请求URL
        HttpServletRequest httpServletRequest=(HttpServletRequest)req;
       StringBuffer URL=httpServletRequest.getRequestURL();
        System.out.println("请求我的URL是  "+URL);

        //获取请求方式
        String pr=httpServletRequest.getMethod();
        System.out.println("请求我的方式  "+pr);
        //获取请求的URI

        String uri=httpServletRequest.getRequestURI();
        System.out.println("请求我的URI是 "+uri);

//        PrintWriter printWriter=respon.getWriter();
//        printWriter.println("diyige  ");

            req.getRequestDispatcher("index.jsp").forward(req,respon);


    }



    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
