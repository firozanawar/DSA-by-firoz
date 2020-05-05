package Numbers;

public class BinaryConversion {

    public static void main(String[] args) {
        System.out.println(convertingIntegerToBinary(19));
        System.out.println(retrieveDecimal(10011));
    }

    private static String convertingIntegerToBinary(int number){
        String x = "";
        while(number > 0)
        {
            //System.out.println("number: "+number);
            int a = number % 2;
            //System.out.println("a: "+a);
            x = a + x;
            number = number / 2;
        }
        return x;
    }

    public static int retrieveDecimal(int binarynumber){
        int decimalnumber = 0;
        int power = 0;
        while(true)
        {
            if (binarynumber == 0)
            {
                break;
            }
            else
            {
                int temp = binarynumber%10;
                decimalnumber += temp*Math.pow(2, power);
                binarynumber = binarynumber/10;
                power++;
            }
        }
        return decimalnumber;
    }
}
