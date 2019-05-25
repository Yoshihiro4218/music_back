package music.music.form;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;

public class MusicCreateForm {


//    @Size(min = 1, max = 127)
    private String music_name;
    private String artist_name;
    private String album_name;


    public void setMusicName(String music_name) {
        this.music_name = music_name;
    }

    public String getMusicName() {
        return music_name;
    }

    public void setArtistName(String artist_name) {
        this.artist_name = artist_name;
    }

    public String getArtistName() {
        return artist_name;
    }

    public void setAlbumName(String album_name) {
        this.album_name = album_name;
    }

    public String getAlbumName() {
        return album_name;
    }
}
