package com.example.todolist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.room.Room;

import com.example.todolist.RoomDatabase.DataBase;
import com.example.todolist.RoomDatabase.User;
import com.example.todolist.RoomDatabase.UserDAO;
import com.example.todolist.databinding.FragmentSignUpBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUp#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUp extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private DataBase Db;
    private UserDAO userDao;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentSignUpBinding binding;

    public SignUp() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUp.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUp newInstance(String param1, String param2) {
        SignUp fragment = new SignUp();
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
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        Db = Room.databaseBuilder(requireContext().getApplicationContext(), DataBase.class, "ToDoListDB")
                .build();
        userDao= Db.userDAO();
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Thread T=new Thread(new Runnable(){
                    @Override
                   public void run(){
                        User U=new User();
                        U.id=userDao.getUsers().toArray().length+1;
                        U.name=binding.editTextTextPersonName.getText().toString();
                        U.email=binding.editTextTextEmailAddress.getText().toString();
                        U.password=binding.editTextTextPassword.getText().toString();
                        U.loggedIn=true;
                        userDao.insert(U);
                    }
                });

                T.start();
                NavHostFragment.findNavController(SignUp.this).navigate(R.id.action_SignUp_to_MainMenu);



            }
        });
}}