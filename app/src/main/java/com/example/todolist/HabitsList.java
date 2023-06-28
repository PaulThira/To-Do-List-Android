package com.example.todolist;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.todolist.RoomDatabase.DataBase;
import com.example.todolist.RoomDatabase.Task;
import com.example.todolist.RoomDatabase.TaskDAO;
import com.example.todolist.databinding.FragmentHabitsListBinding;

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
    private FragmentHabitsListBinding binding;
   private List<String > items=new ArrayList<String>();
   private List<String> dates=new ArrayList<String>();
   private List<Boolean> doneItems=new ArrayList<Boolean>();
   private DataBase Db;
   private TaskDAO taskDAO;

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
        Db = Room.databaseBuilder(requireContext().getApplicationContext(), DataBase.class, "ToDoListDb")
                .build();
        taskDAO= Db.taskDAO();
        Task t=new Task();
        new Thread(()-> {
            List<Task> tasks=taskDAO.getAllTasks();
            for(int i=0;i<tasks.size();i++){
                items.add(tasks.get(i).name);
                doneItems.add(tasks.get(i).status);
                dates.add(tasks.get(i).dueDate);
            }
            getActivity().runOnUiThread(() -> {
                // Notify the RecyclerView of the data change
                adapter.notifyDataSetChanged();
            });



        }).start();





        binding = FragmentHabitsListBinding.inflate(inflater, container, false);

        EditText names=view.findViewById(R.id.taskName);
        EditText date=view.findViewById(R.id.DueDate);
        view.findViewById(R.id.addHabit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean b=false;
                String name=names.getText().toString();
                String dueDate=date.getText().toString();
                if(!name.isEmpty()&&!dueDate.isEmpty()){
                    items.add(name);
                    dates.add(dueDate);
                    doneItems.add(b);
                    adapter.notifyDataSetChanged();
                    adapter.notifyItemInserted(items.size() - 1);

                    new Thread(()-> {
                        Task T=new Task();
                        T.id=taskDAO.getAllTasks().size()+1;
                        T.status=false;
                        T.name=name;
                        T.dueDate=dueDate;

                        taskDAO.insert(T);




                    }).start();





                    Log.println(Log.INFO,"recycler","Function done");
                    System.out.println("Function Done");


                }
            }
        });



        adapter = new HabitAdapter(items,dates,doneItems);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;

    }
    public void AddItems( ){

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}