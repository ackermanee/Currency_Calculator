import java.util.Scanner;

public class Calculator {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        double num1 = getDouble();
        double num2 = getDouble();
        char operation = getOperation();
        double result = calc(num1,num2,operation,getValute());

        System.out.println("Результат операции: "+result);
    }

    public static double getDouble(){
        System.out.println("Введите сумму:");
        double num;
        if(scanner.hasNextInt()){
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе суммы. Попробуйте еще раз.");
            scanner.next();//рекурсия
            num = getDouble();
        }
        System.out.println("Введите в какой валюте будет сумма");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return num;

    }


    public static char getValute(){
        System.out.println("Введите в какой валюте хотите получить результат:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }
    public static char getOperation(){
        System.out.println("Введите операцию:");
        char operation;
        if(scanner.hasNext()){
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Вы допустили ошибку при вводе операции. Попробуйте еще раз.");
            scanner.next();//рекурсия
            operation = getOperation();
        }
        return operation;
    }

    public static double calc(double num1, double num2, char operation, char valute) {
        double result;

        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation(), getValute());//рекурсия
        }
        switch (valute) {
            case '$':
                result = result *  68.71;
                break;
            case 'р':
                result = result * 0.015;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                return result;
        }
        return result;
    }
}