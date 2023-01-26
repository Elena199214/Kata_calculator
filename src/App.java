import java.util.*;

public class App {

    static String input;
    public static void main(String[] args) throws ChekExeption {

        System.out.println("Добро пожаловать в калькулятор, введите выражение");
        try (Scanner scanner = new Scanner(System.in)) {

            String input = scanner.nextLine();
            System.out.println(calc(input));
        }
    }

     static String calc(String input) throws ChekExeption {
        int number1;
        int number2;
        int result;
        Converter converter = new Converter();
        //оставляю только возможные операторы
        String operator = input.replaceAll("[^+\\-*/]", "");
        input.trim();

        String[] str = input.split("[+\\-*/]");
        if(str.length!=2||operator.length()!=1){
            throw new ChekExeption("Ошибка: формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        //Определяем, находятся ли числа в одном формате (оба римские или оба арабские)
        if (converter.isRoman(str[0]) == converter.isRoman(str[1])) {
            //Определяем, римские ли это числа
            boolean isRoman = converter.isRoman(str[0]);
            if (isRoman) {
                //если римские, то конвертируем их в арабские
                number1 = converter.toArabian(str[0]);
                number2 = converter.toArabian(str[1]);

            } else {
                //если арабские, конвертируем их из строки в число
                number1 = Integer.parseInt(str[0]);
                number2 = Integer.parseInt(str[1]);
            }
            char operatorChar = operator.charAt(0);

            if (number1 > 10 ||number1 < 0 || number2 > 10 ||number2 < 0) {
                throw new ChekExeption("Ошибка: калькулятор принимает на вход числа от 1 до 10 включительно");
            }

            result = switch (operatorChar) {
                case ('+') -> number1 + number2;
                case ('-') -> number1 - number2;
                case ('/') -> number1 / number2;
                case ('*') -> number1 * number2;
                default -> throw new ChekExeption("Ошибка: строка не является математической операцией");
            };
            if (isRoman) {
                if (result<1){
                    throw new ChekExeption("Ошибка: Результатом работы калькулятора с римскими числами могут быть только положительные числа");
                }
                return converter.toRoman(result);
            }

            return Integer.toString(result);
        } else {
            throw new ChekExeption("Ошибка: Вы ввели числа в разном формате");
        }
    }
}







