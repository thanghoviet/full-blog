package model;

import java.util.Date;

public class User {
    private int id;
    private String email;
    private String password;
    private String fullName;
    private String alias;
    private boolean role;
    private String aboutMe;
    private String image;
    private Date createDate;
    private int yearOfBirth;

    public User (){}

    public User(int id) {
        this.id = id;
    }

    public User(int id, String email, String fullName, String alias, String aboutMe, String image, int yearOfBirth) {
        this.id = id;
        this.email = email;
        this.fullName = fullName;
        this.alias = alias;
        this.aboutMe = aboutMe;
        this.image = image;
        this.yearOfBirth = yearOfBirth;
    }

    public User(String email, String password, String fullName, String alias, boolean role, String aboutMe, String image, int yearOfBirth) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.alias = alias;
        this.role = role;
        this.aboutMe = aboutMe;
        this.image = image;
        this.yearOfBirth = yearOfBirth;
    }


    public User(int id, String alias) {
        this.id = id;
        this.alias = alias;
    }

    public User(int id, String email, String password, String fullName, String alias, boolean role, String aboutMe, String image, Date createDate, int yearOfBirth) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.alias = alias;
        this.role = role;
        this.aboutMe = aboutMe;
        this.image = image;
        this.createDate = createDate;
        this.yearOfBirth = yearOfBirth;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public boolean getRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                ", alias='" + alias + '\'' +
                ", role=" + role +
                ", aboutMe='" + aboutMe + '\'' +
                ", image='" + image + '\'' +
                ", createDate=" + createDate +
                ", yearOfBirth=" + yearOfBirth +
                '}';
    }
}
