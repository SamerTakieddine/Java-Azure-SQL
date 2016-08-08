import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
public class HelloSQLAzure {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String connectionString = "jdbc:sqlserver://sqljava.database.windows.net:1433;database=MyFirstSQL;user=samer@sqljava;password=s@123456;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		
		try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            connection = DriverManager.getConnection(connectionString);

            String sqlString = 
            		
            		//To create a table
            		"CREATE TABLE Person (" + 
                    "[PersonID] [int] IDENTITY(1,1) NOT NULL," +
                    "[LastName] [nvarchar](50) NOT NULL," + 
                    "[FirstName] [nvarchar](50) NOT NULL)";
            		
            		//To create an index
            		/*"CREATE CLUSTERED INDEX index1 " + "ON Person (PersonID)";*/
            		
            		//To insert rows
                    /*"SET IDENTITY_INSERT Person ON " + 
                        "INSERT INTO Person " + 
                        "(PersonID, LastName, FirstName) " + 
                        "VALUES(1, 'Takieddine', 'Samer')," + 
                              "(2, 'Tabbara', 'Majd')," + 
                              "(3, 'AbuHijleh', 'Yahya')," + 
                              "(4, 'Yee', 'Faissal')," + 
                              "(5, 'Wilson', 'Jim')";*/
            		
            		//To retrieve rows
            		//"SELECT TOP 10 * FROM Person";

            		//Where clause to retrieve a specific row
            		//"SELECT * FROM Person WHERE FirstName = 'Majd'";
            		
            		//To retrieve a count of rows
            		//"SELECT COUNT (PersonID) FROM Person";
            		
            		//To update rows
            		//"UPDATE Person " + "SET LastName = 'Hazime' " + "WHERE FirstName='Faissal'";
            		
            		//To delete rows
                    /*"DELETE from Person " + 
                        "WHERE FirstName='Jim'";*/
            		
            		//To check if a table exists
            		/*"IF EXISTS (SELECT 1 " +
                    "FROM sysobjects " + 
                    "WHERE xtype='u' AND name='Person') " +
                    "SELECT 'Person table exists.'" +
                    "ELSE  " +
                    "SELECT 'Person table does not exist.'";*/
            		
            statement = connection.createStatement();

            //resultSet = statement.executeQuery(sqlString);
            
            /*while(resultSet.next()) //To see rows
            {
            	System.out.println("Person with ID" + resultSet.getString("PersonID") + "has name " + resultSet.getString("FirstName") + " " + resultSet.getString("LastName"));
            }*/
            
            /*while(resultSet.next()) //To see row count
            {
                System.out.println("There were " + 
                        resultSet.getInt(1) +
                        " rows returned.");
            }*/
            
            /*while(resultSet.next())//To see if table exists or not
            {
            	System.out.println(resultSet.getString(1));
            }*/
            
            statement.executeUpdate(sqlString);

            System.out.println("Processing complete.");

        }
        catch (ClassNotFoundException cnfe)  
         {

            System.out.println("ClassNotFoundException " +
                               cnfe.getMessage());
        }
        catch (Exception e)
        {
            System.out.println("Exception " + e.getMessage());
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (null != connection) connection.close();
                if (null != statement) statement.close();
                if (null != resultSet) resultSet.close();
            }
            catch (SQLException sqlException)
            {
            	
            }
        }
	}

}
