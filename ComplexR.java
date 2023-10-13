import java.util.*;

class ComplexR
{
int rp,ip;

void input()
{
Scanner sc = new Scanner (System.in);
System.out.println("Enter rp,ip: ");
rp = sc.nextInt();
ip = sc.nextInt();
}
void output()
{
if(ip>=0)
System.out.println(rp+"+"+ip+"i");
else
System.out.println(rp+" "+ip+"i");
}
ComplexR process(ComplexR b)
{
 ComplexR c = new ComplexR();
c.rp= rp+b.rp;
c.ip=ip+b.ip;
return c;
}

}

class CRMain
{
public static void main(String arg[])
{
ComplexR a = new ComplexR();
ComplexR b = new ComplexR();

a.input();
b.input();
ComplexR c = a.process(b);
c.output();

}
}