package com.example.projetoaps;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, LocationListener {

    private GoogleMap mMap;
    private Marker marcadorLocal;
    private LatLng  localizacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        startGettingLocations();
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

        //setar a possição atual para manaus
        LatLng manaus =new LatLng(-3.1028396,-60.025656);
          mMap.moveCamera(CameraUpdateFactory.newLatLng(manaus));
        CameraPosition cameraPosition = new CameraPosition.Builder().zoom(13).target(manaus).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        BitmapDescriptor ico01 = BitmapDescriptorFactory.fromResource(R.drawable.imagens01);
        BitmapDescriptor ico02 = BitmapDescriptorFactory.fromResource(R.drawable.imagens02);
        BitmapDescriptor ico03 = BitmapDescriptorFactory.fromResource(R.drawable.imagens03);
        BitmapDescriptor ico04 = BitmapDescriptorFactory.fromResource(R.drawable.imagens04);

        // Add a marcadores no map

        /**coleta de lâmpadas fluorescentes**/

        LatLng SV1 =new LatLng(-3.1247607,-59.9950247 );
        mMap.addMarker(new MarkerOptions().position(SV1).title("SV Instalações LTDA")
        .snippet("coleta de lâmpadas fluorescentes").icon(ico01));

        LatLng SV2 =new LatLng(-3.114454, -60.020792 );
        mMap.addMarker(new MarkerOptions().position(SV2).title("SV Instalações LTDA")
                .snippet("coleta de lâmpadas fluorescentes").icon(ico01));

        LatLng Makro1 =new LatLng (-3.109600, -59.980520 );
        mMap.addMarker(new MarkerOptions().position(Makro1).title("Makro - Loja")
                .snippet("coleta de lâmpadas fluorescentes").icon(ico01));

        LatLng Makro2 =new LatLng(-3.136519, -60.012536 );
        mMap.addMarker(new MarkerOptions().position(Makro2).title("Makro – Loja Manaus Moderna")
                .snippet("coleta de lâmpadas fluorescentes").icon(ico01));

        LatLng BA =new LatLng(-3.076714, -60.025715 );
        mMap.addMarker(new MarkerOptions().position(BA).title("BA Elétrica")
                .snippet("coleta de lâmpadas fluorescentes").icon(ico01));

        /******   associações   ****/
               LatLng Arpa =new LatLng(-3.049941, -59.911160);
        mMap.addMarker(new MarkerOptions().position(Arpa).title("Arpa")
                .snippet("Associação de reciclagem que pode receber o lixo separado da população").icon(ico03));

        LatLng CALMA =new LatLng(-3.096146, -59.948822);
        mMap.addMarker(new MarkerOptions().position(CALMA).title("CALMA")
                .snippet("Associação de reciclagem que pode receber o lixo separado da população").icon(ico03));

        LatLng  COOPECAMARE =new LatLng(-3.037098, -59.939739);
        mMap.addMarker(new MarkerOptions().position(COOPECAMARE).title("COOPECAMARE")
                .snippet("Associação de reciclagem que pode receber o lixo separado da população").icon(ico03));

        /******   cooperativa   ****/

        LatLng  ECO =new LatLng(-2.999426, -60.012785);
        mMap.addMarker(new MarkerOptions().position(ECO).title("ECO COOPERATIVA")
                .snippet("COOPERATIVA de reciclagem que pode receber o lixo separado da população").icon(ico03));

        LatLng  Sucat =new LatLng(-3.105565, -60.049175);
        mMap.addMarker(new MarkerOptions().position(Sucat).title("Sucatão n.s de nazaré")
                .snippet("COOPERATIVA de reciclagem que pode receber o lixo separado da população").icon(ico03));

        LatLng  COOPERNORTE =new LatLng(-3.124688, -59.995162);
        mMap.addMarker(new MarkerOptions().position(COOPERNORTE).title("COOPERNORTE")
                .snippet("COOPERATIVA de reciclagem que pode receber o lixo separado da população").icon(ico03));

        /*  GRUPOS INDEPENDENTES */

        LatLng  INS =new LatLng(-2.997070, -60.005545);
        mMap.addMarker(new MarkerOptions().position(INS).title("INST. AMBIENTAL DOROTHY STANG")
                .snippet("Grupo Indenpendente de Reciclagem").icon(ico03));

        LatLng  ASSO =new LatLng(-2.997070, -60.005545);
        mMap.addMarker(new MarkerOptions().position(ASSO).title("ASSOC. CATAD. Mª DO BAIRRO")
                .snippet("Grupo Indenpendente de Reciclagem").icon(ico03));

        LatLng  INSSOC =new LatLng(-3.088664, -60.056638);
        mMap.addMarker(new MarkerOptions().position(INSSOC).title("INST. AMBIENTAL DOROTHY STANG")
                .snippet("Grupo Indenpendente de Reciclagem").icon(ico03));

        LatLng  GUADALIPE =new LatLng(-3.026726, -59.997475);
        mMap.addMarker(new MarkerOptions().position(GUADALIPE).title("ASS. FILHAS DE GUADALIPE")
                .snippet("Grupo Indenpendente de Reciclagem").icon(ico03));

            /* NÚCLEOS DE CATADORES */

        LatLng  NU1 =new LatLng(-3.007820, -59.975335);
        mMap.addMarker(new MarkerOptions().position(NU1).title("NÚCLEOS I")
                .snippet("NÚCLEOS DE CATADORES").icon(ico03));

        LatLng  NU2 =new LatLng(-2.983137, -60.011530);
        mMap.addMarker(new MarkerOptions().position(NU2).title("NÚCLEOS III")
                .snippet("NÚCLEOS DE CATADORES").icon(ico03));

        /*  lixo eletronico */

        LatLng  DescarT =new LatLng(-3.066024, -60.003680);
        mMap.addMarker(new MarkerOptions().position(DescarT).title("Descarte Correto")
                .snippet("Ponto de coleta de lixo eletrônico").icon(ico04));

        LatLng  Amazon1 =new LatLng(-3.085294, -60.071955);
        mMap.addMarker(new MarkerOptions().position(Amazon1).title("Amazon Print")
                .snippet("Ponto de coleta de celulares e carregadores").icon(ico04));

        LatLng  Amazon2 =new LatLng(-3.116323, -59.983322);
        mMap.addMarker(new MarkerOptions().position(Amazon2).title("Amazon Print")
                .snippet("Ponto de coleta de celulares e carregadores").icon(ico04));

        /* outros */
        LatLng  Coleta =new LatLng(-3.116501, -59.962432);
        mMap.addMarker(new MarkerOptions().position(Coleta).title("Brasil Coleta")
                .snippet("compra e venda de material reciclavel ").icon(ico02));

        LatLng  Dois =new LatLng(-3.092874, -59.984991);
        mMap.addMarker(new MarkerOptions().position(Dois).title("Reciclagem Dois Irmãos")
                .snippet("compra e venda de material reciclavel ").icon(ico02));

    }

    @Override
    public void onLocationChanged(Location location) {

        if (marcadorLocal != null) {
            marcadorLocal.remove();
        }
        //Add marker
        localizacao = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(localizacao);
        markerOptions.title("Sua Localização");
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        marcadorLocal = mMap.addMarker(markerOptions);

        //mover a camera p a posição atual
        CameraPosition cameraPosition = new CameraPosition.Builder().zoom(14).target(localizacao).build();
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));



        Toast.makeText(this, "Localização atualizada", Toast.LENGTH_SHORT).show();


    }



    private ArrayList findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList result = new ArrayList();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }

        return result;
    }

    private boolean hasPermission(String permission) {
        if (canAskPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }

    private boolean canAskPermission() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("GPS desativado!");
        alertDialog.setMessage("Ativar GPS?");
        alertDialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        });

        alertDialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        alertDialog.show();
    }


    private void startGettingLocations() {

        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        boolean isGPS = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        boolean isNetwork = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        boolean canGetLocation = true;
        int ALL_PERMISSIONS_RESULT = 101;
        long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10;// Distance in meters
        long MIN_TIME_BW_UPDATES = 1000 * 10;// Time in milliseconds

        ArrayList<String> permissions = new ArrayList<>();
        ArrayList<String> permissionsToRequest;

        permissions.add(android.Manifest.permission.ACCESS_FINE_LOCATION);
        permissions.add(android.Manifest.permission.ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);

        //Check if GPS and Network are on, if not asks the user to turn on
        if (!isGPS && !isNetwork) {
            showSettingsAlert();
        } else {
            // check permissions

            // check permissions for later versions
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                if (permissionsToRequest.size() > 0) {
                    requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]),
                            ALL_PERMISSIONS_RESULT);
                    canGetLocation = false;
                }
            }
        }


        //Checks if FINE LOCATION and COARSE Location were granted
        if (ActivityCompat.checkSelfPermission(this,
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {

            Toast.makeText(this, "Permissão negada", Toast.LENGTH_SHORT).show();
            return;
        }

        //Starts requesting location updates
        if (canGetLocation) {
            if (isGPS) {
                lm.requestLocationUpdates(
                        LocationManager.GPS_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

            } else if (isNetwork) {
                // from Network Provider

                lm.requestLocationUpdates(
                        LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES,
                        MIN_DISTANCE_CHANGE_FOR_UPDATES, this);

            }
        } else {
            Toast.makeText(this, "Não é possível obter a localização", Toast.LENGTH_SHORT).show();
        }
    }




    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
    /*Metodo para poder incluir imagens no marcador
    private BitmapDescriptor bitmapDescriptorFromVector(Context context, int vectorResId) {
        Drawable vectorDrawable = ContextCompat.getDrawable(context, vectorResId);
        vectorDrawable.setBounds(0, 0, vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight());
        Bitmap bitmap = Bitmap.createBitmap(vectorDrawable.getIntrinsicWidth(), vectorDrawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        vectorDrawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }*/
}
