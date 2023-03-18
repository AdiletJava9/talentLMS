package lms.classes;

public class Student {
    private long id;
    private String fullName;
    private int age;
    private String email;
    private String password;

    public Student() {
    }

    public Student(long id, String fullName, int age, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Student:" +
                "id=" + id +
                "fullName=" + fullName +
                "age=" + age +
                "email=" + email +
                "password=" + password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
