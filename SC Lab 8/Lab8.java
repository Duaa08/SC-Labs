import java.util.Scanner;
import java.sql.*;
public class Lab8 {
	public static void main(String arg[]){
		 try{
			 Class.forName("com.mysql.jdbc.Driver"); 
			 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/lab8","root","root");
			 con.setAutoCommit(false);
			 Statement st=con.createStatement(); 
			 st.executeUpdate("Delete from students8");
			 long startTime = System.currentTimeMillis();
			 CallableStatement(con);
			 long stopTime = System.currentTimeMillis();
		     long elapsedTime = stopTime - startTime;
		     System.out.println(elapsedTime);
		     con.commit();
		 }
		 catch(Exception e){ System.out.println(e);} 
	}

	public static void StatementClass(Connection conn) throws SQLException{
		System.out.println("Entering records using Statement class:");
		Statement stmt=conn.createStatement();
		for(int i= 0; i < 5000; i++){
		String n1 = "Duaa" + i;	
		stmt.executeUpdate("Insert into students8(Reg_Num, SName, Semester, Address) values("+i+", "+"\""+n1+"\""+", 1, 'NUST' )");
		
	}
		ResultSet r2=stmt.executeQuery("select * from students8");
		while(r2.next())
			System.out.println(r2.getInt(1)+"  "+r2.getInt(2)+" "+r2.getString(3)+" "+r2.getInt(4)+" "+r2.getString(5));
	}
	
	public static void PreparedStatementClass(Connection conn) throws SQLException{
		System.out.println("Entering records using PreparedStatement class:");
		Statement stmt2=conn.createStatement();
		PreparedStatement pstmt=conn.prepareStatement("insert into students8(Reg_Num, SName, Semester, Address) values(?,?,?,?)");  
		  
		pstmt.setInt(3,1);
		pstmt.setString(4,"NUST");
		for(int i= 0; i < 5000; i++){
			String n2 = "Duaa" + i;	
			pstmt.setInt(1,i);
			pstmt.setString(2,n2);  
			pstmt.executeUpdate(); 
		}
		ResultSet r2=stmt2.executeQuery("select * from students8");
		while(r2.next())
			System.out.println(r2.getInt(1)+"  "+r2.getInt(2)+" "+r2.getString(3)+" "+r2.getInt(4)+" "+r2.getString(5));
	}
	
	public static void BatchUpdate(Connection conn) throws SQLException{
		System.out.println("Entering records using Batch Update:");
		Statement stmt3=conn.createStatement();	
		for(int i= 0; i < 5000; i++){
			String n1 = "Duaa" + i;
			String SQL = "Insert into students8(Reg_Num, SName, Semester, Address) values("+i+", "+"\""+n1+"\""+", 1, 'NUST' )";
			stmt3.addBatch(SQL);
			}
		stmt3.executeBatch();
		ResultSet r3=stmt3.executeQuery("select * from students8");
		while(r3.next())
			System.out.println(r3.getInt(1)+"  "+r3.getInt(2)+" "+r3.getString(3)+" "+r3.getInt(4)+" "+r3.getString(5));
	}
	
	public static void CallableStatement(Connection conn) throws SQLException{
		System.out.println("Entering records using Callable Statement:");
		Statement stmt5 = conn.createStatement();
		for(int i= 0; i < 5000; i++){
		CallableStatement stmt4=conn.prepareCall("{call new_procedure(?,?,?,?)}"); 
		String n4 = "Duaa" + i;	
		stmt4.setInt(1,i);  
		stmt4.setString(2, n4); 
		stmt4.setInt(3,1);
		stmt4.setString(4, "NUST");
		stmt4.execute(); 
		}
		ResultSet r4=stmt5.executeQuery("select * from students8");
		while(r4.next())
			System.out.println(r4.getInt(1)+"  "+r4.getInt(2)+" "+r4.getString(3)+" "+r4.getInt(4)+" "+r4.getString(5));
	}
	
	
}

