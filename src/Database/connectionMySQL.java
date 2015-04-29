package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class connectionMySQL {

        private String DRIVER = "com.mysql.jdbc.Driver";
	private String DB;
	private String URL;
	private String USER;
	private String PASSW;
        
        ResultSetTableModel ResultTable;

	Connection connection = null; 
	Statement instruction = null; 
	ResultSet Results = null; 
        

    public connectionMySQL(String DB,String URL,String USER,String PASSW){
		
		this.DB = DB;
		this.URL = URL;
		this.USER = USER;
		this.PASSW = PASSW;

		Connection();

    }

    public String getDB() {
        return DB;
    }

    public void setDB(String DB) {
        this.DB = DB;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUSER() {
        return USER;
    }

    public void setUSER(String USER) {
        this.USER = USER;
    }

    public String getPASSW() {
        return PASSW;
    }

    public void setPASSW(String PASSW) {
        this.PASSW = PASSW;
    }

    public ResultSetTableModel getResultTable() {
        return ResultTable;
    }

    public String getDRIVER() {
        return DRIVER;
    }

    public void setDRIVER(String DRIVER) {
        this.DRIVER = DRIVER;
    }
    
    
    
        
    public void Connection()
    {
	try
	{
            Class.forName( DRIVER );
            connection = DriverManager.getConnection( URL, USER, PASSW );
            instruction = connection.createStatement();
                   
        }catch(Exception e)
            {
                System.out.println("Error en la Conexión a MYSQL");
            }
    }
    
    public void closeConnection()
   {
   	try
   	{
            Results.close();
            instruction.close();
            connection.close();
            
   	}catch(Exception e)
   	{
            System.out.println("Close FAIL");
   	}
   }
   
   public String [] executeQueryArray(String query, String DB)
        {
       
       String [] DBS = null;
       ArrayList<String> list = new ArrayList<String>();
       
       try {
           
           instruction.execute("USE "+DB);
           Results = instruction.executeQuery(query);
           ResultSetMetaData metaDate = Results.getMetaData();
           int noColumn = metaDate.getColumnCount();
           
           while ( Results.next() )
            {   
                for ( int i = 1; i <= noColumn; i++ )
                {
                   list.add(Results.getString(i));   
                }
            }
             
           DBS = new String[list.size()];
           
            for ( int i = 0; i < list.size(); i++ )
                {
                   DBS[i] = list.get(i);
                }
           
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
            return DBS;
       }

    public ResultSetTableModel executeQueryTable(String Query,String DB)
	{
		try
		{
                    
                    instruction.execute("USE "+DB);
                    ResultTable = new ResultSetTableModel(DRIVER,URL,USER,PASSW,Query);
                    
		}catch(Exception e)
		{
			System.out.println("Connection FAIL Table");
		}
        return ResultTable;
	}
   
    public void executeInstruction(String DB, String Ins)
   {
   	try
   	{
             
            instruction.execute("USE "+DB);
            instruction.execute(Ins);
                
   	}catch(Exception e)
            {
            	System.out.println("ExecuteInstruction FAIL "+e.getLocalizedMessage());
            }	
   }
    
   public DefaultTableModel makeModelTable(String titles[],String query,DefaultTableModel tModel){
       String arrayQ[] = executeQueryArray(query, DB);
       
       int lengthx = titles.length;
       int temp = 0;
       int lengthy = arrayQ.length/lengthx;
       
       String arrayRow[] = new String[lengthx];
       for (int i = 0; i < lengthx; i++) {
           tModel.addColumn(titles[i]);
       }
       
       for (int i = 0; i < lengthy; i++) 
       {
           for (int j = 0; j < lengthx; j++) {
            arrayRow[j] = arrayQ[temp];
            temp++;
           }
           tModel.addRow(arrayRow);
       }
       return tModel;
   }


}
