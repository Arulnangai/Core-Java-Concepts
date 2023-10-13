import java.util.*;

class TExam
{
int a,b;
static int c;

void input()
{

Scanner sc = new Scanner(System.in);
System.out.println("Enter a,b,c:");
a=sc.nextInt();
b=sc.nextInt();
c=sc.nextInt();

}
 void output()
{
System.out.println(a+"\t"+b+"\t"+c);
}

static void disp()
{
System.out.println(c);
}
}

class TEMain

{
public static void main(String arg[])
{
TExam e1 = new TExam();
e1.input();
TExam e2 = new TExam();
e2.input();
TExam e3 = new TExam();
e1.output();
e2.output();
e3.output();
TExam.disp();
} 
}