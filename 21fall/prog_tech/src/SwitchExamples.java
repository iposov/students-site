public class SwitchExamples {

    public static void main(String[] args) {
        //Примеры использования оператора switch
        //Выбор одного из нескольких вариантов действий,
        //похож на if, но там логическое выражение, выбор
        //в зависимости от того, true или false

        //старая версия switch с : и с break
        int x = 42;
        switch (x) {
            case 13:
                System.out.println("Плохое число");
                break;
            case 42:
                System.out.println("Хорошее число");
                break;
            case 239:
                System.out.println("Тоже число");
                break;
            default:
                System.out.println("Обычное число");
        }

        //Новый switch, с ->, без break
        x = 239;
        switch (x) {
            case 13 -> System.out.println("Плохое число");
            case 42 -> System.out.println("Хорошее число");
            case 239 -> {
                System.out.println("Это же 239");
                System.out.println("Тоже число");
            }
            //default не обязательный
            default -> System.out.println("Обычное число");
        }
        //после стрелки фигурные скобки. Если действие одно,
        //можно без них

        // Switch как выражение
        String message = switch (x) {
            case 13 -> "Плохое число";
            case 42 -> "Хорошее число";
            case 239 -> {
                System.out.println("Это же 239 !!!");
                yield "Тоже число"; //похоже на return,
                //указываем результат switch для x=239
            }
            //(!) default обязательный, чтобы всегда
            //был какой-то результат вычислений
            default -> "Обычное число";
        };

        System.out.println(message);
    }

}
