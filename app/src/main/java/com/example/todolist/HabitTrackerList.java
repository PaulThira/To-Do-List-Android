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
import com.example.todolist.RoomDatabase.TDL;
import com.example.todolist.RoomDatabase.TDLDAO;
import com.example.todolist.RoomDatabase.User;
import com.example.todolist.RoomDatabase.UserDAO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private DataBase Db;
    private TDLDAO tdldao;
    private UserDAO userDAO;


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
        Db = Room.databaseBuilder(requireContext().getApplicationContext(), DataBase.class, "ToDoListDbs")
                .build();
        tdldao= Db.tdldao();
        userDAO= Db.userDAO();
        RequestQueue m = Volley.newRequestQueue(getContext());

        names=new ArrayList<String>();
        names.add("Work");
        names.add("Gym");
        names.add("Personal");
        TextView textView=view.findViewById(R.id.HabitTrackerName);
        final int[] id = {0};
        new Thread(()-> {
            List<User> users=userDAO.getUsers().stream().filter(i->i.loggedIn==true).collect(Collectors.toList());
            System.out.println("users that are logged in"+users.size());



        }).start();
        view.findViewById(R.id.gets).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url="https://api.jsonbin.io/v3/b/649d94788e4aa6225eb68824";
                JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONArray jsonObject = response.getJSONArray("record");
                                  for (int i=0;i<jsonObject.length();i++){
                                      String k=jsonObject.get(i).toString();

                                      names.add(k);
                                      habitTrackerAdapter.notifyDataSetChanged();
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

        view.findViewById(R.id.addHabitTracker).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                String name=textView.getText().toString();
                names.add(name);
                habitTrackerAdapter.notifyDataSetChanged();
                JSONArray tdls=new JSONArray();

                new Thread(()-> {
                    TDL T=new TDL();
                    T.id=tdldao.getTDLs().size()+1;
                    T.inUse=false;
                    T.name=name;
                    T.idUser=1;
                    tdldao.insert(T);
                    getActivity().runOnUiThread(() -> {
                        // Notify the RecyclerView of the data change
                        habitTrackerAdapter.notifyDataSetChanged();
                    });
                    JSONObject tdl=toJson(T);
                    tdls.put(tdl.toString());
                    System.out.println(tdls.toString());
                    try {
                        File directory = getActivity().getFilesDir();
                        String fileName = "File.json";
                        File file = new File(directory, fileName);
                        FileOutputStream fileOutputStream = new FileOutputStream(file);

                        fileOutputStream.write(tdls.toString().getBytes(StandardCharsets.UTF_8));
                        fileOutputStream.close();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }).start();

            }
        });

        habitTrackerAdapter=new HabitTrackerAdapter(names);
        HabitTrackerRecyclerView.setAdapter(habitTrackerAdapter);
        // Inflate the layout for this fragment
        return view;
    }

    public JSONObject toJson(TDL tdl) {
        JSONObject tdlnew=new JSONObject();
        try{
            tdlnew.put("id",tdl.id);
            tdlnew.put("inUse",tdl.inUse);
            tdlnew.put("idUser",tdl.idUser);
            tdlnew.put("name",tdl.name);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return tdlnew;
    }
}
