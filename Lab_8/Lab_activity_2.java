import java.util.LinkedList;
import java.util.Scanner;

public class MusicPlaylist {  // <-- This is the MAIN CLASS
    public static void main(String[] args) {
        LinkedList<String> playlist = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== MUSIC PLAYLIST MENU ===");
            System.out.println("1. Add Song at Beginning");
            System.out.println("2. Add Song at End");
            System.out.println("3. Remove First Song");
            System.out.println("4. Remove Last Song");
            System.out.println("5. Replace Song at Specific Index");
            System.out.println("6. Display Playlist");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter song title to add at the beginning: ");
                    String firstSong = sc.nextLine();
                    playlist.addFirst(firstSong);
                    System.out.println("Song added at the beginning!");
                    displayPlaylist(playlist);
                    break;

                case 2:
                    System.out.print("Enter song title to add at the end: ");
                    String lastSong = sc.nextLine();
                    playlist.addLast(lastSong);
                    System.out.println("Song added at the end!");
                    displayPlaylist(playlist);
                    break;

                case 3:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeFirst());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    displayPlaylist(playlist);
                    break;

                case 4:
                    if (!playlist.isEmpty()) {
                        System.out.println("Removed: " + playlist.removeLast());
                    } else {
                        System.out.println("Playlist is empty!");
                    }
                    displayPlaylist(playlist);
                    break;

                case 5:
                    if (playlist.isEmpty()) {
                        System.out.println("Playlist is empty!");
                    } else {
                        System.out.print("Enter index to replace (0 - " + (playlist.size() - 1) + "): ");
                        int index = sc.nextInt();
                        sc.nextLine();
                        if (index >= 0 && index < playlist.size()) {
                            System.out.print("Enter new song title: ");
                            String newSong = sc.nextLine();
                            playlist.set(index, newSong);
                            System.out.println("Song replaced successfully!");
                        } else {
                            System.out.println("Invalid index!");
                        }
                    }
                    displayPlaylist(playlist);
                    break;

                case 6:
                    displayPlaylist(playlist);
                    break;

                case 0:
                    System.out.println("Exiting Music Playlist Program...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 0);

        sc.close();
    }

    // Method to display all songs in the playlist
    private static void displayPlaylist(LinkedList<String> playlist) {
        System.out.println("\n--- CURRENT PLAYLIST ---");
        if (playlist.isEmpty()) {
            System.out.println("[No songs in playlist]");
        } else {
            for (int i = 0; i < playlist.size(); i++) {
                System.out.println(i + ": " + playlist.get(i));
            }
        }
    }
}
