package com.example.omer.hw3;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrontPageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FrontPageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrontPageFragment extends Fragment /*implements View.OnClickListener*/ {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Integer num;
    public static int currentFrag = 0;
    Button aboutMeButton;
    Button  task1Button;
    Button task2Button;
    TextView textView;

    private OnFragmentInteractionListener mListener;

    public FrontPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment FrontPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FrontPageFragment newInstance() {
        FrontPageFragment fragment = new FrontPageFragment();
        Bundle args = new Bundle();
        //args.putInt(ARG_PARAM1, num);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        int num = getArguments().getInt(ARG_PARAM1);
        if (currentFrag == 0) {
            view = inflater.inflate(R.layout.fragment_front_page, container, false);
            aboutMeButton = (Button) view.findViewById(R.id.aboutMeButton);

            aboutMeButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.e("Fragment", "Button Clicked!");
                   // Toast.makeText(getContext(), "got this to work", Toast.LENGTH_LONG).show();
                    currentFrag = 1;
                    mListener.onFragmentInteraction(0);
                }
            });

            task1Button = (Button) view.findViewById(R.id.task1Button);

            task1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentInteraction(1);
                }
            });

            task2Button = (Button) view.findViewById(R.id.task2Button);

            task2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onFragmentInteraction(2);
                }
            });
        }
        else  {
            view = inflater.inflate(R.layout.fragment_about_me, container, false);
          // textView = (TextView) view.findViewById(R.id.textView);
          //  textView.setText(num+"");
        }


        return view;

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
      public void onFragmentInteraction(int num);
    }
}
