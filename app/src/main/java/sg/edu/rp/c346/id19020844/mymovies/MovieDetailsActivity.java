package sg.edu.rp.c346.id19020844.mymovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieDetailsActivity extends AppCompatActivity {
    TextView tvTitle, tvGenre, tvYear, tvDes, tvWatchOn, tvInTheatre;
    ImageView ivRating;

    ArrayList<Movie> movieList = new ArrayList<Movie>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);
        tvTitle = findViewById(R.id.textViewTitle);
        tvGenre = findViewById(R.id.textViewGenre);
        tvYear = findViewById(R.id.textViewYear);
        tvDes = findViewById(R.id.textViewDescription);
        tvWatchOn = findViewById(R.id.textViewWatchedOn);
        tvInTheatre = findViewById(R.id.textViewInTheatre);
        ivRating = findViewById(R.id.imageViewRating);


        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        int ratingBar = intent.getIntExtra("rating", 0);
        int year = intent.getIntExtra("year",0);
        String rating = intent.getStringExtra("rated");
        String genre = intent.getStringExtra("genre");
        String watchOn = intent.getStringExtra("watch_on");
        String inTheatre = intent.getStringExtra("in_theatre");
        String description = intent.getStringExtra("description");

        if(rating.equalsIgnoreCase("g")){
            ivRating.setImageResource(R.drawable.rating_g);
        } else if (rating.equalsIgnoreCase("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        } else if (rating.equalsIgnoreCase("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        } else if (rating.equalsIgnoreCase("nc16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        } else if (rating.equalsIgnoreCase("m18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }else if (rating.equalsIgnoreCase("r21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        tvTitle.setText(title);

        tvYear.setText(year + "");
        tvGenre.setText(genre);


        tvDes.setText(description);
        tvWatchOn.setText("Watch On: " + watchOn);
        tvInTheatre.setText("In Theatre: " + inTheatre);
    }
}
