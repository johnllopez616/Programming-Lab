public class FibonacciTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Fibonacci();

        System.out.println("-----OVERALL PERFORMANCE-----");
        System.out.println(successes + "/" + attempts + " tests passed.");
    }

    private static void displaySuccessIfTrue(boolean value) {
        attempts++;
        successes += value ? 1 : 0;

        System.out.println(value ? "success" : "failure");
    }

    private static void displayUnimplementedMethodFailure() {
        attempts++;
        System.out.println("failure (NYI)");
    }

    private static void test_Fibonacci() {
        System.out.println("Testing constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue("0".equals(Fibonacci.fib(00).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("1".equals(Fibonacci.fib(1).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue("55".equals(Fibonacci.fib(10).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!"0".equals(Fibonacci.fib('a').toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("Fibonacci: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

}
