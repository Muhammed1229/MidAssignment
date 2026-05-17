package mediaitems;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import mediahub.Media;

public class Main {
    public static void main (String [] args) {
        ArrayList<Media> hub = new ArrayList<>();
        Scanner scanner = new Scanner (System.in);
        Video vid1 = new Video ("Oceans 11", 100);
        Animeshows anime1 = new Animeshows ("Naruto ", 20 , false);
        Thrillershows thriller1 = new Thrillershows ("From", 50, 9);
        Book book1 = new Book ("Peace and War", 500);
        hub.add (vid1);
        hub.add (anime1);
        hub.add (thriller1);
        hub.add (book1);
        boolean run = true;

        for (int i = 1; i <= 50; i++) {
            IO.println(""); 
        }
        IO.println("=== MediaHub System Initialized ===");

        while (run) {
            IO.println ("\n--- MediaHub Menu ---");
            IO.println ("1. Open MediaHub");
            IO.println ("2. Add your own Media to the Hub");
            IO.println ("3. Play all Media");
            IO.println ("4. Exit");
            IO.print ("Select option: ");

            try {
                int option = scanner.nextInt();
                scanner.nextLine();
                
                if (option == 1) {
                    IO.println ("\n --- Media Menu ---");
                    IO.println ("1.1. View Video Hub");
                    IO.println ("1.2. View TV Shows Hub");
                    IO.println ("1.3. View Book Hub");
                    IO.print ("Select Option: ");

                    double mediafile = scanner.nextDouble();
                    scanner.nextLine();

                    if (mediafile == 1.1) {
                        IO.println ("Searching for Video..."); 
                        vid1.play ();
                        IO.println ("Title: " + vid1.getVidtitle() + ", Duration: " + vid1.getDurationinmins() + " minutes.");
                        Media.hubrules ();
                        Video.hubrules ();
                    } 
                    
                    else if (mediafile == 1.2) {
                        IO.println ("Streaming Shows...");
                        IO.println ("Anime Title: " + anime1.getVidtitle() + ", Duration: " + anime1.getDurationinmins() + " minutes, " + "Cannon Only: " + anime1.isIscannon());
                        IO.println ("Thriller Title: " + thriller1.getVidtitle() + ", Duration: " + thriller1.getDurationinmins() + " minutes, Rating: " + thriller1.getRating() + "/10");
                    }

                    else if (mediafile == 1.3) {              
                        Media media1 = book1;
                        book1.play();
                        IO.println ("Title: " + book1.getBooktitle() + ", Pages: " + book1.getPages());
                        book1.author (); 
                        media1.location();
                        book1.location();
                    } 

                    else {
                    IO.println ("Invalid Input! Please Choose ONLY From The Given Options.");
                    }    

                } else if (option == 2) {
                    IO.println ("\n --- Adding New Media Menu ---");
                    IO.println ("2.1. Add Video ");
                    IO.println ("2.2. Add TV Show ");
                    IO.println ("2.3. Add Book ");
                    IO.print ("Select Option: ");

                    double addmedia = scanner.nextDouble();
                    scanner.nextLine();

                    if (addmedia == 2.1) {
                        IO.println ("Enter Video Title: ");
                            String tit = scanner.nextLine();
                        IO.println ("Enter Duration In Minutes: ");
                            int dur = scanner.nextInt();
                        hub.add(new Video(tit, dur));
                            IO.println("Added Video Successfully.");
                    } 
                    else if (addmedia == 2.2) {
                        IO.println ("\n --- Adding New TV Show Menu ---");
                        IO.println ("A. Add Anime ");
                        IO.println ("B. Add Thriller ");
                        IO.print ("Select Option: ");

                        String addshow = scanner.next();
                        scanner.nextLine();

                        if ("A".equals(addshow) || "a".equals(addshow)) {
                            IO.println ("Enter Anime Title: ");
                                String ti = scanner.nextLine ();
                            IO.println ("Enter Duration In Minutes: ");
                                int du = scanner.nextInt();
                            IO.println ("Is it Cannon (true/false)");
                                boolean cannon = scanner.nextBoolean();
                            hub.add(new Animeshows(ti, du, cannon));
                                IO.println("Added Anime Successfully.");
                        }

                        else if ("B".equals(addshow) || "b".equals(addshow)) {
                            IO.println ("Enter Thriller Title: ");
                                String titl = scanner.nextLine();
                            IO.println ("Enter Duration In Minutes: ");
                                int dura = scanner.nextInt();
                            IO.println ("Enter Rating Out of 10");
                                int ratin = scanner.nextInt();
                            if (ratin >= 1 && ratin <=10) {
                                hub.add(new Thrillershows(titl, dura, ratin));
                                IO.println("Added Thriller Successfully.");
                            } 
                            else {
                                IO.println("Invalid rating! Please enter a value between 1 and 10.");
                            }
                        }

                        else {
                        IO.println ("Invalid Input! Please Choose ONLY From The Given Options.");
                        } 
                    }

                    else if (addmedia == 2.3) {
                        IO.println ("Enter Book Title: ");
                            String t = scanner.nextLine();
                        IO.println ("Enter Page Number: ");
                            int page = scanner.nextInt();
                        hub.add(new Book(t, page));
                            IO.println("Added Book Successfully.");
                    }

                    else {
                    IO.println ("Invalid Input! Please Choose ONLY From The Given Options.");
                    } 
                } 
                else if (option == 3) {
                    IO.println("--- Playing All Hub Items ---");
                    int itemno = 1;
                    for (Media item : hub) {
                        
                        IO.print(itemno + ". ");

                        if (item instanceof Animeshows) {
                            Animeshows anime2 = (Animeshows) item;
                            IO.println ("Anime Title: " + anime2.getVidtitle() + ", Duration: " + anime2.getDurationinmins() + " mins, Canon Only: " + anime2.isIscannon());
                        }

                        else if (item instanceof Thrillershows) {
                            Thrillershows thriller2 = (Thrillershows) item;
                            IO.println ("Thriller Title: " + thriller2.getVidtitle() + ", Duration: " + thriller2.getDurationinmins() + " mins, Rating: " + thriller2.getRating() + "/10");
                        }

                        else if (item instanceof Video) {
                                Video video2 = (Video) item;
                                IO.println ("Video Title: " + video2.getVidtitle() + ", Duration: " + video2.getDurationinmins() + " mins");
                        }

                        else if (item instanceof Book) {
                            Book book2 = (Book) item; 
                            IO.println ("BooK Title: " + book2.getBooktitle() + ", Pages: " + book2.getPages()); 
                        }
                        itemno += 1;
                    }    
                } 

                else if (option == 4) {
                    run = false;
                } 

                else {
                    IO.println ("Invalid Input! Please Choose ONLY From The Given Options.");
                }  

            } catch (InputMismatchException e) {
                IO.println("Error: Please Enter a valid Menu Option.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }
}