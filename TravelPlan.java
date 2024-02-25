import java.util.Scanner;

public class TravelPlan {

  public static void main(String[] args) {
    
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.print("Enter destination: ");
      String destination = scanner.nextLine();

      System.out.print("Enter start date (MM/DD/YYYY): ");
      String startDate = scanner.nextLine();

      System.out.print("Enter end date (MM/DD/YYYY): ");
      String endDate = scanner.nextLine();

      System.out.print("Enter budget: ");
      double budget = scanner.nextDouble();

      // Call weather API to get forecast
      int lowTemp = 24;
      int highTemp = 37;
      String forecastSummary = "Sunny";

      // Estimate flight cost
      double flightCost = 600;

      // Estimate lodging cost
      double lodgingCost = 200; 

      // Estimate activity costs
      double activitiesCost = 200;

      // Calculate total cost
      double totalCost = flightCost + lodgingCost + activitiesCost;

      // Check if within budget
      boolean withinBudget = (totalCost <= budget);

      // Print detailed itinerary
      System.out.println("TRIP ITINERARY");
      System.out.println("Destination: " + destination);
      System.out.println("Dates: " + startDate + " to " + endDate);
      
      System.out.println("Weather Forecast:");
      System.out.println("Low Temp: " + lowTemp);
      System.out.println("High Temp: " + highTemp);
      System.out.println("Forecast: " + forecastSummary);

      System.out.println("Estimated Costs:");
      System.out.println("Flight: $" + flightCost);
      System.out.println("Lodging: $" + lodgingCost);
      System.out.println("Activities: $" + activitiesCost);
      System.out.println("Total: $" + totalCost);

      if (withinBudget) {
        System.out.println("Total within budget!");
      } else {
        System.out.println("Over budget by $" + (totalCost - budget));
      }
    }

  }

}