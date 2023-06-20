package com.example.todolist;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HabitsList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HabitsList extends Fragment {
    private RecyclerView recyclerView;
    private HabitAdapter adapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HabitsList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HabitsList.
     */
    // TODO: Rename and change types and number of parameters
    public static HabitsList newInstance(String param1, String param2) {
        HabitsList fragment = new HabitsList();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_habits_list, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));

        List<String> dates = new ArrayList<String>();
        List<String> items=new ArrayList<String>();
        List<Boolean> doneItems=new ArrayList<Boolean>();
        dates.add("01/02/02");
        dates.add("03/08/21");
        dates.add("05/12/22");
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        doneItems.add(true);
        doneItems.add(false);
        doneItems.add(true);

        adapter = new HabitAdapter(items,dates,doneItems);
        recyclerView.setAdapter(adapter);

        return view;
    }
}