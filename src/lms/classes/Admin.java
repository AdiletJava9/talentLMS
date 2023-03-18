package lms.classes;

public class Admin {
    private String gmail = "Islambekovich@gmail.com";
    private String password = "adi2001";

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin: " +
                "gmail " + gmail + '\n' +
                "password " + password + '\n';
    }
}
