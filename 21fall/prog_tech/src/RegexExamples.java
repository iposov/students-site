public class RegexExamples {

    public static void main(String[] args) {
        System.out.println("abc".matches("abc"));
        System.out.println("abc".matches("abc|xyz|pqr"));
        System.out.println("pqr".matches("abc|xyz|pqr"));
        System.out.println("123".matches("abc|xyz|pqr"));
        String time = "((0|1)\\d|20|21|22):(0|1|2|3|4|5)\\d";
        System.out.println("21:34".matches(time));
    }

}
