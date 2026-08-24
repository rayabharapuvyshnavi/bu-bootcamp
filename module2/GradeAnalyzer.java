import java.io.*; 
import java.util.ArrayList;
 
public class GradeAnalyzer {
    
    static int invalidScores = 0;
    static int totalProcessed = 0;
    static int countA = 0;
    static int countB = 0;
    static int countC = 0;
    static int countD = 0;
    static int countF = 0;
    public static void main(String[] args) {
        
        // Step 1: read scores from file
        ArrayList<Integer> scores_list = readScores("scores.txt");
        
        // Step 2: calculate statistics
        double average = calculateAverage(scores_list);

        int high_score = (scores_list.isEmpty()) ? 0 : Integer.MIN_VALUE;
        int low_score = (scores_list.isEmpty()) ? 0 : Integer.MAX_VALUE;

        for(Integer score : scores_list){
            if(score < low_score){
                low_score = score;
            }
            if(score > high_score){
                high_score = score;
            }
        }

        for(Integer score : scores_list){
            if(score >= 90){
                countA++;
            } else if(score >= 80){
                countB++;
            } else if(score >= 70){
                countC++;
            } else if(score >= 60){
                countD++;
            }else {
                countF++;
            }
        }

        
        // Step 3: write and print report
        writeReport(scores_list, average, high_score, low_score, "report.txt");

    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        
        System.out.println("Reading Scores from File: " + filename );

        ArrayList<Integer> scores_list = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = reader.readLine()) != null){
                try{
                    // String val = line.trim();
                    
                    // if(!val.isEmpty())
                    //     scores_list.add(Integer.parseInt(line.trim()));
                    // else{
                    //     invalidScores++;
                    //     System.out.println("Empty line found, skipping.");
                    // }
                    totalProcessed++;
                    scores_list.add(Integer.parseInt(line.trim()));

                } catch(NumberFormatException  e){
                    invalidScores++;
                    System.out.println("Not a valid score: " + e.getMessage());
                }
            }
        }catch (IOException e) {
            System.out.println("File Reading Operation Failed " + e.getMessage());
        }
        return scores_list;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        // your code here
        if(scores.isEmpty())
            return 0.0;

        System.out.println("Calculating Average of Scores");
        double sum = 0;
        for(Integer score : scores){
            sum += score;
        }
        return sum / scores.size();
    } 


 
    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores,
                                   double avg, int high, int low,
                                   String outputFile) {

        System.out.println("Writing Report to File: " + outputFile);

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))){
            writer.write("=== Grade Analysis Report ===");
            System.out.println("=== Grade Analysis Report ===");
            writer.newLine();
            writer.write(String.format("Total scores processed: %d%n", totalProcessed));
            System.out.println("Total scores processed: " + totalProcessed);
            writer.write(String.format("Invalid lines skipped: %d%n", invalidScores));
            System.out.println("Invalid lines skipped: " + invalidScores);
            writer.newLine();
            writer.write(String.format("Average score: %.2f%n", avg));
            System.out.println("Average score: " + String.format("%.2f", avg));
            writer.write(String.format("Highest score: %d%n", high));
            System.out.println("Highest score: " + high);
            writer.write(String.format("Lowest score: %d%n", low));
            System.out.println("Lowest score: " + low);     
            writer.newLine();
            writer.write("Grade distribution:\n");
            System.out.println("Grade distribution:");
            writer.write(String.format("A (90-100): %d%n", countA));
            System.out.println("A (90-100): " + countA);
            writer.write(String.format("B (80-89): %d%n", countB));
            System.out.println("B (80-89): " + countB);
            writer.write(String.format("C (70-79): %d%n", countC));
            System.out.println("C (70-79): " + countC);
            writer.write(String.format("D (60-69): %d%n", countD));
            System.out.println("D (60-69): " + countD);
            writer.write(String.format("F (below 60): %d%n", countF));
            System.out.println("F (below 60): " + countF);
            

        }catch(IOException e){
            System.out.println("File writing operation failed: "+ e.getMessage());
        }
        
    }
} 