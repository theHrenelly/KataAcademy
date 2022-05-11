package errorsExceptionsDebug.task4_1_7;

/*
Создайте новое проверяемое исключение MyNewException, и создайте метод testExp(), который выбрасывает MyNewException при вызове.

Требования:
1. Метод testExp() должен быть публичным и иметь тип возвращаемого значения void.
2. Класс исключения должен иметь модификатор доступа по умолчанию.
3. Метод testExp() расположите вне класса исключения.
 */

public class Solution {
    public static void main(String[] args) {

    }

    public void testExp() throws MyNewException {
        throw new MyNewException();

    }

    public class MyNewException extends Exception {

    }
}
