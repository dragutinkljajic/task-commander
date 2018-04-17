package com.example.android.taskcommander.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.taskcommander.R;
import com.example.android.taskcommander.adapters.TasksAdapter;
import com.example.android.taskcommander.model.Task;

import java.util.ArrayList;
import java.util.Date;

public class MainFragment extends Fragment {

    private ArrayList<Task> tasks = new ArrayList<Task>();
    private RecyclerView recyclerView;
    private TasksAdapter tAdapter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.tasks_recycler_view);

        tAdapter = new TasksAdapter(getContext(), tasks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tAdapter);

        prepareTasksData();

        int index = -1;
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Task task = (Task) bundle.getSerializable("task");

            for (Task t : tasks) {
                if(t.getCaption().equals(task.getCaption())){
                    index = tasks.indexOf(t);
                    break;
                }
            }
            if(index!=-1) {
                tasks.remove(index);
            }
        }

        return view;
    }

    private void prepareTasksData(){
        Task task1 = new Task("Naslov taska 1 grupe Grupa 1", "Sadrzaj1", new Date());
        tasks.add(task1);

        Task task2 = new Task("Naslov taska 2 grupe Grupa 1", "Sadrzaj2", new Date());
        tasks.add(task2);

        Task task3 = new Task("Naslov taska 1 grupe Grupa 2", "Sadrzaj3", new Date());
        tasks.add(task3);

        Task task4 = new Task("Naslov taska 2 grupe Grupa 2", "Sadrzaj4", new Date());
        tasks.add(task4);
    }
}
