import java.util.Scanner;
import java.sql.*;
public class Menu extends Pin_Verification{
    void menuOptions(int user_pin) throws SQLException {
        Scanner sc=new Scanner(System.in);
        int cus_id=0;
        int choice= 0;
        while(choice!=4){
            System.out.println("**********   MENU   **********");
            System.out.println("1 - CHECK BALANCE");
            System.out.println("2 - WITHDRAWAL FROM SAVINGS");
            System.out.println("3 - DEPOSIT MONEY");
            System.out.println("4 - EXIT");
            try {
                choice = sc.nextInt();
                if(choice>4){
                    errorHandling();
                }
            }
            catch (Exception e){
                Exceptions exp=new Exceptions();
                exp.errorHandling();
                break;
            }
            switch (choice){
                case 1:
                    Connection con = DBconnect.getConnection();
                    CallableStatement cst = con.prepareCall("{call GetIdByPin(?)}");
                    cst.setInt(1, user_pin);
                    ResultSet rs = cst.executeQuery();

                    if (rs.next()) {
                        int id = rs.getInt(1);

                        String query = "SELECT balance FROM user WHERE customer_id = ?";
                        cus_id=id;
                        PreparedStatement pstmt = con.prepareStatement(query);
                        pstmt.setInt(1, id);
                        ResultSet res = pstmt.executeQuery();
                        if (res.next()) {
                            System.out.println("THE BALANCE IS : " + res.getInt("balance"));
                        } else {
                            System.out.println("No balance information found.");
                        }
                    } else {
                        System.out.println("No user found for the provided PIN.");
                    }
                    break;
                case 2:
                    Withdrawal amt=new Withdrawal();
                    amt.withdraw(user_pin);
                    break;
                case 3:
                    Deposit damt=new Deposit();
                    damt.deposit(user_pin);
                    System.out.print("\n");
                    break;


            }
        }

    }
}
