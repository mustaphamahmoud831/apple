/*package com.example.resturant;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class finish extends AppCompatActivity {
    public static ArrayList result_menus;
    Button btn_finish, btn_location;
    ListView lv_orders = findViewById(R.id.lv_order);
    ArrayList<menu> menuArrayList = new ArrayList<>();
    List<menu> menus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        adapter orderadapter = new adapter(getApplicationContext(), menus);
        btn_finish = (Button) findViewById(R.id.btn_finish);
        btn_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(finish.this, "Your order is done", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(finish.this, home.class);
                startActivity(intent);
            }
        });


        btn_location = (Button) findViewById(R.id.btn_location);
        btn_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent google_map = new Intent(Intent.ACTION_VIEW);
                PackageManager managerclock = getPackageManager();
                google_map = managerclock.getLaunchIntentForPackage("com.google.android.apps.maps");
                google_map.addCategory(Intent.CATEGORY_LAUNCHER);
                startActivity(google_map);
            }
        });
        /*this wrote on a basic page*/
           /*        lv_orders.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                Intent intent =new Intent(finish.this,first.class);
                 intent.putExtra();




            }
        });*/


package com.example.apple;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class finish extends AppCompatActivity {

    public static ArrayList<dessertmenu> result_menu = new ArrayList<>();
    public static ArrayList<drink> result_men = new ArrayList<>();
    public static ArrayList<com.example.apple.menu> result_menus = new ArrayList<>();
    public LocationManager locationManager;
    public LocationListener locationListener = new MyLocationManger();
    ListView result_listView;
    Button save, getlocation;
    TextView price, setlocation;
    EditText address;
    AlertDialog.Builder alert_dialog;
    DatabaseReference ref;
    String latitude, longitude;
    Geocoder geocoder;
    List<Address> myAdress;
    private boolean gps_enable = false;
    private boolean network_enable = false;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_finish);
        //IDs
        Toolbar toolbar;
        toolbar = findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        address = findViewById(R.id.edt_address);
        result_listView = findViewById(R.id.lv_order);
        save = findViewById(R.id.btn_finish);
        price = findViewById(R.id.result_layout_price_tv);
        getlocation = findViewById(R.id.btn_location);



        // ---- save order (button) code ------------
        final MenuListView result_myadptar = new MenuListView(this, R.layout.menu_row, result_menus);
        final int count = result_myadptar.getCount();


        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                alert_dialog = new AlertDialog.Builder(finish.this);


                alert_dialog.setTitle("Confirmation");
                alert_dialog.setCancelable(false);
                alert_dialog.setMessage("Save order ..?");
                ref = FirebaseDatabase.getInstance().getReference().child("Orders");


                alert_dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String addressToBase = address.getText().toString().trim();

                        com.example.apple.ToDataBase toDataBase = new com.example.apple.ToDataBase();
                        toDataBase.setData(result_menus);
                        toDataBase.setAddress(addressToBase);

                        ref.push().setValue(toDataBase);

                        Toast.makeText(getApplicationContext(), "Order Saved !", Toast.LENGTH_LONG).show();
                        result_menus.clear();

                        Intent to_home = new Intent(finish.this, choices.class);
                        startActivity(to_home);


                    }
                });

                alert_dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });


                AlertDialog dialog = alert_dialog.create();
                dialog.show();


            }
        });


        result_listView.setAdapter(result_myadptar);

        ArrayList<Double> value = new ArrayList<>();
        double total = 0;

        for (int i = 0; i < count; i++) {
            value.add(i, Double.parseDouble(result_menus.get(i).getText2()));


            total = total + value.get(i);
        }

        price.setText("   " + getString(R.string.result_layout_price_tv) + " " + total + " LE");

        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        getlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setlocation.setVisibility(View.VISIBLE);
                getMyLocation();
            }
        });
        checkLocationPermission();
    }

    public void getMyLocation() {
        try {
            gps_enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }
        try {
            network_enable = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        } catch (Exception ex) {

        }
        if (!gps_enable && !network_enable) {
            android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(finish.this);
            builder.setTitle("Attention");
            builder.setMessage("Sorry. Location is not available now, Please enable location service");
            builder.create().show();
        }
        if (gps_enable) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
        if (network_enable) {
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
        }
    }

    private boolean checkLocationPermission() {
        int location = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int location2 = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION);
        List<String> listPermission = new ArrayList<>();
        if (location != PackageManager.PERMISSION_GRANTED) {
            listPermission.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (location2 != PackageManager.PERMISSION_GRANTED) {
            listPermission.add(Manifest.permission.ACCESS_COARSE_LOCATION);
        }
        if (!listPermission.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermission.toArray(new String[listPermission.size()]), 1);
        }
        return true;
    }

    class MyLocationManger implements LocationListener {

        @Override
        public void onLocationChanged(@NonNull Location location) {
            if (location != null) {
                locationManager.removeUpdates(locationListener);
                latitude = "" + location.getLatitude();
                longitude = "" + location.getLongitude();
                geocoder = new Geocoder(finish.this, Locale.getDefault());
                try {
                    myAdress = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                String address1 = myAdress.get(0).getAddressLine(0);

                setlocation.setText(address1);
            }
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(@NonNull String provider) {

        }

        @Override
        public void onProviderDisabled(@NonNull String provider) {

        }
    }
}

