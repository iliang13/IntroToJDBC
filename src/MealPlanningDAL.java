import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MealPlanningDAL {
    private final DataMgr dataMgr;

    public MealPlanningDAL(DataMgr dataMgr) {
        this.dataMgr = dataMgr;
    }

    public List<Meal> getMeals(String username, String password) {
        List<Meal> meals = new ArrayList<>();
        String query = "SELECT * FROM Meal";

        try (Connection conn = dataMgr.getConnection("MealPlanning", username, password);
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                meals.add(new Meal(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("category"),
                    rs.getInt("servings"),
                    rs.getBoolean("isVegetarian"),
                    rs.getString("url")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return meals;
    }
}
