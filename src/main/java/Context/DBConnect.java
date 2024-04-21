package Context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
    private static Connection conn = null;

    // Phương thức này trả về kết nối đến cơ sở dữ liệu
    public static Connection getConn() throws SQLException {
        if (conn == null || conn.isClosed()) {
            // Thay đổi URL, username, và password cho phù hợp với cơ sở dữ liệu MySQL của bạn
            String url = "jdbc:mysql://localhost:3306/phone_app2";
            String username = "root";
            String password = "Danhthai0311";

            // Load driver
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            // Tạo kết nối
            conn = DriverManager.getConnection(url, username, password);
        }
        return conn;
    }
    public static void main(String[] args) {
    	 try {
             // Lấy kết nối từ lớp DBConnect
             conn = DBConnect.getConn();
             
             if (conn != null) {
                 System.out.println("Kết nối tới cơ sở dữ liệu thành công!");
             } else {
                 System.out.println("Kết nối tới cơ sở dữ liệu không thành công!");
             }
         } catch (SQLException e) {
             e.printStackTrace();
         } finally {
             try {
                 // Đóng kết nối sau khi sử dụng
                 if (conn != null && !conn.isClosed()) {
                     conn.close();
                 }
             } catch (SQLException e) {
                 e.printStackTrace();
             }
         }

	}
 
}
