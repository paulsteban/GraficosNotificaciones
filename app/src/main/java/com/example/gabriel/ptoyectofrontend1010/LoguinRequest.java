package com.example.gabriel.ptoyectofrontend1010;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoguinRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL = "http://172.29.66.2:8080/log.php";
    private Map<String, String> params;

    public LoguinRequest(String username, String pass, Response.Listener<String> listener) {
        super(Method.GET, LOGIN_REQUEST_URL, listener, null);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
