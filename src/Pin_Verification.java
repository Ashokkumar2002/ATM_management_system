import java.sql.*;
import java.util.*;
class Pin_Verification extends Exceptions{

    public void pinVerify() throws SQLException {
        Scanner sc = new Scanner(System.in);

        int attempts = 3;
        int userPin;

        try (Connection con = DBconnect.getConnection()) {
            while (attempts > 0) {
                System.out.println("ENTER THE PIN NUMBER ONLY " + attempts + " ATTEMPTS LEFT : ");
                userPin = sc.nextInt();

                CallableStatement cst = con.prepareCall("{call GetNameByPin(?)}");
                cst.setInt(1, userPin);

                try (ResultSet rs = cst.executeQuery()) {
                    if (rs.next()) {
                        String name = rs.getString("username");
                        System.out.println("Name is " + name);
                        Menu option = new Menu();
                        option.menuOptions(userPin);
                        break;
                    } else {
                        System.out.println("Invalid PIN. Please try again.");
                        attempts--;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
