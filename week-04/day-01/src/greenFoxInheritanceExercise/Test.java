package greenFoxInheritanceExercise;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList<Person> people = new ArrayList<>();

        Person mark = new Person("Mark", 46, "male");
        people.add(mark);
        Person jane = new Person();
        people.add(jane);
        Student john = new Student("John Doe", 20, "male", "BME");
        people.add(john);
        Student student = new Student();
        people.add(student);
        Mentor gandhi = new Mentor("Gandhi", 148, "male", "senior");
        people.add(gandhi);
        Mentor mentor = new Mentor();
        people.add(mentor);
        Sponsor sponsor = new Sponsor();
        people.add(sponsor);
        Sponsor elon = new Sponsor("Elon Musk", 46, "male", "SpaceX");
        people.add(elon);

        student.skipDays(3);

        for (int i = 0; i < 5; i++) {
            elon.hire();
        }

        for (int i = 0; i < 3; i++) {
            sponsor.hire();
        }

        for(Person person : people) {
            person.introduce();
            person.getGoal();
        }

        Cohort awesome = new Cohort("AWESOME");
        awesome.addStudent(student);
        awesome.addStudent(john);
        awesome.addMentor(mentor);
        awesome.addMentor(gandhi);
        awesome.info();



        Student student1 = new Student("John",20, "male", "BME");
      //  student1.introduce();
        try {
            Student johnTheClone = (Student) student1.clone();
            johnTheClone.name = "JohnTheClone";
            johnTheClone.skipDays(5);
            johnTheClone.introduce();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        Gnirts gnirts = new Gnirts("this example");
        System.out.println("gnirts length = " + gnirts.length());
        System.out.println("gnirts char at index 2 = " + gnirts.charAt(2));
        System.out.println("gnirts char subSequence 2-8 = " + gnirts.subSequence(2,7));
        System.out.println("gnirts chars = " + gnirts.chars());
        System.out.println("gnirts code points = " + gnirts.codePoints());



    }


}
