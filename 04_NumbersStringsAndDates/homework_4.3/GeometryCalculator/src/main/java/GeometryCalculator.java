public class GeometryCalculator {
    // метод должен использовать абсолютное значение radius
    public static double getCircleSquare(double radius) {
        double circleSquare = Math.PI * Math.pow(radius, 2);
        return circleSquare;
    }

    // метод должен использовать абсолютное значение radius
    public static double getSphereVolume(double radius) {
        double sphereVolume = Math.abs((4 * Math.PI * Math.pow(radius, 3)) / 3);
        return sphereVolume;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if (a > b && a > c) {
            if (b + c > a) {
                return true;
            }
        }
        if (b > a && b > c) {
            if (a + c > b) {
                return true;
            }
        }
        if (c > a && c > b) {
            if (a + b > c) {
                return true;
            }
        }
        return false;
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if(isTrianglePossible(a,b,c)) {
            double p = (a + b + c) / 2;
            double triangleSquare = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return triangleSquare;
        }
        return -1;
    }
}
