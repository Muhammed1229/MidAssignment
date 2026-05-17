package mediahub;

public abstract class Media {
    protected String title = "Leo Tolstoy";
    private int releaseyr;

    public Media () {
        IO.println ("Searching for Book...");
    }

    public Media (String title) {
        this.title = title;
    }  

    public Media (int releaseyr) {
        this.releaseyr = releaseyr;
    }
    public int getReleaseyr() {
        return releaseyr;
    }
    public void setReleaseyr(int releaseyr) {
        if (releaseyr >= 0) {
            this.releaseyr = releaseyr;
        }
    }   

    public abstract void play ();

    public final void copyrightnotice () {
        IO.println ("2026 MediaHub Corp. All rights reserved.");
    }

    public static void hubrules () {
        IO.println("Return item within 30 days, or you will be charged a fine!");
    }

    public static void location () {
        IO.println ("Location: Archives");
    }
}