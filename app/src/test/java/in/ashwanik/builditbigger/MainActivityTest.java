package in.ashwanik.builditbigger;

import android.test.AndroidTestCase;

import java.util.concurrent.TimeUnit;

/**
 * Created by AshwaniK on 9/29/2016.
 */

public class MainActivityTest extends AndroidTestCase {

    public void testAsyncTask(){
        try {
            JokeAsyncTask jokeTask = new JokeAsyncTask(new TaskHandler() {
                @Override
                public void onComplete(String data) {

                }
            });
            jokeTask.execute();
            jokeTask.get(60, TimeUnit.SECONDS);
        } catch (Exception e){
            fail("Timed out");
        }
    }
}