package in.ashwanik.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by AshwaniK on 9/29/2016.
 */
public class JokeManager {
    private Random random;

    private int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }


    public String getJoke() {
        return jokes.get(randInt(0, jokes.size() - 1));
    }

    private List<String> jokes;
    private static JokeManager ourInstance = new JokeManager();

    public static JokeManager getInstance() {
        return ourInstance;
    }

    private JokeManager() {
        random = new Random();
        jokes = new ArrayList<>();
        jokes.add("Teacher asked the students to tell the most common word used by students in a classroom.\n" +
                "Suddenly a student got up and said “Can’t Sir”!\n" +
                "Brilliant! You are right, the teacher said!");
        jokes.add("Johnny asked to Sam what they will do that night.\n" +
                "Sam said “we will flip a coin”\n" +
                "Then Johnny said “If it comes head, we will go for movies. If tails, we will play cards, if it stands on edge, we will study”!");
        jokes.add("Teacher: Which one is closer, Sun or Africa?\n" +
                "Johnny: Sun\n" +
                "Teacher: Why?\n" +
                "Johnny: We can see the sun all the time, but can’t see Africa.");
    }
}
