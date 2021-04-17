import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class DBS2 {
		DBS2() throws FileNotFoundException
		{
			initialize();
		}
		public void initialize() throws FileNotFoundException
		{
			String name1="";
			String score1="";
			String name2="";
			String score2="";
			File nameread1=new File("E:\\pictures\\name.txt");
			File scoreread1=new File("E:\\pictures\\score.txt");
			File nameread2=new File("E:\\pictures\\name1.txt");
			File scoreread2=new File("E:\\pictures\\score2.txt");
			
			Scanner nread1=new Scanner(nameread1);
			Scanner sread1=new Scanner(scoreread1);
			Scanner nread2=new Scanner(nameread2);
			Scanner sread2=new Scanner(scoreread2);
			
			while(nread1.hasNextLine())
			{
				name1=nread1.nextLine();
				
			}
			while(sread1.hasNextLine())
			{
				score1=sread1.nextLine();
			}
			while(nread2.hasNextLine())
			{
				name2=nread2.nextLine();
				
			}
			while(sread2.hasNextLine())
			{
				score2=sread2.nextLine();
			}
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","scott","tiger");
			Statement s=c.createStatement();
			/*ResultSet rs=s.executeQuery("select max(player2_score) from player2 ");
			rs.next();
			int num=rs.getInt("max(player2_score)");
			System.out.println(num);*/
		
			s.executeQuery("insert into player2 values('"+name1+"','"+Integer.parseInt(score1)+"','"+name2+"','"+Integer.parseInt(score2)+"')");
		
			} catch (ClassNotFoundException  | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	public static void main(String[] args) throws FileNotFoundException  {
		// TODO Auto-generated method stub
		
		DBS2 dbs=new DBS2();
		


		
		
	}

}
