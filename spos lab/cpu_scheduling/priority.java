package cpu_scheduling;
import java.util.Scanner;  //Non-preemptive
public class priority 
{
    public static void main(String[] args)
    {
	    Scanner s = new Scanner(System.in);
        int x,n,p[],pp[],bt[],w[],t[],awt,atat,i; p = new int[10];
        pp = new int[10]; bt = new int[10]; w = new int[10]; t = new int[10];

 
        System.out.print("Enter the number of process : "); n = s.nextInt();
        System.out.print("\n\t Enter burst time : time priorities \n");

        for(i=0;i<n;i++)
        {
            System.out.print("\nProcess["+(i+1)+"]:");
            bt[i] = s.nextInt();
            pp[i] = s.nextInt();
            p[i]=i+1;
        }

        for(int j=i+1;j<n;j++)
        {
            if(pp[i]>pp[j])
            {
                x=pp[i]; pp[i]=pp[j]; pp[j]=x;
                x=bt[i]; bt[i]=bt[j]; bt[j]=x;
                x=p[i]; p[i]=p[j]; p[j]=x;
            }
        }
    
    w[0]=0;
    awt=0; t[0]=bt[0];
    atat=t[0]; 
    for(i=1;i<n;i++)
    {
        w[i]=t[i-1]; 
        awt+=w[i]; 
        t[i]=w[i]+bt[i]; 
        atat+=t[i];
    }


    System.out.print("\n\nProcess \t\t Burst Time \t\t Wait Time \t\t Turn Around Time	Priority \n");
    for(i=0;i<n;i++)
    {
        System.out.print("\n	"+p[i]+"\t\t	"+bt[i]+"\t\t	"+w[i]+"\t\t "+t[i]+"\t\t	"+pp[i]+"\n");
    
    }
    awt/=n; atat/=n;
    System.out.print("\n Average Wait Time : "+awt); 
    System.out.print("\n Average Turn Around Time : "+atat);
}
}

