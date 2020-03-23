package greenFoxInheritanceExercise;

public class Mentor extends Person {
    private String level;

    public Mentor(String name, int age, String gender, String level) {
        super(name, age, gender);
        this.level = level;
    }

    public Mentor () {
        super("Jane Doe", 30, "female");
        level = "intermediate";
    }

    public void getGoal() {
        System.out.println("Educate brilliant junior software developers.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + super.getName() + ", a " + super.getAge() + " year old " + super.getGender() +
                " " + level + "  mentor.");
    }



}
