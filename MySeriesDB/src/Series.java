/**
 * Created by Alexander on 2016-03-23.
 */
public class Series {

    private String name;
    private String firstAirDate;
    private String lastAirDate;
    private int noSeasons;
    private int noEpisodes;
    private String plot;
    private double rating;
    private Season[] seasons;

    private byte[] poster;

    public void setName(String name){
        this.name = name;
    }

    public void setFirstAirDate(String firstAirDate){
        this.firstAirDate = firstAirDate;
    }

    public void setLastAirDate(String lastAirDate){
        this.lastAirDate = lastAirDate;
    }

    public void setNOSeasons(int noSeasons){
        this.noSeasons = noSeasons;
    }

    public void setNOEpisodes(int noEpisodes){
        this.noEpisodes = noEpisodes;
    }

    public void setPlot(String plot){
        this.plot = plot;
    }

    public void setRating(double rating){
        this.rating = rating;
    }

    public void setSeasons(Season[] seasons){
        this.seasons = seasons;
    }

    public Season getSeason(int index){
        return seasons[index];
    }

    public void setPoster(byte[] poster){
        this.poster = poster;
    }

}

