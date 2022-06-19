import java.util.HashMap;
import java.util.Map;

public class CustomerStorage {
    private final Map<String, Customer> storage;

    public CustomerStorage() {
        storage = new HashMap<>();
    }

    public void addCustomer(String data) {
        final int INDEX_NAME = 0;
        final int INDEX_SURNAME = 1;
        final int INDEX_EMAIL = 2;
        final int INDEX_PHONE = 3;

        String[] components = data.split("\\s+");
        if(components.length != 4) {
            throw new IllegalArgumentException("Введён неверный формат команды. Формат правильной команды:\n" +
                    "add Василий Петров vasily.petrov@gmail.com +79215637722");
        }
        if(!isValidPhone(components[INDEX_PHONE])){
            throw new IllegalArgumentException("Введён неверный формат телефона. Формат ввода телефона: +79215637722");
        }
        if (!isValidEmail(components[INDEX_EMAIL])) {
            throw new IllegalArgumentException("Введён неверный формат email");
        }
        String name = components[INDEX_NAME] + " " + components[INDEX_SURNAME];
        storage.put(name, new Customer(name, components[INDEX_PHONE], components[INDEX_EMAIL]));
    }

    public void listCustomers() {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name) {
        storage.remove(name);
    }

    public Customer getCustomer(String name) {
        return storage.get(name);
    }

    public int getCount() {
        return storage.size();
    }

    public boolean isValidPhone(String phone) {
        if (phone.isEmpty()) {
            return false;
        }
        String checkPhone = phone.replaceAll("[+\\d]{12}", "");
        return checkPhone.isEmpty();
    }

    public boolean isValidEmail(String email) {
        if (email.isEmpty()) {
            return false;
        }
        String checkEmail = email.replaceAll(".+@.+\\..+", "");
        return checkEmail.isEmpty();
    }
}