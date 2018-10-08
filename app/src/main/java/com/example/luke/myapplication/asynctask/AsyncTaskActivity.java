package com.example.luke.myapplication.asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.luke.myapplication.R;

public class AsyncTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        new CallApiByAsyncTask().execute(20,30,40);
    }


    private class CallApiByAsyncTask extends AsyncTask<Integer, String, String> {

        @Override
        protected String doInBackground(Integer... numbers) {
            System.out.println("FirtsNum :" + numbers[0]);
            System.out.println("SecondNum :" + numbers[1]);
            System.out.println("ThridNum :" + numbers[2]);
            System.out.println(Thread.currentThread().getId());

            return "Async Task Success";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            System.out.println(s);
        }
    }
}
