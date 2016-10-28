package my.example.volleyapp2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by rjirwanshah on 28/10/2016.
 */

public class RestAPIFragment extends Fragment {

    private TextView mTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.rest_api_container , container, false);

        mTextView = (TextView) rootView.findViewById(R.id.main_container);

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        
        getRestAPIData();
    }

    private void getRestAPIData() {

        // Prepare URL
        String url = null;
        url = "https://jsonplaceholder.typicode.com/posts/1";

        // Prepare a requestQueue
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());

        // Request a string response from the provided URL
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mTextView.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mTextView.setText(error.toString());
            }
        });

        requestQueue.add(stringRequest);
    }
}
