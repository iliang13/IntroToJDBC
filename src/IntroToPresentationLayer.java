import java.util.Scanner;

public class IntroToPresentationLayer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username and password:");
        String userName = scanner.nextLine();
        String password = scanner.nextLine();

        IntroToDAL dal = new IntroToDAL();
        DALVideoGames vgDal = new DALVideoGames();

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Query MealPlanning database");
            System.out.println("2. Query Arcade or VideoGameSystems database");
            System.out.println("3. Call GetRecipes stored procedure");
            System.out.println("4. Run statement method (VideoGameDAL)");
            System.out.println("5. Run prepared statement method (VideoGameDAL)");
            System.out.println("6. Run callable statement method (VideoGameDAL)");
            System.out.println("7. Exit");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    if (dal.TryExecutingAQuery("MealPlanning", "SELECT * FROM Meal", userName, password)) {
                        System.out.println("Successfully connected and queried MealPlanning database.");
                    } else {
                        System.out.println("Failed to query MealPlanning database.");
                    }
                    break;

                case 2:
                    if (dal.TryExecutingAQuery("VideoGameSystems", "SELECT * FROM Games", userName, password)) {
                        System.out.println("Successfully queried VideoGameSystems database.");
                    } else {
                        System.out.println("Failed to query VideoGameSystems database.");
                    }
                    break;

                case 3:
                    if (dal.TryExecutingAStoredProcedure("MealPlanning", userName, password)) {
                        System.out.println("Successfully called GetRecipes stored procedure.");
                    } else {
                        System.out.println("Failed to call stored procedure.");
                    }
                    break;

                case 4:
                    System.out.println("Running statement method (getAllGames):");
                    vgDal.getAllGames();
                    break;

                case 5:
                    System.out.print("Enter a platform (e.g., PS5, Xbox, Switch): ");
                    String platform = scanner.nextLine();
                    System.out.println("Running prepared statement method (getGamesByPlatform):");
                    vgDal.getGamesByPlatform(platform);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
}
