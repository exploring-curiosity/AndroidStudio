package com.example.gpslocation;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.app.ActivityCompat;
        import androidx.core.content.ContextCompat;

        import android.Manifest;
        import android.content.Context;
        import android.content.pm.PackageManager;
        import android.location.LocationListener;
        import android.location.LocationManager;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText lat, lon;
    private GPSTracker gpsTracker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button track = (Button) findViewById(R.id.track_btn);
        lat = (EditText) findViewById(R.id.lat);
        lon = (EditText) findViewById(R.id.lon);

        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e){
            e.printStackTrace();
        }

        track.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gpsTracker = new GPSTracker(MainActivity.this);
                if(gpsTracker.canGetLocation()){
                    Log.i("MainActivity","Success");
                    double latitude = gpsTracker.getLatitude();
                    double longitude = gpsTracker.getLongitude();
                    lat.setText(String.valueOf(latitude));
                    lon.setText(String.valueOf(longitude));
                }else{
                    Log.i("MainActivity","Failure");
                    gpsTracker.showSettingsAlert();
                }
            }
        });
    }
}