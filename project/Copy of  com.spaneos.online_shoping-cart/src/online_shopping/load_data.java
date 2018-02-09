package online_shopping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
  
public class load_data {
    
    static PreparedStatement ps_sql = null;
    static ResultSet rs = null;
    static CategoryBean cb=null;
  
    public static ArrayList<CategoryBean> load() throws SQLException, InstantiationException, IllegalAccessException{
         
         Connection con1 = (Connection) JDBCHelper.getConnection();
         ArrayList<CategoryBean> list=new ArrayList<CategoryBean>();
         ps_sql = con1.prepareStatement("select * from categories");
         ps_sql.execute();
         rs = ps_sql.getResultSet();
         while (rs.next()) {   
             cb =new CategoryBean(); 
             cb.setCat(rs.getString("cname"));
             cb.setDes(rs.getString("description"));
             list.add(cb);
         }
        
         System.out.println(list);
         return list;
                  
           
   }
 
   public static ArrayList<CategoryBean> load(String cat) throws SQLException, InstantiationException, IllegalAccessException {
         Connection con1 = (Connection) JDBCHelper.getConnection();
         ArrayList<CategoryBean> list=new ArrayList<CategoryBean>();
         System.out.println(cat);
         ps_sql = con1.prepareStatement("select * from categories where cname=?");
         ps_sql.setString(1,cat);
         ps_sql.execute();
         rs = ps_sql.getResultSet();
         while (rs.next()) {   
             cb =new CategoryBean(); 
             cb.setCat(rs.getString("cname"));
             cb.setDes(rs.getString("description"));
             
             list.add(cb);
     }
   
         System.out.println(list);
         return list;
                       
                    
    }
}

