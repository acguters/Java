//Project Euler
//problem 19

public class sundaycount
{
	public static void main(String[] args)
	{
		final long startTime = System.nanoTime();
		int count =0;
		int day = 1;		//jan 1, 1901 == tuesday not monday
		for(int i=1901; i<=2000;i++)
		{
			for(int j=1;j<=12;j++)
			{
				if(j==1 || j==3 || j==5 || j==7|| j==8||j==10||j==12)
				{
					for(int k=1;k<=31;k++)
					{
						day++;
						if(k==1 && day==7){
							count++;}

						if(day==7)
						{
							day=0;
						}
					}	//31 days
				}

				if(j==4||j==6||j==9||j==11)
				{
					for(int k=1;k<=30;k++)
					{
						day++;
						if(k==1&&day==7){
							count++;}

						if(day==7)
						{
							day=0;
						}//30 days
					}
				}

				if((j==2 && i%4!=0) || (j==2 && i%400==0)) 
				{
					for(int k=1;k<=28;k++)
					{
						day++;
						if(k==1&&day==7){
							count++;}
						if(day==7)
						{
							day=0;
						}//28 days
					}
				}

				if(j==2 && i%4==0 && i%400!=0 )
				{
					for(int k=1;k<=29;k++)
					{
						day++;
						if(k==1&&day==7){
							count++;}
						if(day==7)
						{
							day=0;
						}//29 days
					}
				}
			}
		}
		final long endTime = System.nanoTime() - startTime;
		System.out.println(endTime);
		System.out.println(count);
	}
}