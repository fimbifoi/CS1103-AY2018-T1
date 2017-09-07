package Lab1;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public class RandomMathQuiz {
    public static void main(String[] args) {

        Talker talker = new Talker();

        QuestionProducer producer = new QuestionProducer();
        Map<String, Integer> questions = producer.makeRandomQuestions(10);


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
                example = String.format("%d %s %d", value1, sign, value2);
                map.put(example, answer);
            }
                return map;

        }
    }

    private static class Talker {
    }
}
