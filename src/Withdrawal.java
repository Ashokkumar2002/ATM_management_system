import java.util.Scanner;
import java.sql.*;

public class Withdrawal {
    void withdraw(int cus_id) throws SQLException {
        Connection con = DBconnect.getConnection();
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE AMOUNT : \n");
        int amt = sc.nextInt();
        String query = "UPDATE user SET balance = balance - ? WHERE pin = ?";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setInt(1, amt);
        pstmt.setInt(2, cus_id);
        int rowsUpdated = pstmt.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Withdrawal failed.");

        }

    }
}
