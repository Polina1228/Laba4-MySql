package sample;

import java.io.Serializable;

public class Student implements Serializable {

    private int Id;
    private String Surname;
    private String Name;
    private String MiddleName;
    private int Age;
    private String AverageGrade;

    public Student(int Id, String Surname, String Name,
                   String MiddleName, int Age, String AverageGrade) {
        this.Id = Id;
        this.Surname = Surname;
        this.Name = Name;
        this.MiddleName = MiddleName;
        this.Age = Age;
        this.AverageGrade = AverageGrade;
    }

    @Override
    public String toString() {
        return "Id: " + Id + ", Surname: " + Surname + ", " +
                "Name: " + Name + ", MiddleName: " + MiddleName +
                ", Age: " + Age + ", AverageGrade: " + AverageGrade;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String Surname) {
        this.Surname = Surname;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public String getAverageGrade() {
        return AverageGrade;
    }

    public void setAverageGrade(String AverageGrade) {
        this.AverageGrade = AverageGrade;
    }
}
