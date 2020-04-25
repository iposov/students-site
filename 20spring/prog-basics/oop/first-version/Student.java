public class Student {
    String name;     //имя
    int yearOfBirth; //год рождения
    int yearOfStudy; //первый курс, второй, третий и т.п.

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
