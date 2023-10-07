import java.util.Scanner;

public class TeacherController {

    private final TeacherStorage storage;
    private final TeacherService validator;

    public TeacherController(TeacherStorage storage, TeacherService validator) {
        this.storage = storage;
        this.validator = validator;
    }

    public void addTeacher() {

        System.out.println("Введите фамилию учителя: ");
        Scanner n = new Scanner(System.in);
        String surname = n.next();

        System.out.println("Введите имя учителя: ");
        String name = n.next();

        System.out.println("Введите отчество учителя: ");
        String patronymic = n.next();

        int id = storage.getTeachers().size() + 1;

        Teacher teacher = new Teacher(id, name, surname, patronymic);
        if (!validator.validateTeacher(teacher)) { return; }

        storage.add(teacher);
        System.out.println(storage);

    }

    public void modifyTeacher() {

        System.out.println(storage.toString());
        System.out.println("Введите id учителя для редактирования: ");
        Scanner n = new Scanner(System.in);
        int id = Integer.parseInt(n.next());

        for (Teacher l: storage.getTeachers()) {
            if (l.getId() == id) {
                System.out.println("Введите измененную фамилию: ");
                String surname = n.next();

                System.out.println("Введите измененное имя: ");
                String name = n.next();

                System.out.println("Введите измененное отчество: ");
                String patronymic = n.next();

                Teacher teacher = new Teacher(id, name, surname, patronymic);
                if (!validator.validateTeacher(teacher)) { return; }

                storage.update(teacher);
                System.out.println(storage);
                return;
            }
        }
        System.out.println("Учитель с таким id не найден, повторите операцию!");
    }

    public void removeTeacher() {
        System.out.println(storage.toString());
        System.out.println("Введите id учителя для удаления: ");
        Scanner n = new Scanner(System.in);
        int id = Integer.parseInt(n.next());

        for (Teacher l: storage.getTeachers()) {
            if (l.getId() == id) {
                storage.remove(l);
                System.out.println(storage);
                return;
            }
        }
        System.out.println("Учитель с таким id не найден, повторите операцию!");
    }

}
