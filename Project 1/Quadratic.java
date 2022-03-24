import java.util.Scanner;
public class Quadratic {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number :");
		double num = sc.nextDouble();
		sc.close();
		System.out.println("Printing Half-triangle ......");
		for(int i=0; i < num; i++) 
		{ 
			for(int j =0 ;j<=i;j++)
			{
				System.out.print("* ");
			}
		System.out.println();
		}
	System.out.println("Half-triangle Successfully");
	}
}
