/**
 * Created by Alexander on 2016-03-23.
 */
public class Episode {
    private String name;
    private String airDate;
    private int season;
    private int episode;
    private String plot;
    private double rating;
    private byte[] poster;

    public void setName(String name){
        this.name = name;
    }

    public void setAirDate(String airDate){
        this.airDate = airDate;
    }

    public void setSeason(int season){
        this.season = season;
    }

    public void setEpisode(int episode){
        this.episode = episode;
    }

    public void setPlot(String plot){
        this.plot = plot;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    public void setPoster(byte[] poster){
        this.poster = poster;
    }
}
