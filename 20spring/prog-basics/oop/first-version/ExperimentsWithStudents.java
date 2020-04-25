public class ExperimentsWithStudents {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = s1;

        s1.name = "Ilya";
        s1.yearOfBirth = 1910;
        s1.yearOfStudy = 1;

        s2.name = "Olya";
        s2.yearOfBirth = 1912;
        s2.yearOfStudy = 2;

        System.out.println("Имя первого студента: " + s1.name);

        s1.sayHello();
        s2.sayHello();
        s3.sayHello();

        if (s1.isAdult())
            System.out.println("студент " + s1.name + " совершеннолетний");
    }
}
