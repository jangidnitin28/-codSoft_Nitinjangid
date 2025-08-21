import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n Student Grade Calculator");
        System.out.print("Enter number of subjects: ");
        int subjects = sc.nextInt();

        int[] marks = new int[subjects];
        int total = 0;

        // Input marks
        for (int i = 0; i < subjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            int score = sc.nextInt();

            // Validation: 0–100
            while (score < 0 || score > 100) {
                System.out.print("Invalid! Enter marks between 0 and 100: ");
                score = sc.nextInt();
            }
            marks[i] = score;
            total += score;
        }

        
        double average = (double) total / subjects;
        char grade = calculateGrade(average);

        
        System.out.println("\n Result Summary:");
        System.out.println("Total Marks: " + total + "/" + (subjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", average);
        System.out.println("Grade: " + grade);

        sc.close();
    }
    private static char calculateGrade(double percentage) {
        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 75) {
            return 'B';
        } else if (percentage >= 60) {
            return 'C';
        } else if (percentage >= 40) {
            return 'D';
        } else {
            return 'F';
        }
    }
}
