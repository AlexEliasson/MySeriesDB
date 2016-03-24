import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by Alexander on 2016-03-23.
 */
public class EpisodesDeserializer implements JsonDeserializer<Episode>{

    @Override
    public Episode deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();
        final String name = jsonObject.get("name").getAsString();
        final int season = jsonObject.get("season_number").getAsInt();
        final int episode = jsonObject.get("episode_number").getAsInt();
        final String airDate = jsonObject.get("air_date").getAsString();
        final String plot = jsonObject.get("overview").getAsString();
        final double rating = jsonObject.get("vote_average").getAsDouble();

        final Episode episodes = new Episode();
        episodes.setName(name);
        episodes.setSeason(season);
        episodes.setEpisode(episode);
        episodes.setAirDate(airDate);
        episodes.setPlot(plot);
        episodes.setRating(rating);
        return episodes;
    }
}
