class Logger {
    private static Logger instance;

    private Logger() {
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }
}

public class SingletonPatternExample {
    public static void main(String[] args) {
        Logger firstLogger = Logger.getInstance();
        Logger secondLogger = Logger.getInstance();

        if (firstLogger == secondLogger) {
            System.out.println("Both references point to the same Logger instance.");
        } else {
            System.out.println("References point to different Logger instances.");
        }
    }
}