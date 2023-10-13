import java.io.*;
class Mat
{
int x[][],r,c;
Mat(int r,int c)
{
this.r = r;
this.c = c;
x = new int[r][c];
}
void input()throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
for(int i=0;i<r;i++)
for(int j=0;j<c;j++)
{
System.out.println("Enter ele : ");
x[i][j] = Integer.valueOf(br.readLine());
}
}

Mat process(Mat b)
{
Mat d = new Mat(r,c);
for(int i=0;i<d.r;i++)
for(int j=0;j<d.c;j++)
for(int k=0;k<b.r;k++)
d.x[i][j] = d.x[i][j] + x[i][k] * b.x[k][j];
return d;
}
void output()
{
for(int i=0;i<r;i++)
{
for(int j=0;j<c;j++)
System.out.print(x[i][j]+"\t");
System.out.println();
}
}
}
class MatMain
{
public static void main(String arg[])throws IOException
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter r1 , c1, r2 & c2 : ");
int r1 = Integer.valueOf(br.readLine());
int c1 = Integer.valueOf(br.readLine());
int r2 = Integer.valueOf(br.readLine());
int c2 = Integer.valueOf(br.readLine());
if(c1 == r2)
{
Mat a = new Mat(r1,c1);
Mat b = new Mat(r2,c2);
Mat d = new Mat(r1,c2);
a.input();
b.input();
d= a.process(b);
d.output();
}
else
System.out.println("Mat mul not possible");
}
}