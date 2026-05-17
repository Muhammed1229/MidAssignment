package mediaitems;
import mediahub.Media;

public class Video extends Media {
    private String vidtitle;
    private int durationinmins;

    public Video (String vidtitle, int durationinmins) {
    super (vidtitle);
    this.vidtitle = vidtitle;
    this.durationinmins = durationinmins;
    }  
    
    public String getVidtitle() {
        return vidtitle;
    }

    public void setVidtitle(String vidtitle) {
        if (vidtitle != null) {
            this.vidtitle = vidtitle;
        } 
    }
    public int getDurationinmins() {
        return durationinmins;
    }

    public void setDurationinmins(int durationinmins) {
        if (durationinmins >= 0) {
        this.durationinmins = durationinmins;
        }
    }

    @Override
    public void play () {
        IO.println ("Adjusting video resolution...");
    }

    public static void hubrules () {
        IO.println ("Please do not scratch the disc!");
    }
}

class Book extends Media {
    private String booktitle;
    private int pages;
    
    public Book (String booktitle, int pages) {
        this.booktitle = booktitle;
        this.pages = pages;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        if (booktitle != null) {
        this.booktitle = booktitle;
        }
    }    

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages > 0) {
        this.pages = pages;
        }
    }

   @Override
    public void play () {
        IO.println ("Searching for Book...");
    }

    public void author () {
        IO.println ("Book Author: " + title);
    }

    public static void location () {
        IO.println ("Location: Aisle 8, Bookshelf 3");
    }
}

class Animeshows extends Video {
    private boolean iscannon;
    public Animeshows (String title, int durationinmins, boolean iscannon){
       super (title , durationinmins);
       this.iscannon = iscannon;
    }
    public boolean isIscannon() {
        return iscannon;
    }

    public void setIscannon(boolean iscannon) {
        this.iscannon = iscannon;
    }
}
final class Thrillershows extends Video {
    private int rating;
    public Thrillershows (String title, int durationinmins, int rating) {
        super (title, durationinmins);
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating >= 1 && rating <= 10) {
            this.rating = rating;
        } 
    }
}