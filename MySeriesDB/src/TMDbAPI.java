
import com.google.gson.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.Set;

/**
 * Created by Alexander on 2016-03-22.
 */
public class TMDbAPI {
    private final String API_KEY;
    private final String URL_BASE = "http://api.themoviedb.org/3";
    private final String URL_SERIES = "/tv/{id}";
    private final String URL_SEASONS = "/season/{season_number}";
    private final String URL_EPISODES = "/episode/{episode_number}";
    private final String URL_API = "?api_key=";
    private final String URL_IMAGE = "https://image.tmdb.org/t/p/original";

    public TMDbAPI(String api_key){
        this.API_KEY = api_key;
    }

    public String getResponse(int id){
        String seriesID = URL_SERIES.replace("{id}", String.valueOf(id));
        String URL_series = URL_BASE + seriesID + URL_API + API_KEY;
        BufferedReader reader = null;
        try {
            URL url = new URL(URL_series);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return "";
    }

    public String getResponse(int id, int season){
        String seriesID = URL_SERIES.replace("{id}", String.valueOf(id));
        String seasonID = URL_SEASONS.replace("{season_number}", String.valueOf(season));
        String URL_series = URL_BASE + seriesID + seasonID + URL_API + API_KEY;
        BufferedReader reader = null;
        try {
            URL url = new URL(URL_series);
            reader = new BufferedReader(new InputStreamReader(url.openStream()));

            StringBuffer buffer = new StringBuffer();
            int read;
            char[] chars = new char[1024];
            while ((read = reader.read(chars)) != -1)
                buffer.append(chars, 0, read);

            return buffer.toString();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                }
                catch(Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
        return "";
    }

    public String getValue(String jsonObj, String key){
        String value = "";
        Gson gsonObject = new Gson();
        JsonObject jsonObject = gsonObject.fromJson(jsonObj, JsonObject.class);
        try {
            value = jsonObject.get(key).toString();
            System.out.println(value);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return value;
    }

    public String getValue(String jsonObj, String key, String[] secondaryKeys){
        Gson gsonObject = new Gson();
        JsonObject jsonObject = gsonObject.fromJson(jsonObj, JsonObject.class);

        try {
            JsonArray value = jsonObject.get(key).getAsJsonArray();
            for (int i = 0; i < value.size(); i++) {
                for(String keys : secondaryKeys)
                    System.out.println(value.get(i).getAsJsonObject().get(keys));
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        return key;
    }

}
