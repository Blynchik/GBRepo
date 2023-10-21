package newPack;

import java.util.List;

public class ParadigmHW5 {

    public static void main(String[] args) {
        System.out.println(ParadigmHW5.correlationPirson(List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0), List.of(1.0, 2.0, 3.0, 4.0, 5.0, 6.0)));
    }

    public static double correlationPirson(List<Double> arr1, List<Double> arr2) {
        if (arr1.size() != arr2.size()) {
            throw new IllegalArgumentException();
        }

        double avg1 = arr1.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        double avg2 = arr2.stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0);

        double numerator = 0;
        double sum1 = 0;
        double sum2 = 0;

        for (int i = 0; i < arr1.size(); i++) {
            double delta1 = arr1.get(i) - avg1;
            double delta2 = arr2.get(i) - avg2;
            double mult = delta1 * delta2;
            numerator += mult;

            sum1 += Math.pow(delta1, 2);
            sum2 += Math.pow(delta2, 2);
        }

        double denominator = Math.sqrt(sum1 * sum2);

        return numerator / denominator;
    }
}
