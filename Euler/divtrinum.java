//problem 12

public class divtrinum
{
	public static void main(String[] args)
	{
		int counter = 0;
		int finCount = 0;
		long num = 2;
		while(finCount!=250)
		{
			int divCount =0;
			num += counter;
			for(long i=0; i<Math.floor(Math.sqrt(num));i++)
			{
				if(i!=0 && num%i==0)
				{
					divCount++;
					//System.out.print(divCount);
				} 
				if(divCount==250)
				{
					finCount= divCount;
					System.out.println(finCount);
					break;
				}
			}
			counter++;
		}
		System.out.print(num);
	}
}

// double numb = Math.sqrt(i)
//Math.floor(numb)