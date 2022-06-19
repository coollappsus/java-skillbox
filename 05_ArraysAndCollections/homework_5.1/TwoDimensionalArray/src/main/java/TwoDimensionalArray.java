public class TwoDimensionalArray {
    public static char symbol = 'X';

    public static char[][] getTwoDimensionalArray(int size) {
        char[][] krest = new char[size][size];

        for (int i = 0; i < krest.length; i++) {
            for (int j = 0; j < krest[0].length; j++) {
                if (j == i || j == krest.length - 1 - i) {
                    krest[i][j] = symbol;
                } else {
                    krest[i][j] = ' ';
                }
            }
        }

        //TODO: Написать метод, который создаст двумерный массив char заданного размера.
        // массив должен содержать символ symbol по диагоналям, пример для size = 3
        // [X,  , X]
        // [ , X,  ]
        // [X,  , X]

        return krest;
    }
}
