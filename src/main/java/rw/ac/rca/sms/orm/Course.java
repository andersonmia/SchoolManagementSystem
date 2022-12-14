package rw.ac.rca.sms.orm;

import javax.persistence.*;

@Entity
@Table(name = "course")

public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;
    private int period;
    private double maxMark;

    public Course() {

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course( String name, int period, double maxMark) {
        this.name = name;
        this.period = period;
        this.maxMark = maxMark;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setMaxMark(double maxMark) {
        this.maxMark = maxMark;
    }


    public String getName() {
        return name;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public int getPeriod() {
        return period;
    }

    public double getMaxMark() {
        return maxMark;
    }

}