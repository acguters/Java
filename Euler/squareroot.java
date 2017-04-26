import java.util.*;

public class squareroot
{

	public static void main(String[] args)
	{

		int[] data = new int[10001];
		int pointer = 0;
		int max = 2100000000;
		
		for(int i=2; i<max; i++){
			double numb = Math.sqrt(i);
			for(int j=2; j<=numb; j++)
			{
				int counter =0;
				if(i%2==0 || i%j==0)
				{
					break;
				}
				else if(j==Math.floor(numb))
				{
					//System.out.println(pointer);
					data[pointer]=i;
					pointer++;
				}

			}	
			//System.out.println(i);
			if(data[9998]!=0)
			{
				System.out.print(data[9998]);
				break;
			}
		}
	}
}