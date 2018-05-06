package com.example.android.taskcommander.util;

import android.content.Context;

import com.example.android.taskcommander.model.Group;
import com.example.android.taskcommander.model.Task;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Tea on 5/2/2018.
 */

public class JsonToClassMapper {

    public ArrayList<Group> groupsMapping(JSONObject object, Context context) {

        ArrayList<Group> groups_objects = new ArrayList<>();
        try {
            JSONArray task_groups = object.getJSONArray("task_groups");
            Group group_object = null;

            for (int i = 0; i < task_groups.length(); i++) {
                JSONObject group = (JSONObject) task_groups.get(i);
                ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                group_object = mapper.readValue(group.toString(), Group.class);// read from json string
                groups_objects.add(group_object);
            }


        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return groups_objects;
    }

    public ArrayList<Task> tasksMapping(JSONArray tasks, Context context) {

        ArrayList<Task> tasks_objects = new ArrayList<>();
        try {

            Task task_object = null;

            for (int i = 0; i < tasks.length(); i++) {
                JSONObject task = (JSONObject) tasks.get(i);
                ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                task_object = mapper.readValue(task.toString(), Task.class);// read from json string
                tasks_objects.add(task_object);
            }


        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return tasks_objects;
    }
}