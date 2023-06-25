package com.example.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HabitTrackerList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HabitTrackerList extends Fragment {
    private RecyclerView HabitTrackerRecyclerView;
    private HabitTrackerAdapter habitTrackerAdapter;
    private List<String> names;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HabitTrackerList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HabitTrackerList.
     */
    // TODO: Rename and change types and number of parameters
    public static HabitTrackerList newInstance(String param1, String param2) {
        HabitTrackerList fragment = new HabitTrackerList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_habit_tracker_list, container, false);
        HabitTrackerRecyclerView=view.findViewById(R.id.HabitTrackerList);
        HabitTrackerRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));
        names=new ArrayList<String>();
        names.add("Work");
        names.add("Gym");
        names.add("Personal");
        habitTrackerAdapter=new HabitTrackerAdapter(names);
        HabitTrackerRecyclerView.setAdapter(habitTrackerAdapter);
        // Inflate the layout for this fragment
        return view;
    }
}