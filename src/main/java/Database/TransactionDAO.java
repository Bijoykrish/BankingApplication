package Database;

import BusinessLogic.Ministatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    public static void miniStatement(String username, Integer amount, String date, Integer debit, Integer credit, String remark) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("insert into ministatement  (username, amount, dates, debit, credit, remark) " + "values (?,?,?,?,?,?);");
        stmt.setString(1, username);
        stmt.setInt(2, amount);
        stmt.setString(3, date);
        stmt.setInt(4, debit);
        stmt.setInt(5, credit);
        stmt.setString(6, remark);
        stmt.execute();
    }

    public static List<Ministatement> getMiniStatement(String username) throws SQLException {
        Connection connection = DatabaseConfiguration.getConnection();
        PreparedStatement stmt = connection.prepareStatement("select * from ministatement where username = ? order by dates desc  limit 10");
        stmt.setString(1, username);

        ResultSet resultSet = stmt.executeQuery();
        List<Ministatement> ministatementList = new ArrayList<>();

        while (resultSet.next()) {
            Ministatement ministatement = new Ministatement();
            ministatement.setUsername(resultSet.getString("username"));
            ministatement.setDate(resultSet.getString("dates"));
            ministatement.setRemark(resultSet.getString("remark"));
            ministatement.setAmount(resultSet.getInt("amount"));
            ministatement.setDebit(resultSet.getInt("debit"));
            ministatement.setCredit(resultSet.getInt("credit"));
            ministatementList.add(ministatement);
        }
        return ministatementList;
    }
}
