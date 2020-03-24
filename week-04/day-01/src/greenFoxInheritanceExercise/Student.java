package greenFoxInheritanceExercise;

import jdk.internal.HotSpotIntrinsicCandidate;

public class Student extends Person implements Cloneable {
    private String previousOrganization;
    private int skippedDays;

    public Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }

    public Student () {
        super("Jane Doe", 30, "female");
        this.previousOrganization = "The School of Life";
        this.skippedDays = 0;
    }

    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    public  void introduce() {
        System.out.println("Hi, I'm " + super.getName() + ", a " + super.getAge() + " year old " + super.getGender() +
                " from " + previousOrganization + " who skipped " + skippedDays + " from the course already.");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }



    @Override
    public Object clone()throws CloneNotSupportedException{
        return (Student) super.clone();
    }

//    protected Student clone() {
//        return new Student();
//    }



}
