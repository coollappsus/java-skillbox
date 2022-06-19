public class Main {

  public static void main(String[] args) {

    String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
    char space = ' ';

    int indexVasya = text.indexOf("л ");
    int indexSpaceVasya = text.indexOf(space, indexVasya + 2);
    String vasya = text.substring(indexVasya + 1, indexSpaceVasya);

    int indexPetya = text.indexOf("- ");
    int indexSpacePetya = text.indexOf(space, indexPetya + 2);
    String petya = text.substring(indexPetya + 1, indexSpacePetya);

    int indexMasha = text.lastIndexOf("- ");
    int indexSpaceMasha = text.indexOf(space, indexMasha + 2);
    String masha = text.substring(indexMasha + 1, indexSpaceMasha);

    int number = Integer.parseInt(vasya.trim()) + Integer.parseInt(petya.trim()) + Integer.parseInt(masha.trim());

    System.out.println(number);
  }
}