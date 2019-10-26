package model;

import java.util.Random;

public enum TalkTheme {
    WEATHER {
        String[] ar = {"Today is sunny weather\n", "Today is cloudy weather", "It's rainy today\n"};

        public String getMessage() {
            return ar[new Random().nextInt(3)];
        }
    }, FILMS {
        String[] ar = {"This movie is interesting\n", "This movie is boring\n", "This is the best film!"};

        public String getMessage() {
            return ar[new Random().nextInt(3)];
        }
    },
    FOOD {
        String[] ar = {"Which cake is the most delicious?", "What's for dinner today?", "Fruits and vegetables are rich in vitamins"};

        public String getMessage() {
            return ar[new Random().nextInt(3)];
        }
    }, BOOKS {
        String[] ar = {"War and Peace\n", "Crime and Punishment\n", "Eugene Onegin\n"};

        public String getMessage() {
            return ar[new Random().nextInt(3)];
        }
    };

    abstract public String getMessage();

    public static TalkTheme sample() {
        int themeIndex = new Random().nextInt(values().length);
        return values()[themeIndex];
    }
}

