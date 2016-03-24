import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by Alexander on 2016-03-23.
 */
public class SeasonsDeserializer implements JsonDeserializer<Season> {

    @Override
    public Season deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final int season = jsonObject.get("season_number").getAsInt();
        final int noEpisodes = jsonObject.get("episode_count").getAsInt();
        final String airDate = jsonObject.get("air_date").getAsString();

        if(season != 0) {
            final Season seasons = new Season();
            seasons.setSeason(season);
            seasons.setNOEpisodes(noEpisodes);
            seasons.setAirDate(airDate);
            return seasons;
        }
        return null;
    }


}
