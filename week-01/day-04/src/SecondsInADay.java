public class SecondsInADay {
    public static void main(String[] args) {
        int currentHours = 14;
        int currentMinutes = 34;
        int currentSeconds = 42;

        // Write a program that prints the remaining seconds (as an integer) from a
        // day if the current time is represented by the variables

        int totalSeconds = currentSeconds + 60*currentMinutes + 60*60*currentHours;
        int daySeconds = 60*60*24;
        System.out.println("Remaining seconds are " + (daySeconds - totalSeconds));
    }
}
