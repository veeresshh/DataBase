import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Database {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		String host = "localhost";

		String port = "3306";

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Jyothi", "root",
				"Jyothi@2005");

		Statement s = con.createStatement();

		ResultSet rs = s.executeQuery("select * from UserDetails where Name = 'Ram';");

		while (rs.next())

		{

			WebDriver Driver = new ChromeDriver();

			Driver.get("https://login.salesforce.com");

			Driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("Username"));

			Driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("Password"));

		}

	}

}
