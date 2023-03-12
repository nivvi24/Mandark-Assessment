import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EmployeeDetails {
    public static void main(String[] args) {
        // Path to the input and output files
        String inputFilePath = "employees.csv";
        String outputManagerFilePath = "managers.csv";
        String outputSingleNameFilePath = "single_name_employees.csv";

        // Open the input file for reading
        try (BufferedReader br = new BufferedReader(new FileReader(inputFilePath))) {
            // Create output file writers
            FileWriter managerWriter = new FileWriter(outputManagerFilePath);
            FileWriter singleNameWriter = new FileWriter(outputSingleNameFilePath);

            // Read the input file line by line
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] tokens = line.split(",");

                // Check if the employee is a manager in the R&D division
                if (tokens[1].trim().equals("Manager") && tokens[2].trim().equals("R&D")) {
                    // Write the details to the managers file
                    managerWriter.write(line);
                    managerWriter.write("\n");
                }

                // Check if the employee has a single name
                if (tokens[0].trim().split(" ").length == 1) {
                    // Write the details to the single name employees file
                    singleNameWriter.write(line);
                    singleNameWriter.write("\n");
                }
            }

            // Close the output file writers
            managerWriter.close();
            singleNameWriter.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
