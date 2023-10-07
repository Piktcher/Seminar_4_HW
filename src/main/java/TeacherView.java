import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;

public class TeacherView {

    public TeacherView() {
    }

    public void ViewApp () {
        TeacherController controller = new TeacherController(new TeacherStorage(), new TeacherService());

        while (true) {
            System.out.println("Введите цифру от 1 до 4, где 1 - добавление учителя, 2 - редактирование учителя, 3 - удаление учителя, 4 - выход из программы: ");
            Scanner i = new Scanner(System.in);
            String action = i.next();

            if (Objects.equals(action, "1")) {
                controller.addTeacher();
                continue;
            }

            if (Objects.equals(action, "2")) {
                controller.modifyTeacher();
                continue;
            }

            if (Objects.equals(action, "3")) {
                controller.removeTeacher();
                continue;
            }

            if (Objects.equals(action, "4")) {
                exit(0);
            }

        }
    }
}
