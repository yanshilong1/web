package org.work1;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "/loginServlet1")
public class LoginServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String username=req.getParameter("user");
         String  getpassword=req.getParameter("password");



         PrintWriter out=resp.getWriter();
         String sql="SELECT count(id) FROM test1 where user= ? And password=   ?";

        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            try {
               // Class.forName("com.mysql.jdbc.Driver");

           Class.forName("com.mysql.jdbc.Driver");
                connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","root","123456");
                statement=connection.prepareStatement(sql);
//                statement.setString(1,username);
//                statement.setString(1,getpassword);
                //statement.setString(2,password);
                statement.setString(1,username);
                statement.setString(2,getpassword);
                    resultSet=statement.executeQuery();
                if(resultSet.next()){
                    int count=resultSet.getInt(1);

                        if(count>0){
                            out.write("hello  "+username+count);


                        }else out.println("sorry 1111"+username);
                }else {

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                    statement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
