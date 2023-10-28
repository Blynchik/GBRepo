package newPack.paradigm6;

import java.util.List;

public class Mse {

    public static double getMse(List<Double> predictions, List<Double> trueValues) {
        if (predictions.size() != trueValues.size()) {
            throw new IllegalArgumentException("Массивы должны быть равной величины");
        }

        double sum = 0;

        for (int i = 0; i < predictions.size(); i++) {
            double squaredError = Math.pow(trueValues.get(i) - predictions.get(i), 2);
            sum += squaredError;
        }

        return sum / predictions.size();
    }
}
