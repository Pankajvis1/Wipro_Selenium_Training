package Keywords;

public class this_Keyword {

    static class Animal {

        String food;
        String sound;

        Animal(String food, String sound) {
            this.food = food;
            this.sound = sound;

            System.out.println("Eat = " + this.food);
            System.out.println("Sound = " + this.sound);
        }
    }

    static class Dog extends Animal {

        String color;

        Dog(String food, String sound, String color) {
            super(food, sound);
            this.color = color;

            System.out.println("Dog Color = " + this.color);
        }
    }

    static class Cat extends Animal {

        String walkStyle;

        Cat(String food, String sound, String walkStyle) {
            super(food, sound);
            this.walkStyle = walkStyle;

            System.out.println("Walk = " + this.walkStyle);
        }
    }

    public static void main(String[] args) {

        Dog d = new Dog("Royal Canin", "Barking", "Black");

        System.out.println();

        Cat c = new Cat("Fish", "Meow", "Cat Walk");
    }
}