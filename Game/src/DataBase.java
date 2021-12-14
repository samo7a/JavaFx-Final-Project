import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class DataBase {

	static Connection conn = null;
	public static void createNewDataBase(String fileName) {
		String url = "jdbc:sqlite:C://db/" + fileName;
		try(Connection conn = DriverManager.getConnection(url)){
			if(conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is " + meta.getDriverName());
				System.out.println("Done");
			}
		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error catch create new data base");
		}



	}
	public static void connectAndCreateTable() {

		try {
			String url = "jdbc:sqlite:C://db/GreatestScore";
			conn = DriverManager.getConnection(url);
			System.out.println("Connection has been established");

			String sql = "create table if not exists Players("
					+ "id integer primary key,"
					+ "name text not null,"
					+ "score integer"
					+ ")";
			Statement stmt = conn.createStatement();
			stmt.execute(sql);


		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error catch connect and create");
		}


	}

	public static void insertPlayer(Player player) {		
		try {
			String sqlInsert = "Insert into Players ("
					+ "name,"
					+ "score)"
					+ " values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sqlInsert);
			pstmt.setString(1,player.getName());
			pstmt.setInt(2,player.getScore());
			pstmt.executeUpdate();

		} 
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in catch insert");
		}


	}
	public static void showScore() {

		try {
			Statement stmt = conn.createStatement();
			String sqlGetInfo = "select id, name, score from Players "
					+ "order by score ASC "
					+ "limit 10; " ;
			ResultSet rs = stmt.executeQuery(sqlGetInfo);
			System.out.println("ID      :     Name   :   Score   ");

			while(rs.next()) {
				System.out.println(rs.getInt("id")+"\t\t"+rs.getString("name")+"\t\t"+rs.getInt("score"));
			}

		}
		catch(SQLException e) {
			System.out.println(e.getMessage());
			System.out.println("Error in catch showscore");
		}
	}
	
	public static void closeConnection() {
		if(conn != null) {
			try {conn.close();
			}
			catch(SQLException e) {
				System.out.println(e.getMessage());
				System.out.println("Error catch close connection");
			}
		}
	}
	


	
	public static void main(String[] args) {
		// create a new data base file
		//createNewDataBase("GreatestScore.db");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// connect to the created data base file and create a new table
		connectAndCreateTable();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// create objects to be inserted into the data base 
		/*Person Ahmed = new Person("Ahmed","Elshetany",26,8776367,993039939);
		Person Messi = new Person("Leonel","Messi",32,918828,8836774);
		Person John = new Person("John","Cena",35,8838939,1992838);
		Person Mickey = new Person("Mickey","Mouse",104,86543456,4562762);
		Person Simba = new Person("Lion","King",11,876543,654345678);
		// insert the previous objects to the data base
		/*insertPerson(Ahmed);
		insertPerson(Messi);
		insertPerson(John);
		insertPerson(Mickey);
		insertPerson(Simba);*/
		Player Ahmed = new Player();
		insertPlayer(Ahmed);
		// print the data base
		//printTable();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// will print out the row in the data base corresponding to the id number (method's parameter)
		//selectPerson(4);
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// Testing findAllPeople() method.
		//ArrayList<Person> person = findAllPeople();
		//System.out.println(person);  // I am not sure if that what you meant by " Demonstrate that it is working correctly. "
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// Test deletePerson method, one with wrong parameters and one with the right parameters
		//deletePerson("Cristiano","Ronaldo");
		//deletePerson("Mickey","Mouse");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		// print the table again to make sure we deleted the previous rows
		//printTable();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		//System.out.println(findAllPeople()); 
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		showScore();
		//insertPerson(John);
		//printTable();
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		//closeConnection();
	}

}
