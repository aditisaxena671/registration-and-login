import java.sql.*;
class jdbcp2{ 
public static void main(String args[])
{
try{
//Step 1: Register the driver class
Class.forName("net.ucanaccess.jdbc.UcanaccessDriver"); 
//Specifies DBMS name e.g MS-Access or Oracle or My SQL 

//Step 2: Create connection
String dbURL = "jdbc:ucanaccess://"+ "D:/f123/empdb.accdb";
Connection  con=DriverManager.getConnection(dbURL);
//Specifies path, version/format and Database name e.g empdb.accdb in our program
 //Database name is empdb.accdb and Table name is emp(eno,ename,eadd)

//Step 3: Preparestatement/query
//Insertion
PreparedStatement stmt1=con.prepareStatement("insert into emptb values(?,?,?)");
stmt1.setString(1,"e1");//1 specifies the first parameter in the query i.e. empno 	
stmt1.setString(2,"n1");
stmt1.setString(3,"a11");
//In case of other type
//stmt1.setInt(3,Integer.parseInt(tf3.getText()));

//Step 4: Executestatement/query
stmt1.execute();
System.out.println("Record Inserted Successfully!!!!!!!");

//Step 5: Close connection
con.close();

}
catch(Exception e)
{  System.out.println(e.toString());} 
}}
