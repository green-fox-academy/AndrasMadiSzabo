public class CodingHours {
    public static void main(String[] args) {
        // An average Green Fox attendee codes 6 hours daily
        // The semester is 17 weeks long
        //
        // Print how many hours is spent with coding in a semester by an attendee,
        // if the attendee only codes on workdays.
        float coding = 17 * 5 * 6;
        System.out.println("The attendee codes " + coding + " hours");
        //
        // Print the percentage of the coding hours in the semester if the average
        // work hours weekly is 52
        float percentage1 = (float) (17 * 5 * 6 / 17.00 / 52.00 * 100);
        float percentage2 = (float) 17 * 5 * 6 / (17 * 52) * 100;
        System.out.println("The percentage of coding " + percentage1 + " percent");
        System.out.println("The percentage of coding " + percentage2 + " percent");

        int c = 12;
        //orint number plus one no change value
        System.out.println(c+1);
        //changes value after printing
        System.out.println(c++);
        //changes value before printing
        System.out.println(++c);
        System.out.println(c);
    }
}
