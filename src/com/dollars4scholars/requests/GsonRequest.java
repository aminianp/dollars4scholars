package com.dollars4scholars.requests;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

/**
 * Volley adapter for JSON requests that will be parsed into Java objects by Gson.
 */
public class GsonRequest<T> extends Request<T> {

	private static final String TAG = GsonRequest.class.getSimpleName();

	private static final String PROTOCOL_CHARSET = "utf-8";
	private static final String APPLICATION_JSON = "application/json";
	private static final String PROTOCOL_CONTENT_TYPE = String.format("%s; charset=%s", APPLICATION_JSON, PROTOCOL_CHARSET);

	private final Gson gson;
	private final Class<T> clazz;
	private final Listener<T> listener;
	private final Object body;

	private static final Map<String, String> headers;
	static {
		headers = new HashMap<String, String>(1);
		headers.put("Accept", APPLICATION_JSON);
	}

	/**
	 * Make a GET request and return a parsed object from JSON.
	 * 
	 * @param url
	 *            URL of the request to make
	 * @param clazz
	 *            Relevant class object, for Gson's reflection
	 * @param headers
	 *            Map of request headers
	 */
	public GsonRequest(String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener) {
		super(Method.GET, url, errorListener);
		this.clazz = clazz;
		this.listener = listener;
		this.body = null;
		this.gson = new Gson();
	}

	/**
	 * This creates a POST request.
	 */
	public GsonRequest(String url, Class<T> clazz, Object body, Listener<T> listener, ErrorListener errorListener) {
		super(Method.POST, url, errorListener);
		this.clazz = clazz;
		this.listener = listener;
		this.body = body;
		this.gson = new Gson();
	}

	public GsonRequest(String url, Class<T> clazz, Listener<T> listener, ErrorListener errorListener, Gson gson) {
		super(Method.GET, url, errorListener);
		this.clazz = clazz;
		this.listener = listener;
		this.body = null;
		this.gson = gson;
	}

	/**
	 * This creates a POST request.
	 */
	public GsonRequest(String url, Class<T> clazz, Object body, Listener<T> listener, ErrorListener errorListener, Gson gson) {
		super(Method.POST, url, errorListener);
		this.clazz = clazz;
		this.listener = listener;
		this.body = body;
		this.gson = gson;
	}

	@Override
	protected void deliverResponse(T response) {
		listener.onResponse(response);
	}

	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		String json;
		try {
			json = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
		} catch (UnsupportedEncodingException e) {
			ParseError error = new ParseError(e);
			return Response.error(error);
		}

		try {
			return Response.success(gson.fromJson(json, clazz), HttpHeaderParser.parseCacheHeaders(response));
		} catch (JsonSyntaxException e) {
			Log.e(TAG, String.format("json: %s", json));
			return Response.error(new ParseError(e));
		}
	}

	@Override
	public Map<String, String> getHeaders() {
		return headers;
	}

	@Override
	public String getBodyContentType() {
		return PROTOCOL_CONTENT_TYPE;
	}

	@Override
	public byte[] getBody() {
		String json = gson.toJson(body);
		try {
			return json == null ? null : json.getBytes(PROTOCOL_CHARSET);
		} catch (UnsupportedEncodingException uee) {
			VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", json, PROTOCOL_CHARSET);
			return null;
		}
	}

}