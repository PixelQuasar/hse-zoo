package com.example.hsezoo.utils;

public final class Utils {
    private Utils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String formatValue(String value, int width) {
        if (value.length() >= width) {
            return value.substring(0, width);
        } else {
            return String.format("%-" + width + "s", value);
        }
    }

    public static String getRandomHumanName() {
        String[] names = {"Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Heidi",
                "Ivan", "Judy", "Kevin", "Linda", "Michael", "Nancy", "Oscar", "Peggy", "Quincy",
                "Rita", "Steve", "Tina", "Ursula", "Victor", "Wendy", "Xander", "Yvonne", "Zack"};

        return names[(int) (Math.random() * names.length)];
    }

    public static String getRandomJobTitle() {
        String[] jobTitles = {"Accountant", "Barista", "Carpenter", "Dentist", "Engineer", "Farmer",
                "Gardener", "Hairdresser", "Instructor", "Janitor", "Kinesiologist", "Lawyer", "Mechanic",
                "Nurse", "Optometrist", "Painter", "Quartermaster", "Receptionist", "Scientist", "Teacher",
                "Undertaker", "Veterinarian", "Waiter", "Xylophonist", "Yoga Instructor", "Zookeeper"};

        return jobTitles[(int) (Math.random() * jobTitles.length)];
    }

    public static String getRandomAnimalName() {
        String[] names = {"Snowy", "Fluffy", "Whiskers", "Buddy", "Mittens", "Paws", "Tiger", "Lion",
                "Rex", "Fido", "Rover", "Spot", "Max", "Bella", "Lucy", "Daisy", "Luna", "Lola", "Sadie",
                "Molly", "Bailey", "Maggie", "Sophie", "Chloe", "Stella", "Zoe"};

        return names[(int) (Math.random() * names.length)];
    }

    public static int getRandomInventoryId() {
        return (int)(Math.random() * 1000000);
    }

    public static int genKindnessLevel(int avg, int deviation) {
        return (int)(Math.random() * deviation + avg);
    }

    public static int getRandomHealth() {
        return 50 + (int)(Math.random() * 50); // 50 минимальный порог, я не хочу чтобы генерировались сильно больные 🥺
    }
}
