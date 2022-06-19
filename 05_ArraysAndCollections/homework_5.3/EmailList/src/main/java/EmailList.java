import java.util.*;

public class EmailList {
    TreeSet<String> emailList = new TreeSet<>();
    ArrayList<String> sortEmailList = new ArrayList<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется
        if (isValid(email)) {
            emailList.add(email.toLowerCase());
        }else {
            System.out.println(Main.WRONG_EMAIL_ANSWER);
        }
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается список электронных адресов в алфавитном порядке
        sortEmailList.addAll(emailList);
        for (int i = 0; i < sortEmailList.size(); i++) {
            System.out.println(sortEmailList.get(i));
        }
        return sortEmailList;
    }

    public boolean isValid(String email) {
        String checkEmail = email.replaceAll(".+@.+\\..+", "");
        return checkEmail.isEmpty();
    }

}
