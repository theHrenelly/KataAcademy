package Generics_Collections.task7_1_8;

/*
TODO Создайте функциональный интерфейс NumberGenerator, параметризованный таким образом,
     что принимает только наследников класса Number, имеющий метод boolean cond(T arg).
     Создайте в методе public static NumberGenerator<? super Number> getGenerator() с помощью лямбда выражения
     реализацию NumberGenerator, которая возвращает true, если число в int эквиваленте больше 0.

Требования:
1. Должен быть метод public static NumberGenerator<? super Number> getGenerator()
2. Соблюдайте код стайл при параметризации.
3. Имя параметра должно быть "Т"
4. Метод должен возвращать корректную реализацию*/

public interface NumberGenerator<T extends Number> {

    boolean cond(T arg);
}

class test {
    public static void main(String[] args) {
        NumberGenerator<? super Number> numGen = getGenerator();
        System.out.println(numGen.cond(123456L));
        System.out.println(numGen.cond(123456.56));
        System.out.println(numGen.cond(132));
        System.out.println(numGen.cond(Byte.MAX_VALUE));
        System.out.println(numGen.cond(-5.5));
        System.out.println(numGen.cond(-1253523525L));
        System.out.println(numGen.cond(0));
        System.out.println(numGen.cond(-2));
        System.out.println(numGen.cond(Byte.MIN_VALUE));
    }

    public static NumberGenerator<? super Number> getGenerator() {
        return x -> x.intValue() > 0;
    }
}




