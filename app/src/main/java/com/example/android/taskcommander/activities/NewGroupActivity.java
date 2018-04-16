package com.example.android.taskcommander.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.android.taskcommander.R;
import com.example.android.taskcommander.model.Group;

public class NewGroupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);
    }

    public void onCreateGroupButtonClicked(final View view) {
        Context context = view.getContext();
        Intent intent = new Intent(context, GroupsActivity.class);

        EditText nameField = (EditText) findViewById(R.id.new_group_name_et);
        String name = nameField.getText().toString();
        Group newGroup = new Group(name);

        intent.putExtra("newGroup", newGroup);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);

    }
}
