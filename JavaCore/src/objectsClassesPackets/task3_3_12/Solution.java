package objectsClassesPackets.task3_3_12;

/*Создайте класс Human с полями возраст (age), имя (name), фамилия (secondName) и любимый вид спорта (favoriteSport).

        Создайте 3 конструктора в классе Human, 1-ый - пустой, 2-ой, который конструирует Human’a от всех полей и третий, который конструирует Human’a,
        от всех полей, кроме любимого вида спорта. Для успешного тестирования решения важно объявлять аргументы в конструкторах именно в том порядке,
        в котором они написаны в данном описании (возраст (age), имя (name), фамилия (secondName) и любимый вид спорта (favoriteSport))

        В методе main создайте 3 экземпляра человека используя 3 этих разных конструктора. поля класса должны иметь размерность,не превышающую необходимую.
        Класс должен быть объявлен статическим, метод main не должен находиться в классе, поля класса должны иметь доступ только внутри класса

        Требования:
        1. Должен быть метод public static void main(String[] args)
        2. Должен быть public static class Human
3. У класс Human должны быть поля
        4. Класс Human должен иметь 3 конструктора
        5. В методе main нужно создать три объекта класса Human тремя способами*/

public class Solution {
    public static void main(String[] args) {
        Human human1 = new Human();
        Human human2 = new Human((byte) 18, "Dmitrii", "Akimov", "Trial");
        Human human3 = new Human((byte) 18, "Asya", "Akimova");
    }


    public static class Human {
        private byte age;
        private String name;
        private String secondName;
        private String favoriteSport;

        public Human() {

        }

        public Human(byte age, String name, String secondName, String favoriteSport) {
            this(age, name, secondName);
            this.favoriteSport = favoriteSport;
        }

        public Human(byte age, String name, String secondName) {
            this.age = age;
            this.name = name;
            this.secondName = secondName;
        }
    }
}
