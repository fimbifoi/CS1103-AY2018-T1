package Lab1;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMathQuiz {
    public static void main(String[] args) {

        Talker talker = new Talker();
        talker.prepareQuiz();

        QuestionProducer producer = new QuestionProducer();
        Map<String, Integer> questions = producer.makeRandomQuestions(talker.getCountOfQuestions());

        talker.doQuiz(questions);



    }

    private static class QuestionProducer {
        String example;
        Integer answer;


        Map<String, Integer> map = new HashMap<>();

        public Map<String, Integer> makeRandomQuestions(int count) {
            for (int i = 0; i < count; i++) {
                int value1 = ThreadLocalRandom.current().nextInt(0, 99);
                String[] signs = {"+", "-", "*", "/"};
                String sign = signs[ThreadLocalRandom.current().nextInt(0, 3)];
                int value2 = ThreadLocalRandom.current().nextInt(0, 99);

                switch (sign) {
                    case "+":
                        answer = value1 + value2;
                        break;
                    case "-":
                        answer = value1 - value2;
                        break;
                    case "*":
                        answer = value1 * value2;
                        break;
                    case "/":
                        answer = value1 / value2;
                        break;
                }
                example = String.format("%d %s %d = ", value1, sign, value2);
                map.put(example, answer);
            }
                return map;

        }
    }

    private static class Talker {
        String name;
        Double score;
        Boolean enough;
        Scanner scanner;

        int countOfQuestions;

        public void prepareQuiz() {

            System.out.print("Hello. This is quiz for check your basic arithmetic skills. Please, enter your name: ");
            name = scanner.nextLine();
            System.out.println();
            System.out.printf("%s, Now tell me please count of question that you ready to solve: ", name);
            countOfQuestions = scanner.nextInt();
            if (countOfQuestions < 1) {
                System.out.print("please, enter correct count of questions (1 or more): ");
                countOfQuestions = scanner.nextInt();
            }
        }

        public Talker() {
            name = "";
            score = 0.0;
            enough = false;
            scanner = new Scanner(System.in);
            countOfQuestions = 0;
        }

        public int getCountOfQuestions() {
            return countOfQuestions;
        }

        public void doQuiz(Map<String, Integer> questions) {
            while (!enough) {
                for (Map.Entry<String, Integer> entry : questions.entrySet()) {
                    System.out.print(entry.getKey());
                    if (entry.getValue() == scanner.nextInt()) {
                        score++;
                        System.out.println("correct! next:");
                    }
                    else {
                        System.out.print("incorrect. please, try again: " + entry.getKey());
                        if (entry.getValue() == scanner.nextInt()) {
                            System.out.println("correct witch the second try. next: ");
                            score = score + 0.5;
                        }
                        else System.out.println("incorrect again. next: ");
                    }
                }
                System.out.printf("well done. your result is %.2f of %d possible.\n", score, questions.size());
                score = 0.0;
                System.out.println("want to play again? (y/n)");
                if (scanner.next().equalsIgnoreCase("n")) enough = true;

            }

        }
    }

}
