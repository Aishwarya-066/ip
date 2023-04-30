package ex14;


import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import java.sql.*;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
/** *

 * 
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {    /**
     * This is a sample web service operation
     */
 @WebMethod(operationName = "add")
    public int add(@WebParam(name="name") String name,@WebParam(name="id") int id,@WebParam(name="mail")String mail){
  char ct=0;
        try{
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/kushi");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from customers");
            while(rs.next()){
               
                        st.executeUpdate("insert into customers values('"+name+"',"+id+",'"+mail+"')");
                   
                }
               
        }
        catch(Exception e){
            System.out.println(e);
        }
     return ct;
    }

    /**
     * Web service operation
     */
   @WebMethod(operationName = "edit")
    public int edit(@WebParam(name="name") String name,@WebParam(name="id") int id,@WebParam(name="mail")String mail){
  char ct=0;
        try{
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/kushi");
            Statement st=c.createStatement();
            ResultSet rs=st.executeQuery("select * from customers");
            while(rs.next()){
                if(rs.getInt(2)==id){
                 st.executeUpdate("update customer set name='"+name+"',email='"+mail+"' where id="+id+"");  
                   
                }
               
                }
               
        }
        catch(Exception e){
            System.out.println(e);
        }
     return ct;
    }
   
      @WebMethod(operationName = "view")
    public String view(){
        String s = "";
        try{
            ResultSet id = null;
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/kushi");
            PreparedStatement st=c.prepareStatement("select * from customers");
            id=st.executeQuery();
            while(id.next())
            {
                //st.executeQuery("select * from customer");
             String n = id.getString("name");
                int n1 =id.getInt("id");
              String n2 = id.getString("email");
              s += n+" "+n1+" "+n2+"\n";  
             
   
                   
            }
     
     
        }
        catch(Exception e){
            System.out.println(e);
        }
     return s;
    }
     
}

