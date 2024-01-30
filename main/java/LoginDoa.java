import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDoa {
String name,password;
static String dbUrl="jdbc:mysql://localhost:3306/ngpdb";
static String dbUname="root";
static String dbPassword="";
static String dbDriver="com.mysql.cj.jdbc.Driver";
LoginDoa(String name,String password){
	this.name=name;
	this.password=password;
	
	
}
public boolean check() {
	Connection con = null;
		try {
		Class.forName(dbDriver);  //class not found exception
		con = DriverManager.getConnection(dbUrl,dbUname,dbPassword);   //sql Exception

		String sql = "SELECT * FROM signup WHERE name = ? AND password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, password);

        ResultSet rs = ps.executeQuery();
        return rs.next();
		}
		catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}