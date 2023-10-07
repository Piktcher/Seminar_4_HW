public class TeacherService{

    public TeacherService() {
    }
    public boolean validateTeacher(Teacher teacher){
        if (teacher.getName().length() < 2) {
            System.out.println("Имя введено некорректно, введите заново!");
            return false;
        } else if (teacher.getSurname().length() < 2) {
            System.out.println("Фамилия введена некорректно, введите заново!");
            return false;
        }
        return true;
    }
}
