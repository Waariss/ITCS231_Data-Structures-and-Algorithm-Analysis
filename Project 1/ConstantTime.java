import java.util.Scanner;
public class ConstantTime {
	public static void main(String[] args)
	{
		int balance = 1500;
		Scanner sc= new Scanner(System.in);
		System.out.print("How much to deposit: ");
		double deposit = sc.nextInt();
		System.out.println("Amount to deposit: " + deposit);
		if(deposit<=100)
		{
			System.out.println("Sorry this is too low for a deposit; try again");
			System.out.println("==============================================");
			System.out.print("How much to deposit: ");
			double deposit2 = sc.nextInt();
			sc.close();
			System.out.println("Amount to deposit: " + deposit2);
			if(deposit2<=100)
			{
				System.out.println("Please run the program again ");
				System.out.println("==============================================");
				System.exit(0);
			}
			else
			{
				System.out.println("Account balance: " + (deposit2+balance));
				System.out.println("Thank you :)");
			}
		}
		else
		{
			System.out.println("Account balance: " + (deposit+balance));
			System.out.println("Thank you :)");
		}
	}
}
