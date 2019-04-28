package com.example.converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private TextView whatever, maohao,textView3, usd, datee;
    private Button convert;
    private EditText number;
    private Spinner country2;
    private RequestQueue requestQueue;
    private double inputValue;
    private int index = 0;
    private static final String TAG = "final";
    private double rates;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestQueue = Volley.newRequestQueue(this);
        setContentView(R.layout.activity_main);
        whatever = (TextView)findViewById(R.id.whatever);
        convert = (Button)findViewById(R.id.convert);
        number = (EditText)findViewById(R.id.number);

        country2 = (Spinner)findViewById(R.id.country2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country2, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        country2.setAdapter(adapter);
        country2.setOnItemSelectedListener(this);
        textView3 = (TextView)findViewById(R.id.textView3);
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        index = position;
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    void makeApiCall(final String str) {
        try {
            String url = "https://api.exchangeratesapi.io/latest?base=USD";
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    url,
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            Log.d(TAG,response.toString());
                            try {
                                JSONObject rater = response.getJSONObject("rates");
                                rates = Double.parseDouble(rater.get(str).toString());
                            } catch (JSONException e) {
                                Log.e(TAG, "wrong");
                            }
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d(TAG,error.toString());
                        }
                    }
            );
            Log.d(TAG,"called");
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void buttonClicked(View view) {
        if ((number.getText().toString().length() > 0)) {
            String textValue = number.getText().toString();
            inputValue = Double.parseDouble(textValue);
        }
        if (index == 0) {
            makeApiCall("CAD");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 1) {
            makeApiCall("CHF");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 2) {
            makeApiCall("GBP");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 3) {
            makeApiCall("SEK");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 4) {
            makeApiCall("EUR");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 5) {
            makeApiCall("BGN");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 6) {
            makeApiCall("NZD");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 7) {
            makeApiCall("ILS");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 8) {
            makeApiCall("RUB");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 9) {
            makeApiCall("CZK");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 10) {
            makeApiCall("BRL");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
        if (index == 11) {
            makeApiCall("AUD");
            Double resultValue = inputValue * rates;
            textView3.setText("" + resultValue);
        }
    }
}