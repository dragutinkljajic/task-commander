package com.example.android.taskcommander.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.android.taskcommander.R;
import com.example.android.taskcommander.adapters.TasksAdapter;
import com.example.android.taskcommander.model.Group;
import com.example.android.taskcommander.model.Task;

import java.util.ArrayList;
import java.util.Date;

public class GroupsTasksActivity extends AppCompatActivity {

    private ArrayList<Task> tasks = new ArrayList<Task>();
    private Group group;
    private RecyclerView recyclerView;
    private TasksAdapter tAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_tasks);

        recyclerView = (RecyclerView) findViewById(R.id.groups_tasks_recycler_view);

        tAdapter = new TasksAdapter(this, tasks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tAdapter);

        Intent intent = getIntent();
        this.group = (Group)intent.getSerializableExtra("group");
        prepareGroupsTasksData();

        if(intent.hasExtra("parentGroup")){
            this.group = (Group) intent.getSerializableExtra("parentGroup");
        }

        if(intent.hasExtra("newTask")){
            Task task = (Task)intent.getSerializableExtra("newTask");
            tasks.add(task);
        }

    }

    private void prepareGroupsTasksData(){
        Task task1 = new Task("Naslov taska 1 grupe "+group.getName(), "Sadrzaj 1", new Date());
        tasks.add(task1);

        Task task2 = new Task("Naslov taska 2 grupe "+group.getName(), "Sadrzaj 2", new Date());
        tasks.add(task2);
    }

    public void onAddNewTaskButtonClicked(final View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, NewTaskActivity.class);
        intent.putExtra("parentGroup", group);
        context.startActivity(intent);
    }
}
