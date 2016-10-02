package com.example.saanu_mac.joketeller;

import android.os.AsyncTask;
import android.util.Log;

import com.example.saanu_mac.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by Saanu_mac on 9/28/16.
 */
public class EndPointAsyncTask extends AsyncTask<EPAsyncResponseListener, Void, String> {

    private static MyApi myApiService = null;
    public EPAsyncResponseListener listener = null;

    @Override
    protected String doInBackground(EPAsyncResponseListener... epAsyncResponseListeners) {
        if(myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://10.0.2.2:8080/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        listener = epAsyncResponseListeners[0];
        try {
            return myApiService.callMyBackend().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        //Toast.makeText(context, result, Toast.LENGTH_LONG).show();
        Log.v("MHB", "MHB the joke is  " + result);
        listener.getJokesfromEndpoint(result);
    }
}
