import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Deposit {
    void deposit(int pin) throws SQLException {

        Connection con = DBconnect.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE AMOUNT : \n");
        int amt = sc.nextInt();
        String query = "UPDATE user SET balance = balance + ? WHERE pin = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, amt);
        pstmt.setInt(2, pin);
        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Deposit failed.");

        }

    }

}
