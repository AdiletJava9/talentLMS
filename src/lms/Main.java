package lms;

import lms.classes.Admin;

import lms.classes.Group;
import lms.classes.Lesson;
import lms.classes.Student;
import lms.methods.impl.Portal;

import java.time.LocalTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        LocalTime localTime = LocalTime.now();
        if (localTime.isBefore(LocalTime.of(9, 0))) {
            System.out.println("Доброе утро!!");
        } else if (localTime.isBefore(LocalTime.of(19, 0))) {
            System.out.println("Добрый день!!");
        } else if (localTime.isBefore(LocalTime.of(22, 0))) {
            System.out.println("Добрый вечер!!");
        } else {

            System.out.println("НОЧЬ");
        }
        System.out.println("ВРЕМЯ-->" + localTime.getHour() + ":" + localTime.getMinute());

        while (true) {
            try {
                Admin admin = new Admin();
                Scanner scanner = new Scanner(System.in);
                System.out.println("ВАШ ЛОГИН/gmail?");
                if (scanner.nextLine().equalsIgnoreCase(admin.getGmail())) {
                    System.out.println("ВАШ ПАРОЛЬ/password?");
                    if (scanner.nextLine().equalsIgnoreCase(admin.getPassword())) {
                        method();
                    } else {
                        throw new Ex("ERROR PASSWORD OR GMAIL");
                    }
                } else {
                    throw new Ex("ERROR PASSWORD OR GMAIL");
                }
            } catch (Ex ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void method() {
        try {
            List<Group> groups = new ArrayList<>();
            List<Student> students = new ArrayList<>();
            List<Lesson> lessons = new ArrayList<>();
            while (true) {
                System.out.println(" 1  -> Add new group\n" +
                        " 2  -> Get group by name\n" +
                        " 3  -> Update group name\n" +
                        " 4  -> Get all groups\n" +
                        " 5  -> Add new student to group\n" +
                        " 6  -> Update student\n" +
                        " 7  -> Find student by first name\n" +
                        " 8  -> Get all students by group name\n" +
                        " 9  -> Get all student's lesson\n" +
                        " 10 -> Delete student\n" +
                        " 11 -> Add new lesson to group\n" +
                        " 12 -> Get lesson by name\n" +
                        " 13 -> Get all lesson by group name\n" +
                        " 14 -> Delete lesson\n" +
                        " 15 -> Delete group");
                Portal portal = new Portal();
                Scanner scanner1 = new Scanner(System.in);
                int s = scanner1.nextInt();
                switch (s) {
                    case 1 -> portal.addGroup(groups);
                    case 2 -> portal.groupByName(groups);
                    case 3 -> portal.updateGroupName(groups);
                    case 4 -> portal.getAllGroups(groups);
                    case 5 -> portal.addNewStudentToGroup(groups);
                    case 6 -> portal.updateStudent(groups);
                    case 7 -> portal.findStudentByFirstname(groups);
                    case 8 -> portal.getAllStudentsByGroupNam(groups);
                    case 9 -> portal.getAllStudentsLesson(groups);
                    case 10 -> portal.deleteStudent(groups);
                    case 11 -> portal.addNewLessonToGroup(groups);
                    case 12 -> portal.getLessonByName(groups);
                    case 13 -> portal.getAllLessonByGroupName(groups);
                    case 14 -> portal.deleteLesson(groups);
                    case 15 -> portal.deleteGroup(groups);

                }
            }
        } catch (InputMismatchException inputMismatchException) {
            System.out.println("ONLY NUMBERS!!!");
        }
    }
}