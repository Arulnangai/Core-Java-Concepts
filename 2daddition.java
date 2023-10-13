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
Mat d =new Mat(r,c);
for(int i=0;i<d.r;i++)
for(int j =0;j<d.c;j++)
d.x[i][j]= x[i][j]+b.x[i][j];
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
System.out.println("Enter r & c : ");
int r = Integer.valueOf(br.readLine());
int c = Integer.valueOf(br.readLine());

Mat a = new Mat(r,c);
Mat b = new Mat(r,c);
Mat d = new Mat(r,c);
a.input();
b.input();
d = a.process(b);
d.output();

}
}