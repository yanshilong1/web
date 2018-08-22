package org;




import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name="hello")
    public class test1  implements Servlet {
        @Override
        public void init(ServletConfig servletConfig) throws ServletException {
            System.out.println("this is a init");
            String str=servletConfig.getInitParameter("user");
            System.out.println("user   "+str);

            Enumeration<String> name=servletConfig.getInitParameterNames();
            while (name.hasMoreElements()){
                String name1=name.nextElement();

//                String value=servletConfig.getInitParameter(name1);
//                System.out.println("name  "+name1);
//                System.out.println("value "+value);

                ServletContext servl= servletConfig.getServletContext();
                String driver=servl.getInitParameter("driver");
                System.out.println("driver   "+driver);
                String e=servl.getInitParameter("hahahaha");
                System.out.println("第二个用户名"+e);

                Enumeration<String> name2=servl.getInitParameterNames();
                while (name2.hasMoreElements()){
                    String name11=name2.nextElement();
                    System.out.println("---->"+name11);
                }
                String path=servl.getRealPath("/tt");
                System.out.println(path);//获取TT文件的路径名

                String pp=servl.getContextPath();
                String nnn=pp+"www";//获取
                System.out.println(nnn);


            }
        }

        @Override
        public ServletConfig getServletConfig() {
            System.out.println("this is a config");
            return null;
        }

        @Override
        public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
            System.out.println("this is a  service");
        }

        @Override
        public String getServletInfo() {

            System.out.println("this is a getserveltinfo");
            return null;
        }

        @Override
        public void destroy() {
            System.out.println("this is a destory");

        }

        public void HelloServelet(){
            System.out.println("构造 qidong ");
        }
//
//    public static void main(String[] args) {
//        HelloServelet aa=new HelloServelet();
//    }
    }


