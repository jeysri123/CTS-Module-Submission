public class MusicDemo {
    public static void main(String[] args) {
        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        
        System.out.println("Guitar:");
        guitar.play();
        
        System.out.println("\nPiano:");
        piano.play();
    }
}

interface Playable {
    void play();
}

class Guitar implements Playable {
    @Override
    public void play() {
        System.out.println("Playing guitar: Strumming strings");
    }
}

class Piano implements Playable {
    @Override
    public void play() {
        System.out.println("Playing piano: Pressing keys");
    }
} 