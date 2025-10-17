package com.example.listycity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Main activity for the ListyCity app.
 * Displays a list of cities and allows the user to add or remove them.
 */
public class MainActivity extends AppCompatActivity {

    private ListView cityListView;
    private EditText cityEditText;
    private Button addButton;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize UI components
        cityListView = findViewById(R.id.city_list);
        cityEditText = findViewById(R.id.edit_city);
        addButton = findViewById(R.id.add_button);
        deleteButton = findViewById(R.id.delete_button);

        //Initial list of cities
        ArrayList<String> dataList = new ArrayList<>(Arrays.asList(
                "Edmonton", "Calgary", "Toronto", "Vancouver"
        ));

        // Adapter for the ListView
        ArrayAdapter<String> cityAdapter = new ArrayAdapter<>(
                this,
                R.layout.content,
                R.id.city_text,
                dataList
        );
        cityListView.setAdapter(cityAdapter);

        //Track which city is selected
        final int[] selectedPosition = {-1};

        cityListView.setOnItemClickListener((parent, view, position, id) -> {
            selectedPosition[0] = position;
        });

        // Add a city
        addButton.setOnClickListener(v -> {
            String newCity = cityEditText.getText().toString().trim();
            if (!newCity.isEmpty()) {
                dataList.add(newCity);
                cityAdapter.notifyDataSetChanged();
                cityEditText.setText("");
            }
        });

        // 🔹 Delete the selected city
        deleteButton.setOnClickListener(v -> {
            if (selectedPosition[0] != -1) {
                dataList.remove(selectedPosition[0]);
                cityAdapter.notifyDataSetChanged();
                selectedPosition[0] = -1;
            }
        });
    }
}
