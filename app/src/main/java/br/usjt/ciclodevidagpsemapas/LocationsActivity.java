package br.usjt.ciclodevidagpsemapas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class LocationsActivity extends AppCompatActivity {

    private ListView locationsListView;
    private ArrayList<MyLocation> locationsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_locations);
        locationsListView = findViewById(R.id.locationsListView);
        locationsList = intent.getParcelableArrayListExtra("myList");
        ArrayAdapter<MyLocation> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, locationsList);
        locationsListView.setAdapter(adapter);

        locationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri gmmIntentUri = Uri.parse(String.format("geo:%f, %f", locationsList.get(position).getLatitude(), locationsList.get(position).getLongitude()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });
    }
}
