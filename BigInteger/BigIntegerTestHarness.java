public class BigIntegerTestHarness {

    private static int attempts = 0;
    private static int successes = 0;

    public static void main(String[] args) {
        attempts = 0;
        successes = 0;

        test_Constructor();
        test_toString();
        test_constants();
        test_Equals();
        test_Plus();
        test_greaterThan();
        test_lessThan();
       // test_valueOf();
        test_Minus();
        //   test_Times
        //   test_IntegerDivision
        //   test_Remainder

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

    private static void test_Constructor() {
        System.out.println("Testing constructors...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue("1".equals(new BigInteger("1 ").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("1".equals(new BigInteger("  +1").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-1".equals(new BigInteger("-1  ").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInteger("0").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("314159265358979323846264338327950288"
                    .equals(new BigInteger("314159265358979323846264338327950288").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("314159265358979323846264338327950288"
                    .equals(new BigInteger("+314159265358979323846264338327950288").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("-314159265358979323846264338327950288"
                    .equals(new BigInteger("-314159265358979323846264338327950288").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            new BigInteger("a");
            displaySuccessIfTrue(false);
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(true);
        }

        System.out.println("constructors: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_toString() {
        System.out.println("Testing toString...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue("9234013274012419836418634983459547689126439817263478157836453178654"
                    .equals(new BigInteger("9234013274012419836418634983459547689126439817263478157836453178654").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("123456789123456789"
                    .equals(new BigInteger("123456789123456789").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("123456789123456789"
                    .equals(new BigInteger("000123456789123456789").toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("toString: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }

    private static void test_Equals() {
        System.out.println("Testing equals...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("123456789123456789")
                    .equals(new BigInteger("123456789123456789")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new BigInteger("123456789123456789")
                    .equals(new BigInteger("333"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new BigInteger("123456789123456789")
                    .equals(new BigInteger("-123456789123456789"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("123456789123456789")
                    .equals(new BigInteger("000123456789123456789")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("equals: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_constants() {
        System.out.println("Testing ZERO, ONE, and TEN constants...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(BigInteger.ZERO.equals(new BigInteger("0")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInteger.ONE.equals(new BigInteger("1")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(BigInteger.TEN.equals(new BigInteger("10")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("constants: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_Minus() {
        System.out.println("Testing minus...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("0").minus(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1").equals(new BigInteger("0").minus(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("1").minus(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("2").equals(new BigInteger("2").minus(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("1").minus(new BigInteger("1001"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-999").equals(new BigInteger("-876").minus(new BigInteger("123"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("-123").minus(new BigInteger("877"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("+3000").minus(new BigInteger("+4000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("-4000").minus(new BigInteger("-3000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("+1").minus(new BigInteger("+1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("-1").minus(new BigInteger("-1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("+11").minus(new BigInteger("+1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("+12").minus(new BigInteger("2"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x = new BigInteger("+12354");
            displaySuccessIfTrue(new BigInteger("0").equals(x.minus(x)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue((new java.math.BigInteger("123456789123456789")).toString()
                    .equals(new BigInteger("123456789123456789").minus(new BigInteger("0")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInteger("-123456789123456789")
                    .minus(new BigInteger("-123456789123456789")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("Minus: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_Plus() {
        System.out.println("Testing plus...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("0").plus(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("0").plus(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1").equals(new BigInteger("1").plus(new BigInteger("0"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("2").equals(new BigInteger("1").plus(new BigInteger("1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(new BigInteger("1").plus(new BigInteger("999"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("1000").equals(new BigInteger("123").plus(new BigInteger("877"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-999").equals(new BigInteger("-123").plus(new BigInteger("-876"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("-123").plus(new BigInteger("-877"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("+3000").plus(new BigInteger("-4000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-1000").equals(new BigInteger("-4000").plus(new BigInteger("+3000"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("-1").plus(new BigInteger("+1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("0").equals(new BigInteger("+1").plus(new BigInteger("-1"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("-1").plus(new BigInteger("+11"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("10").equals(new BigInteger("+12").plus(new BigInteger("-2"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            BigInteger x = new BigInteger("+12354");
            displaySuccessIfTrue(new BigInteger("24708").equals(x.plus(x)));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue((new java.math.BigInteger("123456789123456789")).toString()
                    .equals(new BigInteger("123456789123456789").plus(new BigInteger("0")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue("0".equals(new BigInteger("123456789123456789")
                    .plus(new BigInteger("-123456789123456789")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("2934097831972391728347612783641927841983569834695")
                    .add(new java.math.BigInteger("9234013274012419836418634983459547689126439817263478157836453178654"));
            displaySuccessIfTrue(expected.toString().equals(new BigInteger("2934097831972391728347612783641927841983569834695")
                    .plus(new BigInteger("9234013274012419836418634983459547689126439817263478157836453178654")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("000123456789123456789")
                    .add(new java.math.BigInteger("000123456789123456789"));
            displaySuccessIfTrue(expected.toString().equals(new BigInteger("000123456789123456789")
                    .plus(new BigInteger("000123456789123456789")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            java.math.BigInteger expected = new java.math.BigInteger("888888888888888888")
                    .add(new java.math.BigInteger("-999999999999999999"));
            displaySuccessIfTrue(expected.toString().equals(new BigInteger("888888888888888888")
                    .plus(new BigInteger("-999999999999999999")).toString()));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        System.out.println("plus: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }


private static void test_greaterThan() {
    System.out.println("Testing Greater Than...");

    int initialSuccesses = successes;
    int initialAttempts = attempts;

    try {
        displaySuccessIfTrue(new BigInteger("123456789123456790")
                .greaterThan(new BigInteger("123456789123456789")));
    } catch (UnsupportedOperationException uoe) {
        displayUnimplementedMethodFailure();
    } catch(Exception e) {
        displaySuccessIfTrue(false);
    }

    try {
        displaySuccessIfTrue(!(new BigInteger("123456789123456789")
                .greaterThan(new BigInteger("123456789123456789"))));
    } catch (UnsupportedOperationException uoe) {
        displayUnimplementedMethodFailure();
    } catch(Exception e) {
        displaySuccessIfTrue(false);
    }

    try {
        displaySuccessIfTrue((new BigInteger("123456789123456789")
                .greaterThan(new BigInteger("-123456789123456789"))));
    } catch (UnsupportedOperationException uoe) {
        displayUnimplementedMethodFailure();
    } catch(Exception e) {
        displaySuccessIfTrue(false);
    }

    try {
        displaySuccessIfTrue(new BigInteger("123456789123456790")
                .greaterThan(new BigInteger("000123456789123456789")));
    } catch (UnsupportedOperationException uoe) {
        displayUnimplementedMethodFailure();
    } catch(Exception e) {
        displaySuccessIfTrue(false);
    }

    try {
        displaySuccessIfTrue(!(new BigInteger("-123456789123456789")
                .greaterThan(new BigInteger("123456789123456789"))));
    } catch (UnsupportedOperationException uoe) {
        displayUnimplementedMethodFailure();
    } catch(Exception e) {
        displaySuccessIfTrue(false);
    }

    try {
        displaySuccessIfTrue(!(new BigInteger("-123456789123456789")
                .greaterThan(new BigInteger("123456789123456790"))));
    } catch (UnsupportedOperationException uoe) {
        displayUnimplementedMethodFailure();
    } catch(Exception e) {
        displaySuccessIfTrue(false);
    }
    try {
        displaySuccessIfTrue(!(new BigInteger("-123456789123456789")
                .greaterThan(new BigInteger("-123456789123456789"))));
    } catch (UnsupportedOperationException uoe) {
        displayUnimplementedMethodFailure();
    } catch(Exception e) {
        displaySuccessIfTrue(false);
    }



    System.out.println("greater than: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

    }

    private static void test_lessThan() {
        System.out.println("Testing Less Than...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            displaySuccessIfTrue(!(new BigInteger("123456789123456790")
                    .lessThan(new BigInteger("123456789123456789"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(!(new BigInteger("123456789123456789")
                    .lessThan(new BigInteger("123456789123456789"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-123456789123456789")
                    .lessThan(new BigInteger("123456789123456789")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            displaySuccessIfTrue(!(new BigInteger("-123456789123456789")
                    .lessThan(new BigInteger("-123456789123456789"))));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("123456789123456789")
                    .lessThan(new BigInteger("000123456789123456790")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-123456789123456790")
                    .lessThan(new BigInteger("123456789123456789")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            displaySuccessIfTrue(new BigInteger("-123456789123456791")
                    .lessThan(new BigInteger("-123456789123456790")));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }



        System.out.println("less than: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");

        }
    private static void test_valueOf() {
        System.out.println("Testing value of...");

        int initialSuccesses = successes;
        int initialAttempts = attempts;

        try {
            long test = 1;
            BigInteger testOf = new BigInteger(BigInteger.valueOf(test).toString());
            displaySuccessIfTrue("1".equals(new BigInteger(testOf.toString())));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }

        try {
            long test = -1;
            BigInteger testOf = new BigInteger(BigInteger.valueOf(test).toString());
            displaySuccessIfTrue("-1".equals(new BigInteger(testOf.toString())));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            long test = 0;
            BigInteger testOf = new BigInteger(BigInteger.valueOf(test).toString());
            displaySuccessIfTrue("0".equals(new BigInteger(testOf.toString())));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            long test = 123456789;
            BigInteger testOf = new BigInteger(BigInteger.valueOf(test).toString());
            displaySuccessIfTrue("123456789".equals(new BigInteger(testOf.toString())));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }
        try {
            long test = -123456789;
            BigInteger testOf = new BigInteger(BigInteger.valueOf(test).toString());
            displaySuccessIfTrue("-123456789".equals(new BigInteger(testOf.toString())));
        } catch (UnsupportedOperationException uoe) {
            displayUnimplementedMethodFailure();
        } catch(Exception e) {
            displaySuccessIfTrue(false);
        }


        System.out.println("ValueOf: " + (successes - initialSuccesses) + "/" + (attempts - initialAttempts) + " passed");
    }


}
