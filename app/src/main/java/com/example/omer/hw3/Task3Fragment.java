package com.example.omer.hw3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Task3Fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Task3Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Task3Fragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;

    TextView title;
    TextView description;
    TextView year;
    ImageView pictureView;
    RatingBar ratingView;

    private OnFragmentInteractionListener mListener;

    public Task3Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment Task3Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Task3Fragment newInstance(int num) {
        Task3Fragment fragment = new Task3Fragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, num);
        //args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
          // mParam1 = getArguments().getInt(ARG_PARAM1);
          // mParam2 = getArguments().getString(ARG_PARAM2);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        int currentFrag = getArguments().getInt(ARG_PARAM1);
        if (currentFrag == 0) {
            view = inflater.inflate(R.layout.fragment_task3, container, false);

            button1 = (Button) view.findViewById(R.id.movie1Button);
            button2 = (Button) view.findViewById(R.id.movie2Button);
            button3 = (Button) view.findViewById(R.id.movie3Button);
            button4 = (Button) view.findViewById(R.id.movie4Button);
            button5 = (Button) view.findViewById(R.id.movie5Button);


            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentInteraction(1);
                }
            });

            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentInteraction(2);
                }
            });

            button3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentInteraction(3);
                }
            });

            button4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentInteraction(4);
                }
            });

            button5.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentInteraction(5);
                }
            });

        }
        else {

            MovieData movieData = new MovieData();
            HashMap movie = movieData.getItem(currentFrag);
            //View view = view = inflater.inflate(R.layout.fragment_movie, container, false);
            view = inflater.inflate(R.layout.fragment_task3_2, container, false);
            //Log.e("Num",movieData.getSize()+"");

            title = (TextView) view.findViewById(R.id.title2);
            description = (TextView) view.findViewById(R.id.description2);
            year = (TextView) view.findViewById(R.id.year2);
            pictureView = (ImageView) view.findViewById(R.id.pictureView2);
            ratingView = (RatingBar) view.findViewById(R.id.ratingView2);

            //String omer = (String) (movie.get("name"));

            title.setText((String) movie.get("name"));
            description.setText((String) movie.get("description"));
            year.setText((String) movie.get("year"));

            int imageId = (Integer) movie.get("image");
            pictureView.setImageResource(imageId);
            double progress = (double) movie.get("rating");
            //progress /= 20;
            ratingView.setProgress((int)progress);


        }


        // Inflate the layout for this fragment
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {

        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(int num);
    }
}
