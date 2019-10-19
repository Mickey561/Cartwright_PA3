import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class Cartwright_P1 {
    public static final double epsilon = 0.01;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Variables
        String question, qType;
        int answer, sumCorrect = 0, difficulty, type, randNum1 = 1, randNum2 = 1, count = 0;
        double answerMath, correctAnswer;

        System.out.println("Would you like to begin a sesion? (1) Yes (2) No");
        answer = scnr.nextInt();

        while(answer == 1) {
            System.out.println("What level of difficulty would you like? 1 - 4");
            difficulty = scnr.nextInt();

            System.out.println("What type of problem would you like to practice?" +
                    "\n(1) Addition (2) Multiplication (3) Subtraction (4) division (5) All types");
            type = scnr.nextInt();

            do {
                randNum1 = difficultyCheck(difficulty);
                randNum2 = difficultyCheck(difficulty);

                qType = typeFind(type);
                question = questionCreate(randNum1, randNum2, qType);
                System.out.println(question);

                answerMath = scnr.nextDouble();
                count++;

                switch (qType)
                {
                    case " plus ":
                        correctAnswer = randNum1 + randNum2;
                        break;
                    case " minus ":
                        correctAnswer = randNum1 - randNum2;
                        break;
                    case " times ":
                        correctAnswer = randNum1 * randNum2;
                        break;
                    case " divided by ":
                        correctAnswer = (randNum1 * 1.0) / randNum2;
                        break;
                    default:
                        correctAnswer = 0;
                        break;
                }

                if (Math.abs(answerMath - correctAnswer) < epsilon) {
                    System.out.println(correctResponse());
                    sumCorrect++;
                }
                else {
                    while(Math.abs(answerMath - correctAnswer) > epsilon)
                    {
                        System.out.println(incorrectResponse());
                        System.out.println(question);
                        answerMath = scnr.nextDouble();
                    }
                }
            } while(count < 10);

            System.out.println("You answered " + sumCorrect + " of 10 questions correctly.");

            double correctPercent = (sumCorrect / 10.0) * 100.0;
            if(Math.abs(correctPercent - 100) < (25 + epsilon))
            {
                System.out.println("Congratulations, you are ready to go to the next level!");
            }
            else {
                System.out.println("Please ask your teacher for help.");
            }
            sumCorrect = 0;
            count = 0;
            System.out.println("Would you like to begin a sesion? (1) Yes (2) No");
            answer = scnr.nextInt();
        }
    }

    // A method is used to generate the responses
    public static String correctResponse() {
        SecureRandom ans = new SecureRandom();
        int choice;
        choice = ans.nextInt(4);

        // Correct answer choices
        String answerString;

        switch (choice) {
            case 0:
                answerString = "Very good!";
                break;
            case 1:
                answerString = "Excellent!";
                break;
            case 2:
                answerString = "Nice work!";
                break;
            case 3:
                answerString = "Keep up the good work!";
                break;
            default:
                answerString = "Amazing job!";
                break;
        }
        return answerString;

    }
    public static String incorrectResponse() {
        SecureRandom ans = new SecureRandom();
        int choice;
        choice = ans.nextInt(4);

        String answerString;

        switch (choice) {
            case 0:
                answerString = "No. Please try again.";
                break;
            case 1:
                answerString = "Wrong. Try once more.";
                break;
            case 2:
                answerString = "Don’t give up!";
                break;
            case 3:
                answerString = "No. Keep trying.";
                break;
            default:
                answerString = "No. Try again";
                break;
        }
        return answerString;

    }

    //  A method is used to determine the problem type
    public static String typeFind(int type)
    {
        SecureRandom ans = new SecureRandom();
        int choice = ans.nextInt(4);

        switch(type)
        {
            case 1:
                return " plus ";
            case 2:
                return " times ";
            case 3:
                return " minus ";
            case 4:
                return " divided by ";
            case 5:
                switch(choice)
                {
                    case 1:
                        return " times ";
                    case 2:
                        return " minus ";
                    case 3:
                        return " divided by ";
                    default:
                        return " plus ";
                }
            default:
                System.out.println("Invalid type. Addition is default.");
                return "plus";
        }
    }
    // A method is used to generate the questions
    public static String questionCreate(int x, int y, String type)
    {
        return "How much is " + x + type + y + "?";
    }

    // A method is used to determine the difficulty level
    public static int difficultyCheck(int x)
    {
        SecureRandom rand = new SecureRandom();
        switch (x)
        {
            case 1:
                return rand.nextInt(9) + 1;
            case 2:
                return rand.nextInt(90) + 10;
            case 3:
                return rand.nextInt(900) + 100;
            case 4:
                return rand.nextInt(9000) + 1000;
            default:
                System.out.println("Not a valid difficulty. Level 1 is default.");
                return rand.nextInt(9) + 1;
        }
    }

}


