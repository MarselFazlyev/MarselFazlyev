import java.util.Date;

public class Logger {
    protected int num = 1;
    private static Logger logger;

    private Logger() {
    }


    public void log(String msg) {
        System.out.println("[" + new Date() + " " + num++ + "] " + msg);
    }

    public static Logger getInstance() {
        if (logger == null) {
            return new Logger();
        }
        return logger;
    }


}
