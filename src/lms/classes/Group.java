package lms.classes;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private long id;
    private String name;
    private String description;
    private List<Lesson> lesson;
    private List<Student> students;

    public Group() {
    }

    public Group(List<Lesson> lesson, List<Student> students) {
        this.lesson = lesson;
        this.students = students;
    }

    public Group(long id, String name, String description, ArrayList<Lesson> lesson, ArrayList<Student> students) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lesson = lesson;
        this.students = students;
    }

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        } else {
            students.add(student);
        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(ArrayList<Lesson> lesson) {
        this.lesson = lesson;
    }

    public List<Student> getStudent() {
        return students;
    }

    public void setStudent(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return  "Group:" +
                " id=" + id +
                " name=" + name +
                " description=" + description +"\n" +
                "lesson=" + lesson +"\n"+
                "students=" + students;
    }
}
