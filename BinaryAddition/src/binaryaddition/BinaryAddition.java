
package binaryaddition;
import java.util.Scanner;
import java.util.Arrays;
public class BinaryAddition 
{
    static Scanner scan = new Scanner(System.in);
    public final int[] binaryNum, binaryNum2;
    public static void main(String[] args) 
    {    
       testAddition(1);      
    }
    public BinaryAddition(int numBits)
    {
        int max = 1, min = 1, bits, integer1 = 0, integer2 = 0, i;
        for (i = 1; i < numBits; i++)
            max = max * 2;
            min = max * -1;
            max = max - 1;
            System.out.print("Enter two integers (>= -32 and <= 31): ");
            integer1 = scan.nextInt();
            integer2 = scan.nextInt();
            binaryNum = decimalToBinary(integer1, numBits, max);
            binaryNum2 = decimalToBinary(integer2, numBits, max);
            System.out.println("binary form: " + Arrays.toString(binaryNum) + 
                               " of inputInt = " + integer1);
            System.out.println("binary form: " + Arrays.toString(binaryNum2) +
                               " of inputInt2 = " + integer2);
            System.out.println("binary sum: " + Arrays.toString(addBinary()) + 
                               " = " + binaryToDecimal(addBinary()));
    }
    public static int[] decimalToBinary(int number, int numBits, int maxValue) 
    {
        int[] result = new int[numBits];
        if (number < 0)
        {
            result[0] = 1;
            number = number+maxValue+1;
        }
        int quotient = number;
        int remainder;
        int i = numBits - 1;
        do
        {
            remainder = quotient%2;
            result [i] = remainder;
            i--;
            quotient /= 2;
        }
        while (quotient > 0);
        return result;
    }
    public int[] addBinary() 
    {
        int[] binarySum = new int[binaryNum.length];
        int carry = 0, sum, i;
        for(i = binaryNum.length-1; i >= 0; i--)
        {
            sum = carry + binaryNum[i] + binaryNum2[i];
            carry = sum/2;
            binarySum[i] = sum%2;
        }
        return binarySum;
    }
    public static int binaryToDecimal(int[] binaryNum)
    {
        int sum = 0, power2 = 1, i;
        for (i = binaryNum.length-1; i >= 0; i--)
        {
            sum += binaryNum[i]*power2;
            power2 *= 2;
        }
        sum -= binaryNum[0]*power2;
        return sum;
    }
    public static void testAddition(int numTests)
    {
        System.out.print("Enter number of bits (>= 1 and <= 10): ");
        int bits = scan.nextInt();
        int[] binarySum = new int[bits];
        for(int i = 1; i < bits; i++)
        {
            BinaryAddition ba = new BinaryAddition(bits);
            ba.addBinary();
        }  
    }      
}

/*
Enter number of bits (>= 1 and <= 10): 6
Enter two integers (>= -32 and <= 31): 15 -20
binary form: [0, 0, 1, 1, 1, 1] of inputInt = 15
binary form: [1, 0, 1, 1, 0, 0] of inputInt2 = -20
binary sum: [1, 1, 1, 0, 1, 1] = -5
Enter two integers (>= -32 and <= 31): 0 15
binary form: [0, 0, 0, 0, 0, 0] of inputInt = 0
binary form: [0, 0, 1, 1, 1, 1] of inputInt2 = 15
binary sum: [0, 0, 1, 1, 1, 1] = 15
Enter two integers (>= -32 and <= 31): -32 16
binary form: [1, 0, 0, 0, 0, 0] of inputInt = -32
binary form: [0, 1, 0, 0, 0, 0] of inputInt2 = 16
binary sum: [1, 1, 0, 0, 0, 0] = -16
*/


