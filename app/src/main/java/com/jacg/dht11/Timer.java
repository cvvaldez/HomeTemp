package com.jacg.dht11;

import android.os.AsyncTask;
import android.widget.TextView;

/*
public class Timer extends AsyncTask<URL, Integer, Long> {
    protected Long doInBackground(URL... urls) {
        int count = urls.length;
        long totalSize = 0;
        for (int i = 0; i < count; i++) {
            totalSize += Downloader.downloadFile(urls[i]);
            publishProgress((int) ((i / (float) count) * 100));
            // Escape early if cancel() is called
            if (isCancelled()) break;
        }
        return totalSize;
    }

    protected void onProgressUpdate(Integer... progress) {
        setProgressPercent(progress[0]);
    }

    protected void onPostExecute(Long result) {
        showDialog("Downloaded " + result + " bytes");
    }
}*/
/*
public class Timer extends AsyncTask<Void, Integer, Long> {

    protected Long doInBackground() {
        int count = 0;
        long [] temps= {24,24,24,32,24,24,24,13,24,24};
        long totalSize = 0;

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            publishProgress(temps[i]);
        }
        return totalSize;
    }
    protected void onProgressUpdate(Integer newTemp) {
        ((TextView) findViewById(R.id.sensetemp)).setText(newTemp);
    }

    protected void onPostExecute(Long result) {
        //showDialog("Downloaded " + result + " bytes");
    }
}
*/