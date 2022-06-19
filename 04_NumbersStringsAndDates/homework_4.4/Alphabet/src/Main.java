public class Main {

    public static void main(String[] args) {
        String string = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char letter = 'A';

        for(char i = 'A'; i < 'Z'; i++) {
            int symbol = (int) i;
            System.out.println(letter++ + " - " + symbol);
        }
    }
}
