import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Creatingdatabase {

	public static void main(String[] args) {
	Connection connection=null;
	Statement statement=null;
	ResultSet resultset=null;
	
	try {
		Class.forName("sun.jdbc.obdc.JdbcOdbcDriver");
	}
catch(ClassNotFoundException cnfex) {
	System.out.println("Problem in loading" + "MS Access JDBC driver");
	cnfex.printStackTrace();
}
	try {
		String msAccessDBName="Database-C\\Users\\Zikhona\\eclipse-workspace\\src\\DBMLearners.accdb";
		String dbURL="jdbc:odbc:Driver=" +"{Microsoft Access Driver(*.mdb,*accdb)};"+
		"DBQ=" + msAccessDBName+ ";DriverID=22;READONLY=true";
		
		connection= DriverManager.getConnection(dbURL);
		statement=connection.createStatement();
		
		resultset=statement.execute("INSERT INTO Learners Details"+ "VALUES(0111090518080,'Lisakhanya','Tshokolo","09November2001","Female",'12')");"
		System.out.println("Inserted recorf into the table");

		resultset=statement.executeQuery("DELETE FROM Learners Details WHERE tName='Zikhona'");
		System.out.println("Recorde Deleted");
		
		resultset=statement.executeQuery("SELECT * FROM Parents Details WHERE tSurname LIKE 'Z%'");
		
		while(resultset.next()) {
			System.out.println(resultset.getInt(1)+ "\t" +
		resultset.getString(2)+ "\t"+
		resultset.getString(3)+"\t"+
		resultset.getString(4)+"\t"+
		resultset.getString(5)+"\t"+
		resultset.getString(6)+"\t"+
		resultset.getString(7));
		}
	}
	catch(SQLException sqlex) {
		sqlex.printStackTrace();
	}
	finally {
		if (null != connection) {
			resultset.close();
			statement.close();
			
			connection.close();
			}
	}
	catch(SQLException sqlex) {
		sqlex.printStackTrace();
	}
	}

}
