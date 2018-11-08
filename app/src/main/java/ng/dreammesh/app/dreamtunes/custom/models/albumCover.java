package ng.dreammesh.app.dreamtunes.custom.models;

public class albumCover {

    private String name;  //name of song
    private int imageResourceId;
    private String artist;


    public albumCover(String name, int imageResourceId, String artist) {
        this.name = name;
        this.imageResourceId = imageResourceId;
        this.artist = artist;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
