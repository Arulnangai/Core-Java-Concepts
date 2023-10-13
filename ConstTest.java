import java.util.*;
class Constructors 
{
int a,b;

Constructors()
{
a=10;
b=20;
}

Constructors (int a,int b )
{
this.a = a;
this.b=b;
}
Constructors (Constructors e)
{
a=e.a;
b=e.b;
}

void output()
{
System.out.println(a+"\t"+b);
}
}

class ConTest
{
public static void main(String ... arg)
{
Scanner sc = new Scanner(System.in);
Constructors e1 = new Constructors();
Constructors e2 = new Constructors();
System.out.println("Enter a,b: ");
int a = sc.nextInt();
int b = sc.nextInt();
Constructors e3 = new Constructors(a,b);
System.out.println("Enter a,b: ");
a = sc.nextInt();
b = sc.nextInt();
Constructors e4 = new Constructors(a,b);
Constructors e5 = new Constructors(e3);
e1.output();
e2.output();
e3.output();
e4.output();
e5.output();
}
}