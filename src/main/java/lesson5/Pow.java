package lesson5;

public class Pow {
    public static double  pow(double val, int power) {
        if (power == 0) {
            return 1;
        }
        double res = val;
        while (power > 1) {
            res *= val;
            pow(res, --power);
        }
        return res;
    }
}
