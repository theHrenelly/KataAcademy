package objectsClassesPackets.task3_3_11;

public class Solution {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.catchCat(new Cat());

    }


    public static class Cat {

        public void sayHello() {
            System.out.printf("%1$stepik test! \n", "Мяу");
        }
    }

    public static class Dog {

        public void sayHello() {
            System.out.printf("%1$stepik test! \n", "Гав");
        }

        public void catchCat(Cat cat) {
            System.out.printf("%1$stepik test \n", "Кошка поймана");
            sayHello();
            cat.sayHello();
        }
    }
}

