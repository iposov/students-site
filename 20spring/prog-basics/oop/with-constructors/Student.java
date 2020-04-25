public class Student {
    String name = "без имени";
    int yearOfBirth;
    int yearOfStudy = 1;

    // новый конструктор без аргументов
    Student() {
        System.out.println("Меня создали");
    }

    Student(String name, int yearOfBirth, int yearOfStudy) {
        System.out.println("Меня создали");
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.yearOfStudy = yearOfStudy;
    }

    void sayHello() {
        System.out.println(
                "Добрый вечер, меня зовут " +
                        this.name +  // про this читайте ниже
                        ", я учусь на " +
                        this.yearOfStudy +
                        " курсе."
        );
    }

    boolean isAdult() {
        return 2020 - yearOfBirth >= 18;
    }
}
