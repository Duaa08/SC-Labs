import java.util.Scanner;
import java.sql.*;
public class Lab6 {
	public static void main(String arg[]){
		try{
			while(true){
				System.out.println("Enter: \n 1: To display the records \n 2: To delete a record \n 3: To search for a student");
			
			int x, y;
			String choice, reg;
			Scanner in = new Scanner(System.in);
			choice = in.nextLine();
			x = Integer.parseInt(choice);
		    Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/university_lab6","root","root");   
			Statement stmt=con.createStatement(); 
			if(x == 1){
			ResultSet rs=stmt.executeQuery("select * from student");  
			while(rs.next())  
			System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+rs.getString(7));  
			}
			if(x == 2){
				System.out.println("Enter the registration number of the student.");
				reg = in.nextLine();
				y = Integer.parseInt(reg);
				stmt.executeUpdate("delete from student where student.Reg_num="+ y);
				ResultSet r=stmt.executeQuery("select * from student");  
				while(r.next())
				System.out.println(r.getInt(1)+"  "+r.getInt(2)+"  "+r.getString(3)+"  "+r.getString(4)+"  "+r.getString(5)+"  "+r.getString(6)+"  "+r.getString(7));  
			
			}
			if(x == 3){
				System.out.println("Enter the registration number of the student.");
				reg = in.nextLine();
				y = Integer.parseInt(reg);
				ResultSet r2=stmt.executeQuery("select * from student where student.Reg_num="+ y);  
				if(r2 != null){
					while(r2.next())
	
				System.out.println(r2.getInt(1)+"  "+r2.getInt(2)+"  "+r2.getString(3)+"  "+r2.getString(4)+"  "+r2.getString(5)+"  "+r2.getString(6)+"  "+r2.getString(7));  
				}
				else
					System.out.println("Record not found");
			}
			
			con.close();  }
			}catch(Exception e){ System.out.println(e);}  
		
	}

}
