import java.util.*;

public class PhoneBook {
    TreeMap<String, TreeSet<String>> name2number = new TreeMap<>();
    TreeSet<String> phoneBook = new TreeSet<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (isValidNameAndPhone(name, phone)) {
            if (phoneBook.contains(phone)) {
                name2number.remove(name2number.ceilingKey(phone));
            }
            if (name2number.containsKey(name)) {
                name2number.get(name).add(phone);
            }else {
                name2number.put(name, new TreeSet<>());
                name2number.get(name).add(phone);
            }
            phoneBook.add(phone);
            System.out.println("Контакт сохранён!");
        } else {
            System.out.println("Неверный формат ввода телефона. Телефон должен быть в формате 79002005040");
        }
    }

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        TreeSet<String> phoneBook = new TreeSet<>();
        for (Map.Entry<String, TreeSet<String>> entry : name2number.entrySet()) {
            String[] stringInPhoneBook = entry.getValue().toString().replaceAll("[^0-9, ]", "").split("[, ]");
            phoneBook.addAll(Arrays.asList(stringInPhoneBook));
        }
        if (phoneBook.contains(phone)) {
            return name2number.ceilingKey(phone) + " - " +
                    name2number.get(name2number.ceilingKey(phone)).toString().replaceAll("[^0-9, ]", "");
        }
        return "";
    }

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet<String> phoneBook = new TreeSet<>();
        if (name2number.containsKey(name)) {
                String stringInPhoneBook = name2number.ceilingKey(name) + " - " +
                        name2number.get(name2number.ceilingKey(name)).toString().replaceAll("[^0-9, ]", "");
                phoneBook.add(stringInPhoneBook);
        }
        return phoneBook;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet<String> phoneBook = new TreeSet<>();
        for (Map.Entry<String, TreeSet<String>> entry : name2number.entrySet()) {
            String stringInPhoneBook = entry.getKey() + " - " +
                    entry.getValue().toString().replaceAll("[^0-9, ]", "");
            phoneBook.add(stringInPhoneBook);
        }
        return phoneBook;
    }

    public boolean isValidNameAndPhone(String name, String phone) {
        if (name.isEmpty() || phone.isEmpty()) {
            return false;
        }
        String checkName = name.replaceAll("\\D", "");
        String checkPhone = phone.replaceAll("[\\d]{11}", "");
        return checkName.isEmpty() && checkPhone.isEmpty();
    }
}