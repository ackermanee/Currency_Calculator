
/*
# Практического задание java
## Задание
Необходимо разработать калькулятор валют, работающий из консоли.

__Функционал__
- Калькулятор должен уметь работать с двумя валютами — доллар и рубль — и позволять
выполнять операции сложения и вычитания.
- Складывать и вычитать можно только значения в одной валюте.
- Должна быть реализована операция конвертации из одной валюты в другую по курсу,
который задается во внешнем файле конфигурации
- Необходимо реализовать поддержку не только целых, но и дробных значений.

__Замечания__
- Значение в долларах обозначается символом $, расположенным перед числом (например, $57,75).
- Значение в рублях — символом “р”, расположенным после числа (например, 57,75р).
- Операция конвертации долларов в рубли — toRubles($57,75), рублей в доллары — toDollars(57,75р).
- Разделитель целой и дробной части может быть любым на выбор разработчика.

__Пример консольного ввода__
toDollars(737р + toRubles($85,4)).
Для данного ввода вывод должен быть
(при курсе 60 рублей за доллар, например): 5861р
* */

import java.util.Scanner;

public class Main {

    public static double toRubles(double dollar) {
        dollar=dollar*60.0;
        System.out.println("toDollars("+dollar+")");
        return dollar;
    }
    public static double toDollars(double ruble) {
        ruble= ruble * 0.015;
        System.out.println("toRubles("+ruble+")");
        return ruble;
    }
    public static double sum(double num1, double num2){
        return num1+num2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner in = new Scanner(System.in);

        System.out.println("Введите первую сумму");
        double num1=in.nextDouble();
        System.out.println("Выберите валюту: " +
                "доллары (0) " +
                "рубли (1)");
        int sign1=in.nextInt();

        if(sign1 == 0){
            System.out.println("Первая сумма: $"+num1);
        }else if (sign1== 1) {
            System.out.println("Первая сумма: "+num1+"р");
        }
        System.out.println("Введите вторую сумму");
        double num2=in.nextDouble();
        System.out.println("Выберите валюту: " +
                "доллары (0) " +
                "рубли (1)");
        int sign2=in.nextInt();

        if(sign2 == 0){
            System.out.println("Вторая сумма: $"+num2);
        }else if (sign2== 1) {
            System.out.println("Вторая сумма: "+num2+"р");
        }
        System.out.println("Веберите валюту операции");
        char znak = scanner.next().charAt(0);

        switch (znak){
            case '$':
                if(sign2==1) {
                    num2=toDollars(num2);
                }
                if (sign1==1){
                    num1=toDollars(num1);
                }
                break;

            case 'p':
                if (sign1==0) {
                    num1=toRubles(num1);
                }
                if(sign2==0){
                    num2=toRubles(num2);
                }

                break;
            default:
                System.out.println("Не корректно введены данные");
        }
        System.out.println("Веберите операцию (+/-)");
        char operation = scanner.next().charAt(0);
            switch (operation){
                case '+':
                    System.out.println("Результат: " + sum(num1, num2) );
                    break;
                case '-':
                    System.out.println("Результат: " + (num1-num2));
                    break;
                default:
                    System.out.println("Не корректно введены данные");
            }
    }
}
