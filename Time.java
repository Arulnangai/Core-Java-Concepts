import java.util.*;

class Time
{
int h,m,s;

void input()
{
Scanner sc = new Scanner (System.in);
System.out.println("Enter h,m,s: ");
h = sc.nextInt();
m = sc.nextInt();
s = sc.nextInt();
}
void output()
{
System.out.println(h+":"+m+":"+s);
}
Time process(Time a,Time b)
{
 Time c = new Time();
h = a.h+b.h;
m= a.m+b.m;
s=a.s+b.s;
m=m+s/60;
s=s%60;
h=h+m/60;
m=m%60;

return c;
}

}

class TMain
{
public static void main(String arg[])
{
Time a = new Time();
Time b = new Time();
Time c = new Time();

a.input();
b.input();
c.process(a,b);
c.output();

}
}