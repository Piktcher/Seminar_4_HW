import java.util.ArrayList;
import java.util.List;

public class TeacherStorage {

    private final List<Teacher> teachers;

    public TeacherStorage() {
        this.teachers = new ArrayList<>();
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void add (Teacher teacher) {
        teachers.add(teacher);
    }

    public void update (Teacher teacher) {
        for (Teacher l: teachers) {
            if (l.getId() == teacher.getId()) {
                l.setName(teacher.getName());
                l.setSurname(teacher.getSurname());
                l.setPatronymic(teacher.getPatronymic());
                break;
            }
        }
    }

    public void remove (Teacher teacher) {
        for (Teacher l: teachers) {
            if (l.getId() == teacher.getId()) {
                teachers.remove(l);
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder teacher = new StringBuilder();
        for (Teacher l: teachers) {
            teacher.append(l.getId()).append(" ").append(l.getSurname()).append(" ").append(l.getName()).append(" ").append(l.getPatronymic()).append("\n");
        }
        return teacher.toString();
    }
}
