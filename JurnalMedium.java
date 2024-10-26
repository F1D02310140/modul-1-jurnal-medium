public class JurnalMedium {
    public static void main(String[] args) {
        DoubleLinkedList Heroes = new DoubleLinkedList();
        Node Jotaro = new Node("Jotaro Kujo", "Star Platinum", "Time Stop", 'A', 'A', 'C', 8.5);
        Node Josuke = new Node("Josuke Higashikata", "Crazy Diamond", "Restoration", 'A', 'A', 'D', 8.0);
        Node Shigechi = new Node("Shigechi", "Harvest", "Collecting", 'E', 'B', 'A', 6.5);
        Node Giorno = new Node("Giorno Giovanna", "Gold Experience", "Life Giver", 'C', 'A', 'C', 7.0);
        Node Jolyne = new Node("Jolyne Cujoh", "Stone Free", "String Decomposition", 'A', 'B', 'C', 8.0);

        System.out.println("-------------------HEROES--------------------");
        Heroes.add(Jotaro);
        Heroes.add(Josuke);
        Heroes.add(Shigechi);
        Heroes.add(Giorno);
        Heroes.add(Jolyne);
        Heroes.scan();

        DoubleLinkedList Villains = new DoubleLinkedList();
        Node Kenny = new Node("Kenny G", "Tenore Sax", "Illusions", 'E', 'E', 'D', 2.5);
        Node Dio = new Node("Dio", "The World", "Time Stop", 'A', 'A', 'C', 8.5);
        Node Yoshikage = new Node("Yoshikage Kira", "Killer Queen", "Bomb Transmutation", 'A', 'B', 'D', 7.0);
        Node Diavolo = new Node("Diavolo Vinegar Dopp", "King Crimson", "Time Erasure", 'A', 'A', 'E', 7.0);
        Node Pucci = new Node("Pucci", "Whitesnake", "Disc Extraction", 'A', 'D', 'A', 8.0);

        System.out.println("-------------------VILLAINS--------------------");
        Villains.add(Kenny);
        Villains.add(Dio);
        Villains.add(Yoshikage);
        Villains.add(Diavolo);
        Villains.add(Pucci);
        Villains.scan();

        DoubleLinkedList Animals = new DoubleLinkedList();
        Node Iggy = new Node("Iggy", "The Fool", "Shapeshifting", 'C', 'B', 'D', 6.0);
        Node BugEaten = new Node("Bug-Eaten", "Ratt", "Melting Darts", 'C', 'C', 'A', 7.0);
        Node PetShop = new Node("Pet Shop", "Horus", "Cryokinesis", 'B', 'B', 'D', 6.5);

        System.out.println("-------------------ANIMALS--------------------");
        Animals.add(Iggy);
        Animals.add(BugEaten);
        Animals.add(PetShop);
        Animals.scan();

        System.out.println("--------AFTER BATTLE: DELETING CHARACTERS--------");
        System.out.println("Shigechi terkena ledakan dari Yoshikage Kira...");
        Heroes.delete("Shigechi");

        System.out.println("Dio membunuh Kenny G...");
        Villains.delete("Kenny G");

        System.out.println("Iggy mengalahkan Pet Shop...");
        Animals.delete("Pet Shop");

        System.out.println("--------HEROES YANG MASIH HIDUP--------");
        Heroes.scan();

        System.out.println("--------VILLAINS YANG MASIH HIDUP--------");
        Villains.scan();

        System.out.println("--------ANIMALS YANG MASIH HIDUP--------");
        Animals.scan();

        DoubleLinkedList merged = Villains;
        merged.merged(Animals);
        System.out.println("-------------------MERGED VILLAINS & ANIMALS--------------------");
        merged.scan();

        DoubleLinkedList mergedFinal = merged;
        mergedFinal.merged(Heroes);
        System.out.println("-------------------MERGED FINAL (ALL CHARACTERS)--------------------");
        mergedFinal.scan();

        Node Emporio = new Node("Emporio Alnino", "Weather Report", "Oxygen Manipulation", 'B', 'B', 'C', 7.0);
        Node pucciNode = mergedFinal.findNodeByName("Pucci"); // Mencari node Pucci
        if (pucciNode != null) {
            mergedFinal.insertDataBefore(Emporio, pucciNode); // Menyisipkan Emporio sebelum Pucci
        }

        mergedFinal.delete("Pucci");

        System.out.println("-------------------DAFTAR KARAKTER TERBARU--------------------");
        mergedFinal.scan();

        System.out.println("Swapping Dio and Iggy...");
        mergedFinal.swapCharacter("Dio", "Iggy");

        System.out.println("Swapping Jotaro and Jolyne...");
        mergedFinal.swapCharacter("Jotaro Kujo", "Jolyne Cujoh");

        System.out.println("-------------------DAFTAR KARAKTER TERBARU SETELAH PERTUKARAN--------------------");
        mergedFinal.scan();
    }
}