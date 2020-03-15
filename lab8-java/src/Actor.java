import java.util.concurrent.Executor;

class Actor {

    private static String name = "Timothee Chalamet";

    static class Printer implements Executor{

        @Override
        public void execute(Runnable command) {

        }
    }

}
