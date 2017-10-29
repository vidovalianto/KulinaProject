package com.github.mhanifsp.sainsmanajemen;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Marker dapurInactiveMarker, dapurActiveMarker, customerActiveMarker, customerInactiveMarker;

    final private float[] colors = new float[]{
            BitmapDescriptorFactory.HUE_YELLOW,
            BitmapDescriptorFactory.HUE_AZURE,
            BitmapDescriptorFactory.HUE_RED,
            BitmapDescriptorFactory.HUE_CYAN,
            BitmapDescriptorFactory.HUE_MAGENTA,
            BitmapDescriptorFactory.HUE_ORANGE,
            BitmapDescriptorFactory.HUE_VIOLET
    };

    List<Customer> customers0;
    List<Dapur> dapurs0;
    List<Customer> listCustomer;
    List<Dapur> listDapur;

    void input(){
        customers0 = new ArrayList<>( Input.getCcustomerInput(this) );
        dapurs0 = new ArrayList<>( Input.getDapurInput(this) );
    }

    void copyStartingList(){
        listCustomer = new ArrayList<>( customers0 );
        listDapur = new ArrayList<>( dapurs0 );
    }

    void setPriorities(){
        for(Customer c : listCustomer){

            List<AbstractMap.SimpleEntry<Integer,Double>> distances = new ArrayList<>();
            int cnt = 0;

            for(Dapur d : listDapur) {
                distances.add(new AbstractMap.SimpleEntry<Integer, Double>(cnt,Calculator.getDistance(c,d)));
                cnt++;
            }

            Collections.sort(distances, new Comparator<AbstractMap.SimpleEntry<Integer, Double>>() {
                @Override
                public int compare(AbstractMap.SimpleEntry<Integer, Double> o1, AbstractMap.SimpleEntry<Integer, Double> o2) {
                    return o1.getValue().compareTo(o2.getValue());
                }
            });

            c.setDapurTerdekat(distances.get(0).getKey());
            c.setPrioritas( distances.get(0).getValue() / distances.get(1).getValue());
        }
    }

    void assignCustomerToDapur(){
        List<List<AbstractMap.SimpleEntry<Integer,Double>>> allCustomerInDapur = new ArrayList<>();
        for(Dapur d : listDapur){
            List<AbstractMap.SimpleEntry<Integer,Double>> list = new ArrayList<>();
            allCustomerInDapur.add(list);
        }

        int cnt = 0;
        for(Customer c : listCustomer){
            allCustomerInDapur.get(c.getDapurTerdekat()).add(new AbstractMap.SimpleEntry<Integer, Double>(cnt,c.getPrioritas()));
            cnt++;
        }

        for(List<AbstractMap.SimpleEntry<Integer,Double>> list : allCustomerInDapur){
            Collections.sort(list, new Comparator<AbstractMap.SimpleEntry<Integer, Double>>() {
                @Override
                public int compare(AbstractMap.SimpleEntry<Integer, Double> o1, AbstractMap.SimpleEntry<Integer, Double> o2) {
                    return o2.getValue().compareTo(o1.getValue());
                }
            });
        }

        List<Integer> siapDihapus = new ArrayList<>();
        cnt = 0;
        for(List<AbstractMap.SimpleEntry<Integer,Double>> list : allCustomerInDapur){
            Dapur d = listDapur.get(cnt);
            int sum = 0;
            for (AbstractMap.SimpleEntry<Integer,Double> pair : list){
                Customer c = listCustomer.get(pair.getKey());
                if(sum + c.getOrder() <= d.getMaxOrder()){
                    sum += c.getOrder();
                    d.addCustomerToList(c);
                    siapDihapus.add(pair.getKey());
                }
            }
            cnt++;
        }
    }

    public void assignDriverToCustomer(){
        
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);

        input();
        copyStartingList();
        setPriorities();
        assignCustomerToDapur();

        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Marker marker;

        int cnt = 0;
        for(Dapur d : listDapur){
            for (Customer c : d.getListCustomer()){
                mMap.addMarker(new MarkerOptions().position(new LatLng(c.getLatitude(),c.getLongitude())).title("C of " + d.getName()).icon(BitmapDescriptorFactory.defaultMarker(colors[cnt])));
            }
            marker = mMap.addMarker(new MarkerOptions().position(new LatLng(d.getLatitude(),d.getLongitude())).title(d.getName()).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            cnt++;
        }

        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(new LatLng(-6, 106))
                .zoom(10)
                .tilt(50)
                .build()));
    }
}
