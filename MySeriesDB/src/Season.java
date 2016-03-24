/**
 * Created by Alexander on 2016-03-23.
 */
public class Season {
    private int season;
    private String airDate;
    private int noEpisodes;
    private Episode[] episodes;

    public void setSeason(int season){
        this.season = season;
    }

    public void setAirDate(String airDate){
        this.airDate = airDate;
    }

    public void setNOEpisodes(int noEpisodes){
        this.noEpisodes = noEpisodes;
    }

    public void setEpisodes(Episode[] episodes){
        this.episodes = episodes;
    }
}
