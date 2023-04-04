import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverInfo;

public class jdbcConnection {
	public static void main(String[] args) throws SQLException {

		String host = "localhost";
		String port = "3306";
		// for mysqlDatabase

		Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/demo", "root",
				"Maman1986!");
		WebDriver driver = new ChromeDriver();
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select * from credentials where scenario ='zerobalancecard'");
		while (rs.next()) {
			
			driver.get("https://login.salesforce.com");

			driver.findElement(By.xpath(".//*[@id='username']")).sendKeys(rs.getString("username"));
			driver.findElement(By.xpath(".//*[@id='password']")).sendKeys(rs.getString("password"));

		}
	}
}
