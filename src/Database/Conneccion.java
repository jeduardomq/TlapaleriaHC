package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
public class Conneccion {

    Connection link;
    PreparedStatement preparar;
        public String bd="tlapaleriahc";
        public String url="jdbc:mysql://http://192.168.1.68:3306//"+bd;
        public String user="eduardomq";
        public String pass="lalo12345";

 
public  Connection conectar(){
            Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url,this.user,this.pass);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    return link;
    } 
}