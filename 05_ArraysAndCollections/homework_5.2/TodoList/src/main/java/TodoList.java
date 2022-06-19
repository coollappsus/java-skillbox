import java.util.ArrayList;

public class TodoList {
    ArrayList<String> todoList = new ArrayList<>();;

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
        System.out.println("Добавлено дело \"" + todo + "\"");
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index > todoList.size() || index < 0) {
            add(todo);
        }else {
            todoList.add(index, todo);
            System.out.println("Добавлено дело \"" + todo + "\"");
        }
    }

    public void edit(String todo, int index) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index < todoList.size() && index >= 0) {
            System.out.println("Дело \"" + todoList.get(index) + "\" заменено на \"" + todo + "\"");
            todoList.set(index, todo);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index < todoList.size() && index >= 0) {
            System.out.println("Дело \"" + todoList.get(index) + "\" удалено");
            todoList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + " - " + todoList.get(i));
        }
        return todoList;
    }

}