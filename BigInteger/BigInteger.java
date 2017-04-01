public class BigInteger {

    public int[] numbers;
    public boolean isPositive = true;
    /*public BigInteger() {

    } */

    public static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger ONE = new BigInteger("1");
    public static final BigInteger TEN = new BigInteger("10");

    public BigInteger() {
    }

    public BigInteger( String value ) {

        value = value.trim();
        this.numbers = new int[value.length()];
        int intValue;
        for (int k = 0; k < value.length(); k++) {
            if (value.charAt(0) == '-') {
                this.isPositive = false;
            }
            intValue = Character.getNumericValue(value.charAt(k));
            if (intValue <= 9) {
                numbers[k] = intValue;
                //System.out.println(intValue);
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    public boolean equals( Object x ) {
        if (x.getClass() == this.getClass()) {
            if (x.toString().length() != this.toString().length()) {
                return false;
            } else {
                for (int k = 0; k < x.toString().length(); k++) {
                    if (x.toString().charAt(k) != this.toString().charAt(k)) {
                        return false;
                    }
                }
            }
        return true;
        } else {
            throw new IllegalArgumentException(); //ask about this
        }
    }


    public String toString() {
        String bigNumber = "";
        Boolean zeroFilter = true;
        for (int k = 0; k < this.numbers.length; k++) {
            if (numbers[k] > 0) {
                zeroFilter = false;
            }
            if (zeroFilter == false) {
                bigNumber += Integer.toString(numbers[k]);
            }
        }
        if ((numbers[0] == 0) && (this.numbers.length == 1)) {
            bigNumber = "0";
        }

        if (this.isPositive == false) {
            return "-" + bigNumber;
        } else {
            return bigNumber;
        }
    }

    public boolean greaterThan ( BigInteger val ) {

        if ((this.isPositive == true) && (val.isPositive != true)) {
            return true;
        } else if ((this.isPositive != true) && (val.isPositive == true)) {
            return false;
        } else if ((this.isPositive == true) && (val.isPositive == true)){
            if ((this.toString().length() > val.toString().length())) {
                return true;
            } else if((this.toString().length() < val.toString().length())) {
                return false;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return true;
                    } else if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return false;
                    }
                }
                return false;
            }
        } else {
            if ((this.toString().length() < val.toString().length())) {
                return true;
            } else if((this.toString().length() > val.toString().length())) {
                return false;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return true;
                    } else if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    public boolean lessThan ( BigInteger val ) {

        if ((this.isPositive == true) && (val.isPositive != true)) {
            return false;
        } else if ((this.isPositive != true) && (val.isPositive == true)) {
            return true;
        } else if ((this.isPositive == true) && (val.isPositive == true)){
            if ((this.toString().length() > val.toString().length())) {
                return false;
            } else if((this.toString().length() < val.toString().length())) {
                return true;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return false;
                    } else if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            if ((this.toString().length() < val.toString().length())) {
                return false;
            } else if((this.toString().length() > val.toString().length())) {
                return true;
            } else {
                for (int k = 0; k < this.toString().length(); k++) {
                    if (this.toString().charAt(k) < val.toString().charAt(k)) {
                        return false;
                    } else if (this.toString().charAt(k) > val.toString().charAt(k)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

   public void fillZeroes(BigInteger big) {

       int[] placeHolder = this.numbers;

       this.numbers = new int[big.numbers.length];

       for (int k = 0; k < placeHolder.length; k++) {
           this.numbers[k] = placeHolder[k];
       }
   }

    public BigInteger plus(BigInteger val) {
        //Reverses the array
        BigInteger sum = new BigInteger();

        System.out.println(this.toString());
        System.out.println(val.toString());


        for (int k = 0; k < this.numbers.length / 2; k++) {
            int temp = this.numbers[k];
            this.numbers[k] = this.numbers[this.numbers.length - k - 1];
            this.numbers[this.numbers.length - k - 1] = temp;
        }
        for (int k = 0; k < val.numbers.length / 2; k++) {
            int temp = val.numbers[k];
            val.numbers[k] = val.numbers[val.numbers.length - k - 1];
            val.numbers[val.numbers.length - k - 1] = temp;
        }

        if (this.numbers.length > val.numbers.length) {
            val.fillZeroes(this);
        } else if (this.numbers.length < val.numbers.length) {
            this.fillZeroes(val);
        }

        System.out.println(this.toString());
        System.out.println(val.toString());


        sum.numbers = new int[this.numbers.length + 1];
        int carry;


        System.out.println(this.toString());
        System.out.println(val.toString());
        for (int k = 0; k < sum.numbers.length - 1; k++) {
            sum.numbers[k] += this.numbers[k] + val.numbers[k];
            System.out.println("Sum: "+ sum.numbers[k]);
            if (sum.numbers[k] > 9) {
                carry = sum.numbers[k] / 10;
                System.out.println("Carry: " + carry);
                sum.numbers[k] = sum.numbers[k] % 10;
                System.out.println("Sum: "+ sum.numbers[k]);

                sum.numbers[k + 1] += carry;

            }
            System.out.println(sum.toString());
        }

        for (int k = 0; k < sum.numbers.length / 2; k++) {
            int temp = sum.numbers[k];
            sum.numbers[k] = sum.numbers[sum.numbers.length - k - 1];
            sum.numbers[sum.numbers.length - k - 1] = temp;
        }

        System.out.println(sum.toString());

        return sum;
    }

    public BigInteger minus(BigInteger val) {
        //Reverses the array
        BigInteger difference = new BigInteger();

        //System.out.println(this.toString());
        //System.out.println(val.toString());


        for (int k = 0; k < this.numbers.length / 2; k++) {
            int temp = this.numbers[k];
            this.numbers[k] = this.numbers[this.numbers.length - k - 1];
            this.numbers[this.numbers.length - k - 1] = temp;
        }
        for (int k = 0; k < val.numbers.length / 2; k++) {
            int temp = val.numbers[k];
            val.numbers[k] = val.numbers[val.numbers.length - k - 1];
            val.numbers[val.numbers.length - k - 1] = temp;
        }

        if (this.numbers.length > val.numbers.length) {
            val.fillZeroes(this);
        } else if (this.numbers.length < val.numbers.length) {
            this.fillZeroes(val);
        }

        difference.numbers = new int[this.numbers.length + 1];
        int carry;

        System.out.println(this.toString());
        System.out.println(val.toString());

        for (int k = 0; k < difference.numbers.length - 1; k++) {

            if (this.numbers[k] < val.numbers[k]){
                this.numbers[k] += 10;
                this.numbers[k + 1] -= 1;
                difference.numbers[k] += (this.numbers[k] - val.numbers[k]);
            } else {
                difference.numbers[k] += (this.numbers[k] - val.numbers[k]);
            }

            System.out.println("Difference: "+ difference.numbers[k]);

        }

        for (int k = 0; k < difference.numbers.length / 2; k++) {
            int temp = difference.numbers[k];
            difference.numbers[k] = difference.numbers[difference.numbers.length - k - 1];
            difference.numbers[difference.numbers.length - k - 1] = temp;
        }

        //System.out.println(difference.toString());

        return difference;
    }




    public static void main(String args[]) {
        BigInteger bigInt = new BigInteger(args[0]);
        BigInteger test = new BigInteger(args[1]);
        System.out.println(bigInt.minus(test).toString());

    }

}
