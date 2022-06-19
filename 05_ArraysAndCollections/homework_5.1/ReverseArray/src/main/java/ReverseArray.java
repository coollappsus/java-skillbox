import java.util.Arrays;

public class ReverseArray {

    //TODO: Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    public static String[] reverse (String[] strings){
        int lenght = strings.length;
        String temp;
        for (int i = 0; i < lenght / 2; i++) {
            temp = strings[lenght - i - 1];
            strings[lenght - i - 1] = strings[i];
            strings[i] = temp;
        }
        return strings;
    }
}
