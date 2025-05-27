public class AnimalDemo {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Dog dog = new Dog();
        
        System.out.println("Animal sound:");
        animal.makeSound();
        
        System.out.println("\nDog sound:");
        dog.makeSound();
    }
}

class Animal {
    public void makeSound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Bark");
    }
} 