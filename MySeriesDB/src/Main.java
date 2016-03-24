import com.google.gson.*;
import java.sql.*;

/**
 * Created by Alexander on 2016-03-21.
 */
public class Main {
    private static final String API_KEY = "218001794815ac684503044a30d78b15";

    public static void main(String[] args){
//        MainLayout myLayout = new MainLayout();
        TMDbAPI api = new TMDbAPI(API_KEY);
        String respSeries = api.getResponse(4556);
        String respEpisodes = api.getResponse(4556, 1);
        Gson convertGson = new Gson();
        JsonElement jelem = convertGson.fromJson(respEpisodes, JsonElement.class);
        JsonObject jobj = jelem.getAsJsonObject();
        JsonArray jsonArray = jobj.get("episodes").getAsJsonArray();
        String finalEpisodes = jsonArray.toString();
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Series.class, new SeriesDeserializer());
        gsonBuilder.registerTypeAdapter(Season.class, new SeasonsDeserializer());
        gsonBuilder.registerTypeAdapter(Episode.class, new EpisodesDeserializer());
        Gson gson = gsonBuilder.create();

        Series series = gson.fromJson(respSeries, Series.class);
        Episode[] episodes = gson.fromJson(finalEpisodes, Episode[].class);
        series.getSeason(1).setEpisodes(episodes);
        System.out.println(series);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String aut = "jdbc:sqlserver://localhost;databaseName=MyDatabase;user=Alex;password=unicorn";
            Connection con = DriverManager.getConnection(aut);
            Statement st = con.createStatement();

//            st.executeUpdate("insert into Friends values(1, 'Camilla', 'Milla', '2011-06-12')");
//            con.commit();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
