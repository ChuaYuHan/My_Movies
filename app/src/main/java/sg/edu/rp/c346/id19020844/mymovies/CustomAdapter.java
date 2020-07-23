package sg.edu.rp.c346.id19020844.mymovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(Context context, int resource, ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) parent_context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(layout_id, parent, false);

        ImageView ivRating = rowView.findViewById(R.id.imageViewRating);
        TextView tvTitle = rowView.findViewById(R.id.textViewTitle);
        TextView tvYear = rowView.findViewById(R.id.textViewYear);
        TextView tvGenre = rowView.findViewById(R.id.textViewGenre);

        Movie currentItem = movieList.get(position);

        if(currentItem.getRated() == "g") {
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if(currentItem.getRated() == "pg") {
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if(currentItem.getRated() == "pg13") {
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if(currentItem.getRated() == "nc16") {
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if(currentItem.getRated() == "m18") {
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else {
            ivRating.setImageResource(R.drawable.rating_r21);
        }

        tvTitle.setText(currentItem.getTitle());
        tvYear.setText(currentItem.getYear()+"");
        tvGenre.setText(currentItem.getGenre());

        return rowView;

    }
}
