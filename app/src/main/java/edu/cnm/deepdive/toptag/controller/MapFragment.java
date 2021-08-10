package edu.cnm.deepdive.toptag.controller;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.data.kml.KmlLayer;
import edu.cnm.deepdive.toptag.R;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/**
 *  Receives google map, sets zoom and adds map overlay.
 */
public class MapFragment extends Fragment {


  private OnMapReadyCallback callback = new OnMapReadyCallback() {


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * In this case, we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to
     * install it inside the SupportMapFragment. This method will only be triggered once the
     * user has installed Google Play services and returned to the app.
     */
    /**
     * Sets map, map type, and kml layer plus adds start zoom.
     * @param googleMap
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

      LatLng albuquerque = new LatLng(35.08209, -106.95667);

      googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
      googleMap.addMarker(new MarkerOptions().position(albuquerque).title("Albuquerque"));
      googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(albuquerque, 7));
      try {
        KmlLayer layer = new KmlLayer(googleMap, R.raw.gmu, getContext());
        layer.addLayerToMap();
        layer.setOnFeatureClickListener((feature) -> {
          Log.d(getClass().getName(), "feature clicked" + feature.getId());
        });
      } catch (XmlPullParserException | IOException e) {
        throw new RuntimeException(e);
      }

    }
  };

  /**
   *  Inlfates map to container.
   * @param inflater
   * @param container
   * @param savedInstanceState
   * @return inflated map layout.
   */
  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_map, container, false);
  }

  /**
   * Initializes subclass.
   * @param view
   * @param savedInstanceState
   */
  @Override
  public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    SupportMapFragment mapFragment =
        (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
    if (mapFragment != null) {
      mapFragment.getMapAsync(callback);
    }
  }


}