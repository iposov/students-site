public class Person {

    // статическая часть

    public static final String SPECIES_NAME = "Homo Sapiens";
    private static int count;

    public static int getCount() {
        return count; // либо Person.count, но лучше сократить
    }

    // нестатическая часть

    private String name;
    private int yearOfBirth;

    public Person(String name, int yearOfBirth) {
        count += 1; // подсчет количества созданных объектов

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
