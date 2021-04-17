import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DBS {
	
	
		DBS() throws FileNotFoundException
		{
			initialize();
		}
		public void initialize() throws FileNotFoundException
		{
			String name="";
			String score="";
			File nameread=new File("E:\\pictures\\name.txt");
			File scoreread=new File("E:\\pictures\\score.txt");
			Scanner nread=new Scanner(nameread);
			Scanner sread=new Scanner(scoreread);
			
			while(nread.hasNextLine())
			{
				name=nread.nextLine();
				
			}
			while(sread.hasNextLine())
			{
				score=sread.nextLine();
			}
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
						Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			
			Statement s=c.createStatement();

			s.executeQuery("insert into player1 values('"+name+"','"+Integer.parseInt(score)+"')");
			
			} catch (ClassNotFoundException  | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		DBS dbs=new DBS();
		


		
		
	}

}
