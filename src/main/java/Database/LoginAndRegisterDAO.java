package Database;

import BusinessLogic.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginAndRegisterDAO {

    public static Integer checkIfUsernameIsUnique(String username) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("select count(*) as count from bank where username = ?");
        stmt.setString(1, username);

        ResultSet resultSet = stmt.executeQuery();
        int count = 0;
        while (resultSet.next()) {
            count = Integer.valueOf(resultSet.getString("count"));
        }
        return count;
    }

    public static void insertUser(User user) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into bank  (fname,mname,lname,address,pincode,city,dob,pan,aadhar,amount,username,password) " +
                "values (?,?,?,?,?,?,?,?,?,?,?,?);");
        stmt.setString(1, user.getFname());
        stmt.setString(2, user.getMname());
        stmt.setString(3, user.getLname());
        stmt.setString(4, user.getAddress());
        stmt.setInt(5, user.getPincode());
        stmt.setString(6, user.getCity());
        stmt.setString(7, user.getDob());
        stmt.setString(8, user.getPan());
        stmt.setInt(9, user.getAadhar());
        stmt.setInt(10, user.getAmount());
        stmt.setString(11, user.getUsername());
        stmt.setString(12, user.getPassword());

        stmt.execute();
    }

    public static Integer checkValidUser(String username, String password) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("select count(*) as count from bank where username = ? and password = ?");
        stmt.setString(1, username);
        stmt.setString(2, password);
        ResultSet resultSet = stmt.executeQuery();
        int count = 0;
        while (resultSet.next()) {
            count = Integer.valueOf(resultSet.getString("count"));
        }
        return count;
    }

    public static User customerInfo(String uname) throws SQLException{
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("select * from bank where username = ? ");
        stmt.setString(1, uname);

        ResultSet resultSet = stmt.executeQuery();
        User user=new User();
        while (resultSet.next()) {
          String fname= resultSet.getString("fname");
            String mname= resultSet.getString("mname");
            String lname= resultSet.getString("lname");
            String address= resultSet.getString("address");
            Integer pincode= resultSet.getInt("pincode");
            String city= resultSet.getString("city");
            String dob= resultSet.getString("dob");
            String pan= resultSet.getString("pan");
            Integer aadhar= resultSet.getInt("aadhar");
            Integer amount= resultSet.getInt("amount");
            String username= resultSet.getString("username");
            String password= resultSet.getString("password");

            user.setFname(fname);
            user.setMname(mname);
            user.setLname(lname);
            user.setAddress(address);
            user.setPincode(pincode);
            user.setCity(city);
            user.setPan(pan);
            user.setAadhar(aadhar);
            user.setAmount(amount);
            user.setUsername(username);
            user.setPassword(password);
            user.setDob(dob);

        }
        return user;
    }
}
