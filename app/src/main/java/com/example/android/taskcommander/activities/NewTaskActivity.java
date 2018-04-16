package com.example.android.taskcommander.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android.taskcommander.R;
import com.example.android.taskcommander.model.Group;
import com.example.android.taskcommander.model.Task;

import java.util.Date;

public class NewTaskActivity extends AppCompatActivity {
    private Group group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        Intent intent = getIntent();
        this.group = (Group)intent.getSerializableExtra("parentGroup");
    }

    public void onCreateTaskButtonClicked(final View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, GroupsTasksActivity.class);

        EditText captionField = (EditText) findViewById(R.id.task_details_caption_et);
        String caption = captionField.getText().toString();

        EditText descriptionField = (EditText) findViewById(R.id.task_details_description_et);
        String description = descriptionField.getText().toString();

        Task newTask = new Task(caption, description, new Date());

        intent.putExtra("newTask", newTask);
        intent.putExtra("parentGroup", group);
        intent.putExtra("group", group);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
