package com.example.android.taskcommander.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.android.taskcommander.R;
import com.example.android.taskcommander.adapters.TasksAdapter;
import com.example.android.taskcommander.model.Task;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class HomeActivity extends AppCompatActivity {
    private ArrayList<Task> tasks = new ArrayList<Task>();
    private RecyclerView recyclerView;
    private TasksAdapter tAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        recyclerView = (RecyclerView) findViewById(R.id.tasks_recycler_view);

        tAdapter = new TasksAdapter(this, tasks);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(tAdapter);

        prepareTasksData();

        Intent intent = getIntent();
        int index = -1;
        if(intent.hasExtra("task")){
            Task task =(Task)intent.getSerializableExtra("task");

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.menu_groups:
                Intent intent = new Intent(this, GroupsActivity.class);
                this.startActivity(intent);
                break;
            case R.id.menu_item2:
                // another startActivity, this is for item with id "menu_item2"
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
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
