import java.sql.*;

public class DALVideoGames {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/VideoGameSystems";
    private static final String USER = "root";
    private static final String PASS = "your_password";

    
    public void getAllGames() {
        String query = "SELECT * FROM Games";  
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                System.out.println("Game: " + rs.getString("GameName"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void getGamesByPlatform(String platform) {
        String query = "SELECT * FROM Games WHERE Platform = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, platform);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("Game: " + rs.getString("GameName") + " | Platform: " + rs.getString("Platform"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
