package lms.methods.impl;

import lms.Ex;
import lms.classes.Group;
import lms.classes.Lesson;
import lms.classes.Student;
import lms.methods.Interface;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Portal implements Interface {
    private static long count;
    ArrayList<Group> groups1 = new ArrayList<>();
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Lesson> lessons = new ArrayList<>();

    @Override
    public void addGroup(List<Group> groups) {
        try {
            count++;
            List<Student> students = new ArrayList<>();
            List<Lesson> lessons = new ArrayList<>();
            Group group = new Group(lessons, students);
            Scanner scanner = new Scanner(System.in);
            group.setId(count);
            System.out.println("НАЗВАНИЕ ГРУППЫ");
            String name = scanner.nextLine();
            group.setName(name);
            for (Group g : groups) {
                if (name.equalsIgnoreCase(g.getName())) {
                    throw new Ex("УЖЕ ЕСТЬ ТАКАЯ ГРУППА");
                }
            }
            System.out.println("OПИСАНИЕ?");
            String description = scanner.nextLine();
            group.setDescription(description);
            groups.add(group);
            System.out.println("ГРУПППА СОЗДАНО+\n" + groups.toString());

        } catch (Ex e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void groupByName(List<Group> groups) {
        try {
            System.out.println("ВВЕДИТЕ НАЗВАНИЕ ГРУППЫ КОТОРУЮ ХОТЕЛИ ИСКАТЬ");
            String s = new Scanner(System.in).nextLine();
            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(s)) {
                    groups1.add(g);
                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1) {
                    System.out.println(g);
                }
            } else {
                throw new Ex("НЕТ ТАКОЙ ГРУППЫ!!!");
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void updateGroupName(List<Group> groups) {
        try {
            System.out.println("ВВЕДИТЕ НАЗВАНИЕ ГРУППЫ КОТОРУЮ ХОТЕЛИ ИЗМЕНИТЬ");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.nextLine();
            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(name)) {
                    groups1.add(g);
                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1) {
                    System.out.println("ГРУППА НАЙДЕНО\n" +
                            "ВВЕДИТЕ НОВОЕ НАЗВАНИЕ ГРУППЫ");
                    g.setName(scanner.nextLine());
                    System.out.println(" УСПЕШНО ИЗМЕНЕН:\n" + g);
                }

            } else {
                throw new Ex("НЕТ ТАКОЙ ГРУППЫ!!!");
            }

        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getAllGroups(List<Group> groups) {
        for (Group g : groups) {
            System.out.println(g);
        }
    }

    @Override
    public void addNewStudentToGroup(List<Group> groups) {
        count++;
        try {
            System.out.println("ВВЕДИТЕ НАЗВАНИЕ ГРУППЫ КОТОРУЮ ХОТЕЛИ ДОБАВИТЬ СТУДЕНТА");
            String s = new Scanner(System.in).nextLine();
            for (Group g : groups) {
                if (g.getName().equals(s)) {
                    groups1.add(g);
                }
            }
            if (!groups1.isEmpty()) {
                for (Group g : groups1) {
                    System.out.println("ГРУППА НАЙДЕНО!" + g.toString());
                    Student student = new Student();
                    System.out.println("Name student?");
                    student.setId(count);
                    String name = new Scanner(System.in).nextLine();
                    student.setFullName(name);
                    System.out.println("Age?");
                    int age = new Scanner(System.in).nextInt();
                    if (age > 16) {
                        student.setAge(age);
                    } else {
                        throw new Ex("ДЛА ВАС ЕШЕ РАНО");
                    }
                    System.out.println("Email?");
                    String email = new Scanner(System.in).nextLine();
                    if (email.contains("@")) {
                        student.setEmail(email);
                    } else {
                        throw new Ex("У ЛОГИНА ДОЛЖНО БЫТЬ {@} ");
                    }
                    System.out.println("Password?");
                    String password = new Scanner(System.in).nextLine();
                    if (password.length() >= 7) {
                        student.setPassword(password);
                    } else {
                        throw new Ex("ПАРОЛЬ ДОЛЖЕН БЫТЬ НЕ МЕНЕЕ 7 СИМВОЛОВ");
                    }
                    g.getStudent().add(student);
                    System.out.println("УСПЕШНО ДОБАВЛЕНО");
                    System.out.println(g.toString());
                }
            } else {
                throw new Ex("НЕТ ТАКОЙ ГРУППЫ");
            }


        } catch (InputMismatchException inputMismatchException) {
            System.out.println("AGE ONLY NUMBERS");
        } catch (Ex e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void updateStudent(List<Group> groups) {
        try {
            System.out.println("ВВЕДИТЕ ПОЛНУЮУ ИМЯ СТУДЕНТА КОТОРУЮ ХОТЕЛИ ИЗМЕНИТТЬ");
            Scanner scanner = new Scanner(System.in);
            for (Group s : groups) {
                for (Student g : s.getStudent()) {
                    if (scanner.nextLine().equals(g.getFullName())) {
                        System.out.println("ЕСТЬ ТАКОЙ СТУДЕНТ ");
                        System.out.println("ВВЕДИТЕ НОВОЕ ИМЯ ДЛЯ СТУДЕНТА ");
                        g.setFullName(scanner.nextLine());
                        System.out.println("УСПЕШНО ИЗМЕНЕН+\n" + g);
                    } else {
                        throw new Ex("НЕТ ТАКОГО СТУДЕНТА");
                    }
                }
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void findStudentByFirstname(List<Group> groups) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("ВВЕДИТЕ ИМЯ СТУДЕНТА КОТОРУЮ ХОТЕЛИ ИСКАТЬ");
            for (Group g : groups) {
                for (Student s : g.getStudent()) {
                    if (s.getFullName().equalsIgnoreCase(scanner.nextLine())) {
                        System.out.println(g.getStudent());
                    } else {
                        throw new Ex("НЕТ ТАКОГО СТУДЕНТА");
                    }
                }
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void getAllStudentsByGroupNam(List<Group> groups) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ВВЕДИТЕ НАЗАНИЕ ГРУППЫ ЧТО БЫ УВИДЕТЬ СТУДЕНТОВ ");
            for (Group g : groups) {
                if (scanner.nextLine().equalsIgnoreCase(g.getName())) {
                    System.out.println(g.getStudent().toString());
                } else {
                    throw new Ex("НЕТ ТАКОЙ ГРУППЫ");
                }
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void getAllStudentsLesson(List<Group> groups) {
        System.out.println("ВВЕДИТЕ ЛОГИН  СТУДЕНТА ЧТОБЫ УВИДЕТЬ УРОКОВ ");
        String name = new Scanner(System.in).nextLine();
        for (Group g : groups) {
            for (Student s : g.getStudent()) {
                if (name.equalsIgnoreCase(s.getEmail())) {
                    System.out.println(g.getLesson().toString());
                }
            }
        }
    }

    @Override
    public void deleteStudent(List<Group> groups) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("ВВЕДИТЕ ИМЯ СТУДЕНТА КОТОРУЮ ХОТЕЛИ УДАЛИТЬ");
            for (Group g : groups) {
                for (Student s : g.getStudent()) {
                    if (s.getFullName().equalsIgnoreCase(scanner.nextLine())) {
                        g.getStudent().remove(s);
                        System.out.println(" УСПЕШНО  УДАЛЕНО");
                        break;
                    } else {
                        throw new Ex("НЕТ ТАКОГО СТУДЕНТА");
                    }
                }
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void addNewLessonToGroup(List<Group> groups) {
        System.out.println("ВВЕДИТЕ НАЗВАНИЕ ГРУППЫ КОТОРУЮ ХОТЕЛИ ДОБАВИТЬ УРОКА");
        String nameGroup = new Scanner(System.in).nextLine();
        Lesson lesson = new Lesson();
        for (Group g : groups) {
            if (g.getName().equalsIgnoreCase(nameGroup)) {
                System.out.println("ГРУППА НАЙДЕНО" + g);
                System.out.println("НАЗВАНИЕ УРОКА?");
                String nameLesson = new Scanner(System.in).nextLine();
                lesson.setName(nameLesson);
                g.getLesson().add(lesson);
                System.out.println("УСПЕШНО ДОБАВЛЕНО" + g);
            }
        }
    }

    @Override
    public void getLessonByName(List<Group> groups) {
        try {
            System.out.println("ВВЕДИТЕ НАЗВАНИЕ УРОКА КОТОРУЮ ХОТЕЛИ ИСКАТЬ");
            String nameLesson = new Scanner(System.in).nextLine();
            for (Group g : groups) {
                for (Lesson l : g.getLesson()) {
                    if (nameLesson.equalsIgnoreCase(l.getName())) {
                        System.out.println("УРОК НАЙДЕН");
                        System.out.println(l);
                    } else {
                        throw new Ex("НЕТ ТАКОГО УРОКА");
                    }
                }
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }

    }

    @Override
    public void getAllLessonByGroupName(List<Group> groups) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("ВВЕДИТЕ НАЗАНИЕ ГРУППЫ ЧТО БЫ УВИДЕТЬ УРОКОВ  ");
            for (Group g : groups) {
                if (scanner.nextLine().equalsIgnoreCase(g.getName())) {
                    System.out.println(g.getLesson().toString());
                } else {
                    throw new Ex("НЕТ ТАКОГО УРОКА");
                }
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void deleteLesson(List<Group> groups) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("ВВЕДИТЕ НАЗВАНИЕ УРОКА КОТОРУЮ ХОТЕЛИ УДАЛИТЬ");
        for (Group g : groups) {
            for (Lesson s : g.getLesson()) {
                if (s.getName().equalsIgnoreCase(scanner.nextLine())) {
                    groups1.add(g);
                }
            }
        }
        for (Group g : groups1) {
            for (Student s : g.getStudent()) {
                g.getStudent().remove(s);
                System.out.println(" УСПЕШНО  УДАЛЕНО");
                break;
            }

        }
    }

    @Override
    public void deleteGroup(List<Group> groups) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("ВВЕДИТЕ НАЗВАНИЕ ГРУППЫ  КОТОРУЮ ХОТЕЛИ УДАЛИТЬ");
            String name = scanner.nextLine();
            long id = 0;
            for (Group g : groups) {
                if (g.getName().equalsIgnoreCase(name)) {
                    id = g.getId();
                }
            }
            boolean isTrue = true;
            for (int i = 0; i < groups.size(); i++) {
                if (groups.get(i).getId() == id) {
                    isTrue = true;
                    groups.remove(groups.get(i));
                    System.out.println("УСПЕШНО УДАЛЕНО");
                } else {
                    isTrue = false;
                }
            }
            if (!isTrue) {
                throw new Ex("НЕТ ТАКОЙ ГРУППЫ");
            }
        } catch (Ex ex) {
            System.out.println(ex.getMessage());
        }
    }
}
