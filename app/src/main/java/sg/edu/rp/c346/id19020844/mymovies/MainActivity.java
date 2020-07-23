package sg.edu.rp.c346.id19020844.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alMovieList = new ArrayList<>();

        lvMovie = findViewById(R.id.listViewMovie);

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(2014, 12, 15);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2015, 5, 15);

        alMovieList.add(new Movie("The Avengers", 2012, "pg13","Action | Sci-Fi", calendar1, "Golden Village - Bishan",
                "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.", 4));
        alMovieList.add(new Movie("Planes", 2013, "pg","Animation | Comedy", calendar2, "Cathay - AMK Hub",
                "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.", 2));

        caMovie = new CustomAdapter(this, R.layout.row, alMovieList);
        lvMovie.setAdapter(caMovie);

        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                Intent intentDetails = new Intent(MainActivity.this, MovieDetailsActivity.class);

                intentDetails.putExtra("title", alMovieList.get(i).getTitle());
                intentDetails.putExtra("year", alMovieList.get(i).getYear());
                intentDetails.putExtra("rated", alMovieList.get(i).getRated());
                intentDetails.putExtra("genre", alMovieList.get(i).getGenre());
                intentDetails.putExtra("watchOn", alMovieList.get(i).getWatched_on());
                intentDetails.putExtra("theatre", alMovieList.get(i).getIn_theatre());
                intentDetails.putExtra("description", alMovieList.get(i).getDescription());
                intentDetails.putExtra("ratingBar", alMovieList.get(i).getRatingBar());

                startActivity(intentDetails);
            }
        });

    }

}
