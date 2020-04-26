public class Person {
    private String name;
    private int yearOfBirth;

    public Person(String name, int yearOfBirth) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }

    // метод вычисления возраста
    public int getAge() {
        return 2020 - yearOfBirth;
    }

    // метод, чтобы поздороваться
    public void sayHello() {
        System.out.printf(
                "Здравствуйте, меня зовут %s, мне %d лет.\n",
                name,
                getAge()
        );
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public boolean isAdult() {
        return getAge() >= 18;
    }
}
