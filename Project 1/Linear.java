import java.util.Scanner;
public class Linear {
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number :");
		double num = sc.nextDouble();
		sc.close();
		System.out.println("Starting Attacking......");
		for (int i = 0; i < num; i++)
		{
		    System.out.println("Hacking Yours Computer " +i+"%");
		}
		System.out.println("...........................");
		System.out.println("Hacking Yours Computer 100%");
		System.out.println("Yours Computer Hacked Successfully :D ");
	}
}