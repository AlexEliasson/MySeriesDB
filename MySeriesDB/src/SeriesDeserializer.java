import com.google.gson.*;

import java.lang.reflect.Type;

/**
 * Created by Alexander on 2016-03-23.
 */
public class SeriesDeserializer implements JsonDeserializer<Series> {

    @Override
    public Series deserialize(final JsonElement json, final Type typeOfT, final JsonDeserializationContext context) throws JsonParseException {

        final JsonObject jsonObject = json.getAsJsonObject();

        final String name = jsonObject.get("name").getAsString();
        final String firstAirDate = jsonObject.get("first_air_date").getAsString();
        final String lastAirDate = jsonObject.get("last_air_date").getAsString();
        final int noSeasons = jsonObject.get("number_of_seasons").getAsInt();
        final int noEpisodes = jsonObject.get("number_of_episodes").getAsInt();
        final String plot = jsonObject.get("overview").getAsString();
        final double rating = jsonObject.get("vote_average").getAsDouble();
        Season[] seasons = context.deserialize(jsonObject.get("seasons"), Season[].class);

        final Series series = new Series();
        series.setName(name);
        series.setFirstAirDate(firstAirDate);
        series.setLastAirDate(lastAirDate);
        series.setNOSeasons(noSeasons);
        series.setNOEpisodes(noEpisodes);
        series.setPlot(plot);
        series.setRating(rating);
        series.setSeasons(seasons);
        return series;
    }

}
