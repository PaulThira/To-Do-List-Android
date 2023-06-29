package com.example.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.todolist.RoomDatabase.DataBase;
import com.example.todolist.RoomDatabase.HabitTracker;
import com.example.todolist.RoomDatabase.HabitTrackerDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TDLList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TDLList extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private DataBase Db;
    private HabitTrackerDAO habitTrackerDAO;

    public TDLList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TDLList.
     */
    // TODO: Rename and change types and number of parameters
    public static TDLList newInstance(String param1, String param2) {
        TDLList fragment = new TDLList();
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
        View view = inflater.inflate(R.layout.fragment_t_d_l_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.habitTrackerList);
        Db = Room.databaseBuilder(requireContext().getApplicationContext(), DataBase.class, "ToDoListDbs")
                .build();
        habitTrackerDAO=Db.habitTrackerDAO();

// Create a layout manager (e.g., LinearLayoutManager or GridLayoutManager)
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(layoutManager);

// Create an instance of your adapter and set it to the RecyclerView
        List<String> itemList = new ArrayList<>();
        itemList.add("First");
        itemList.add("Second");
        itemList.add("Third");// Replace with your actual item list
        TDLAdapter adapter = new TDLAdapter(itemList);
        recyclerView.setAdapter(adapter);
        new Thread(()->{
            List<HabitTracker> tasks=habitTrackerDAO.getHabitTrackers();
            for(int i=0;i<tasks.size();i++){
                itemList.add(tasks.get(i).name);

            }
            getActivity().runOnUiThread(() -> {
                // Notify the RecyclerView of the data change
                adapter.notifyDataSetChanged();
            });

        }).start();
      TextView t=view.findViewById(R.id.TDLNames);
        view.findViewById(R.id.addTDL).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=t.getText().toString();
                if(!s.isEmpty()){
                    itemList.add(s);
                    adapter.notifyDataSetChanged();
                }
                new Thread(()->{

                        HabitTracker H=new HabitTracker();
                        H.id=habitTrackerDAO.getHabitTrackers().size()+1;
                        H.inUse=false;
                        H.idUser=1;
                        H.name=s;
                        habitTrackerDAO.insert(H);

                }).start();
            }
        });
        RequestQueue m = Volley.newRequestQueue(getContext());
        view.findViewById(R.id.GetItems).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url="https://api.jsonbin.io/v3/b/649dc2888e4aa6225eb699ce";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray jsonObject = response.getJSONArray("record");
                                    for (int i=0;i<jsonObject.length();i++){
                                        String k=jsonObject.get(i).toString();

                                        itemList.add(k);
                                        adapter.notifyDataSetChanged();

                                    }
                                    System.out.println("This is what is put out "+jsonObject.toString());


                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                m.add(request);
            }
        });

        // Inflate the layout for this fragment
        return view;}
}