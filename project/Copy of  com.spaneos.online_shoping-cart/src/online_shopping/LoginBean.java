package online_shopping;

import java.io.Serializable;

public class LoginBean implements Serializable{
	private String uid,pass;

         public LoginBean(){}
         public String getUid() {
                 return uid;
        }

         public void setUid(String uid) {
                 this.uid = uid;
         }
 
         public String getPass() {
                 return pass;
         }
 
         public void setPass(String pass) {
                 this.pass = pass;
         }
 
         @Override
         public int hashCode() {
                 final int prime = 31;
                 int result = 1;
                 result = prime * result + ((pass == null) ? 0 : pass.hashCode());
                 result = prime * result + ((uid == null) ? 0 : uid.hashCode());
                 return result;
         }
 
         @Override
        public boolean equals(Object obj) {
                 if (this == obj)
                        return true;
                if (obj == null)
                         return false;
                 if (getClass() != obj.getClass())
                         return false;
                 LoginBean other = (LoginBean) obj;
                 if (pass == null) {
                         if (other.pass != null)
                                 return false;
                 } else if (!pass.equals(other.pass))
                         return false;
                 if (uid == null) {
                         if (other.uid != null)
                                return false;
                 } else if (!uid.equals(other.uid))
                         return false;
                 return true;
         }
         
         public String validate()
         {
                 String msg;
                 if(uid.equals("admin")&&pass.equals("admin123"))
                         msg="SUCCESS";
                 else
                         msg="Sorry! Invalid login credentials";
                 return msg;     
         }
 }
