import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataMgr {
    private static final String MEAL_PLANNING_URL = "jdbc:mysql://localhost:3306/MealPlanning";
    private static final String ARCADE_GAMES_URL = "jdbc:mysql://localhost:3306/ArcadeGames";
    private static final String VIDEO_GAME_SYSTEMS_URL = "jdbc:mysql://localhost:3306/VideoGameSystems";
    
    public Connection getConnection(String dbName, String username, String password) throws SQLException {
        String url;
        
        switch (dbName) {
            case "MealPlanning":
                url = MEAL_PLANNING_URL;
                break;
            case "ArcadeGames":
                url = ARCADE_GAMES_URL;
                break;
            case "VideoGameSystems":
                url = VIDEO_GAME_SYSTEMS_URL;
                break;
            default:
                throw new IllegalArgumentException("Unknown database: " + dbName);
        }
        
        return DriverManager.getConnection(url, username, password);
    }
}
