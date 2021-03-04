package cusat.ddukk.mpad_2021_first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class AsyncActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);


        Button btnDefault = (Button)findViewById(R.id.btnStart);
        Button btnAsync = (Button)findViewById(R.id.btnAsyncStart);

        ProgressBar pbDefault = (ProgressBar)findViewById(R.id.pbDefault);
        ProgressBar pbAsync = (ProgressBar)findViewById(R.id.pbAsync);

        TextView tvDefault = (TextView)findViewById(R.id.tvDefault);
        TextView tvAsync = (TextView)findViewById(R.id.tvAsync);

        btnAsync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTask<Integer,Integer,String> asyncTask = new AsyncTask<Integer, Integer, String>() {
                    @Override
                    protected void onPreExecute() {
                        super.onPreExecute();
                        tvAsync.setText("Progress 0/100");
                    }

                    @Override
                    protected void onPostExecute(String s) {
                        super.onPostExecute(s);
                        tvAsync.setText("Execution Finished");
                    }

                    @Override
                    protected void onProgressUpdate(Integer... values) {
                        super.onProgressUpdate(values);
                        tvAsync.setText("Progress "+values[0] +"/ 100");
                    }

                    @Override
                    protected String doInBackground(Integer... integers) {
                        while(true) {
                            pbAsync.setProgress(pbAsync.getProgress() + 1);
                        if(pbAsync.getProgress()==100)
                            break;
                            setProgress(pbAsync.getProgress());
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        return null;
                    }
                };
                asyncTask.execute();
            }
        });
        Handler handler = new Handler(getMainLooper());

        btnDefault.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pbDefault.incrementProgressBy(1);;
                pbDefault.setMax(100);
                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        int i =0;
                        while(true)
                        {
                            if(pbDefault.getProgress()==100)
                                i=0;
                            pbDefault.setProgress(++i);

                            handler.post(new Runnable() {
                                @Override
                                public void run() {
                                    tvDefault.setText("Progress : "+pbDefault.getProgress()+"/ 100" );
                                }
                            });

                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                t1.start();

            }
        });

    }
}


