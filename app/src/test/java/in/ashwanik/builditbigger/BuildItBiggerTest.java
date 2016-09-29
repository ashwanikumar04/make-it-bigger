package in.ashwanik.builditbigger;

import android.test.InstrumentationTestCase;
import android.text.TextUtils;

import java.util.concurrent.CountDownLatch;

/**
 * Created by AshwaniK on 9/29/2016.
 */
//Referenced from http://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
public class BuildItBiggerTest extends InstrumentationTestCase {

    String joke = null;

    public BuildItBiggerTest() {
    }

    @Override
    protected void setUp() throws Exception {
    }

    @Override
    protected void tearDown() throws Exception {
    }

    public void testJokeTask() throws Throwable {
        final CountDownLatch signal = new CountDownLatch(1);
        final JokeAsyncTask asyncTask = new JokeAsyncTask(new TaskHandler() {
            @Override
            public void onComplete(String data) {
                joke = data;
                signal.countDown();
            }
        });

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                asyncTask.execute();
            }
        });

        signal.await();
        assertTrue(TextUtils.isEmpty(joke));
    }


}
