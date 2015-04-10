package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class Conneccion {

    Connection link;
    PreparedStatement preparar;
        public String bd="tlapaleriahc";
        public String url="jdbc:mysql://localhost/"+bd;
//        public String url="jdbc:mysql://192.168.1.106/"+bd;
//        public String url="jdbc:mysql://shift-f6.ddns.net/"+bd;
        public String user="root";
        public String pass="";

public  Connection conectar(){
            Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url,this.user,this.pass);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERROR  "+e.getMessage());
        }
    return link;
    }
}