public class DynamicChangemaker {

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
            return;
        }

        try {

            String[] denominationStrings = args[0].split(",");
            int[] denominations = new int[denominationStrings.length];

            for (int i = 0; i < denominations.length; i++) {
                denominations[i] = Integer.parseInt(denominationStrings[i]);
                if (denominations[i] <= 0) {
                    System.out.println("Denominations must all be greater than zero.\n");
                    printUsage();
                    return;
                }

                for (int j = 0; j < i; j++) {
                    if (denominations[j] == denominations[i]) {
                        System.out.println("Duplicate denominations are not allowed.\n");
                        printUsage();
                        return;
                    }
                }
            }

            int amount = Integer.parseInt(args[1]);
            if (amount < 0) {
                System.out.println("Change cannot be made for negative amounts.\n");
                printUsage();
                return;
            }



            Tuple change = makeChangeWithDynamicProgramming(denominations, amount);
            if (change.isImpossible()) {
                System.out.println("It is impossible to make " + amount + " cents with those denominations.");
            } else {
                int coinTotal = change.total();
                System.out.println(amount + " cents can be made with " + coinTotal + " coin" +
                        getSimplePluralSuffix(coinTotal) + " as follows:");

                for (int i = 0; i < denominations.length; i++) {
                    int coinCount = change.getElement(i);
                    System.out.println("- "  + coinCount + " " + denominations[i] + "-cent coin" +
                            getSimplePluralSuffix(coinCount));
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Denominations and amount must all be integers.\n");
            printUsage();
        }
    }





    public static Tuple makeChangeWithDynamicProgramming(int[] denominations, int amount) {

        Tuple[][] table = new Tuple[denominations.length][amount + 1];

        //make the loops and apply the makeChangeWithDynamicProgramming
        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                table[row][column] = new Tuple(denominations.length);
                if (column > 0) {
                    if ((column - denominations[row]) >= 0 ) {
                        table[row][column].setElement(row, 1);
                        if (!table[row][column - denominations[row]].isImpossible()) {
                            table[row][column] = table[row][column].add(table[row][column - denominations[row]]);
                        } else {
                            table[row][column] = Tuple.IMPOSSIBLE;
                        }
                        /*for (int solution = 0; solution < table[row][column -  1].length(); solution ++) {
                            table[row][column] = table[row][column].add(table[row][column]);
                        } */

                    } else {
                        table[row][column] = Tuple.IMPOSSIBLE;
                    }

                    if (row > 0) {
                        if ((table[row - 1][column].total() < table[row][column].total())
                        || (table[row][column].isImpossible())) {
                            if (!table[row - 1][column].isImpossible()) {
                                table[row][column] = table[row - 1][column];
                            }
                        }
                    }
                }
                //System.out.println("Row: " + row + " Column: " + column + " Tuple: " + table[row][column].toString());
            }
        //    System.out.println(table[row].toString());
        }
        //return the last tuple in the table
        return table[denominations.length - 1][amount];
    }

    private static void printUsage() {
        System.out.println("Usage: java DynamicChangemaker <denominations> <amount>");
        System.out.println("  - <denominations> is a comma-separated list of denominations (no spaces)");
        System.out.println("  - <amount> is the amount for which to make change");
    }

    private static String getSimplePluralSuffix(int count) {
        return count == 1 ? "" : "s";
    }



}
//I needed this upload to finish my description
