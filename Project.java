/*
 * DSA MINI PROJECT
 *
 * **EMPLOYEE MANAGEMENT SYSTEM***
 *
 * PROBLEM STATEMENT :
 * Design an application to store database of employee's using hashing data structure.
 *
 * DATA STRUCTURE USED :
 * Hash Table
 */
package Project;
import java.util.Scanner;
class Node
{
int Emp_id;
String Emp_name;
float salary;
String Emp_teleNo,Emailid;
Node next;

Node()
{
Emp_id=0;
Emp_name=" ";
Emp_teleNo="";
Emailid="";
salary=0;
next=null;
}

Node(int id,String n,String tn,String eid,float s)
{
Emp_id=id;
Emp_name=n;
Emp_teleNo=tn;
Emailid=eid;
salary=s;
        next=null;
}

}

class Hash
{
Scanner sc=new Scanner(System.in);

public Node[] hashTable=new Node[10];

Hash() //Constructor of hash class
{
for(int i=0;i<10;i++)
{
hashTable[i]=new Node(); //Initialization of hash table
hashTable[i]=null;
}
}

boolean isEmpty() //Function to check empty hash table
{
int flag=0;
for(int i=0;i<10;i++)
{
if(hashTable[i]!=null)
flag=1;
}
if(flag==0)
return true;
return false;
}

void insert(int id,String n,String tn,String eid,float salary) //Function to insert record in hash table
{
Node temp=new Node(id,n,tn,eid,salary);
int index=hashFunc(id);
if(hashTable[index]==null)
{
hashTable[index]=temp;
System.out.println("Record added successfully");
}
else
{
Node ptr=new Node();
ptr=hashTable[index];
if(ptr.Emp_id==id)
{
System.out.println("!!!!!!!COLLISION!!!!!!!"+"\n"+"CANNOT INSERT THE GIVEN EMPLOYEE ID AS THEIR IS ANOTHER RECORD ON THIS EMP_ID");
return;
}
while(ptr.next!=null)
{
/*if(ptr.Emp_id==id)
{
System.out.println("Record already exists");
return;
}*/
ptr=ptr.next;
}
ptr.next=temp;
System.out.println("Record added successfully");
}
}

void search(int id) //Function to search a record in hash table
{
int index=hashFunc(id);
Node ptr=new Node();
ptr=hashTable[index];
while(ptr!=null)
{
if(ptr.Emp_id==id)
break;
ptr=ptr.next;
}
if(ptr==null)
System.out.println("Employee database for the given Emp_id doesnot exists!!");
else
{
System.out.println("Employee id is Present!!");
System.out.println("----------------------------------------------------------------------------------------------------------------------");
System.out.println("Employee id"+" \t    "+"Employee Name"+" \t  "+"Employee MobileNo"+" \t "+"Employee Salary"+" \t "+"Employee Emailid");
System.out.println("----------------------------------------------------------------------------------------------------------------------");
System.out.println(id+" \t\t"+ptr.Emp_name+" \t\t "+ptr.Emp_teleNo+" \t\t "+ptr.salary+"\t\t"+ptr.Emailid);
System.out.println("----------------------------------------------------------------------------------------------------------------------");
}
}
public void search2(int id)    //Function for the user section to search an given employee id.
{
int index=hashFunc(id);
Node ptr=new Node();
ptr=hashTable[index];
while(ptr!=null)
{
if(ptr.Emp_id==id)
break;
ptr=ptr.next;
}
if(ptr==null)
System.out.println("Employee database for the given Emp_id doesnot exists!!");
else
{
System.out.println("Employee id is Present!!");
System.out.println("-------------------------------------------------------------------");
System.out.println("Employee id"+" \t    "+"Employee Name"+" \t  "+"Employee MobileNo");
System.out.println("-------------------------------------------------------------------");
System.out.println(id+" \t\t "+ptr.Emp_name+" \t\t "+ptr.Emp_teleNo);
System.out.println("-------------------------------------------------------------------");
}
}
public void display() //Function to display hash table
{
System.out.println("----------------------------------------------------------------------------------------------------------------------");
System.out.println("Employee id"+" \t "+"Employee Name"+"\t"+"Employee MobileNo"+" \t "+"Employee Salary"+"\t"+"Employee Emailid");
System.out.println("----------------------------------------------------------------------------------------------------------------------");
for(int i=0;i<10;i++)
{
Node ptr=new Node();
ptr=hashTable[i];
while(ptr!=null)
{
System.out.println("  "+ptr.Emp_id+" \t\t "+ptr.Emp_name+" \t\t "+ptr.Emp_teleNo+" \t\t"+ptr.salary+"\t\t"+ptr.Emailid);

ptr=ptr.next;
}

}
System.out.println("-----------------------------------------------------------------------------------------------------------------------");
}
public void display2()
{
System.out.println("----------------------------------------------------------------");
System.out.println("Employee id"+" \t "+"Employee Name"+" \t "+"Employee MobileNo");
System.out.println("-------------------------------------------------------------");
for(int i=0;i<10;i++)
{
Node ptr=new Node();
ptr=hashTable[i];
while(ptr!=null)
{
System.out.println("  "+ptr.Emp_id+" \t\t "+ptr.Emp_name+" \t\t "+ptr.Emp_teleNo);

ptr=ptr.next;
}

}
System.out.println("--------------------------------------------------------------");
}

int del(int id) //Function to delete a record from the hash table
{
int index=hashFunc(id);
if(hashTable[index]==null)
return 0;
else if(hashTable[index].Emp_id==id)  
{
if(hashTable[index].next==null)
hashTable[index]=null;
else
hashTable[index]=hashTable[index].next;
System.out.println("Record deleted successfully");
return 1;
}
else
{
Node prev=new Node();
Node ptr=new Node();
prev=hashTable[index];
ptr=prev.next;
while(ptr!=null)
{
if(ptr.Emp_id==id)
{
if(ptr.next==null)
prev.next=null;
else
prev.next=ptr.next;
System.out.println("Record deleted successfully");
return 1;
}
prev=prev.next;
ptr=ptr.next;
}
return 0;
}
}

void update(int id)            //Function to update the database of employee.
{
int index=hashFunc(id);
Node ptr=new Node();
ptr=hashTable[index];
int ch;

while(ptr!=null)
{
if(ptr.Emp_id==id)
break;
ptr=ptr.next;
}
if(ptr==null)
System.out.println("Employee database for the given Emp_id doesnot exists!!");
else
{
System.out.println("Select one which you want to update:\n1.Mobile no.\n2.Both Salary and Mobile no.\n3.Salary");
ch=sc.nextInt();
switch(ch)
{
case 1:
System.out.print("Enter Employee Mobile no.: ");
   String tn=sc.next();
   while(tn.length()!=10)
       {
           System.out.println("Invalid telephone no");
           System.out.print("Enter different telephone no : ");
           tn=sc.next();
       }
   ptr.Emp_teleNo=tn;
break;
case 2:
String username="employee";
int password=123;
String x;
int y;
System.out.print("\nOnly admin section members can update the salary\n");
System.out.print("Enter the username:");
x=sc.next();
System.out.print("Enter the password:");
y=sc.nextInt();
if(username.equals(x)&&password==y)
{
 System.out.print("Enter updated salary of the Employee:");
   float salry=sc.nextFloat();
   ptr.salary=salry;
}
   System.out.print("Enter Employee Mobile no.: ");
String mn=sc.next();
   while(mn.length()!=10)
       {
           System.out.println("Invalid telephone no");
           System.out.print("Enter different telephone no : ");
           mn=sc.next();
       }
   ptr.Emp_teleNo=mn;
break;
case 3:
String user="employee";
int pass_word=123;
String h;
int y1;
System.out.print("\nOnly admin section members can update the salary\n");
System.out.print("Enter the username:");
h=sc.next();
System.out.print("Enter the password:");
y1=sc.nextInt();
if(user.equals(h)&&pass_word==y1)
{
 System.out.print("Enter updated salary of the Employee:");
   float salry=sc.nextFloat();
   ptr.salary=salry;
}

break;
default:
System.out.println("Exited...");
break;
}


}
}
int hashFunc(int cn)
{
return cn%10;
}
}



public class Project
{
public static void main(String[] args)
{
Scanner s=new Scanner(System.in);
Hash H=new Hash();
int choice,ch,id,price;
String n;

do
{
System.out.println("\n***EMPLOYEE MANAGEMENT SYSTEM***");
System.out.println("\nLogin Via:\n1.Admin\n2.User\n3.Exit\nEnter your choice:");
choice=s.nextInt();
switch(choice)
{
case 1:       //Admin Section
String username="employee";
int password=123;
String x;
int y;
System.out.print("Enter the username:");
x=s.next();
System.out.print("Enter the password:");
y=s.nextInt();
if(username.equals(x)&&password==y)
{
System.out.println("\n**Welcome to the admin section**");
int z;
do
{
System.out.println("\nMenu:\n1.Insert/Add a new record in the system\n2.Display record");
System.out.println("3.Search a record in the database");
System.out.println("4.Delete a record from the database");
System.out.println("5.Update the existing record of an employee\n6.Exit");
System.out.print("Enter Your Choice : ");
z=s.nextInt();
switch(z)
{
case 1:
int p,a;
System.out.print("How many employees info. you want to store into the hashtable??\n");
a=s.nextInt();
//do
//{
for(int i=0;i<a;i++)
{
System.out.print("\nEnter Employee id: ");
id=s.nextInt();
System.out.print("Enter Employee name.: ");
String name=s.next();
System.out.print("Enter Employee Mobile no.: ");
   String tn=s.next();
   while(tn.length()!=10)
       {
           System.out.println("Invalid telephone no");
           System.out.print("Enter different telephone no: ");
           tn=s.next();
       }
   System.out.println("Enter Emailid of the Employee:");
   String eid=s.next();
   if(eid.indexOf("@")==-1)
{
System.out.println("enter correct emailid:");
eid=s.next();
}
   System.out.println("Enter salary of the Employee:");
   float salary=s.nextFloat();
H.insert(id,name,tn,eid,salary);
}
//System.out.print("\nDo you want to add more records? (Press  1 for YES) : ");
//p=s.nextInt();
//}while(p==1);
break;
case 2:

if(H.isEmpty())
System.out.println("Hashtable is empty");
else
H.display();
break;
case 3:
if(H.isEmpty())
System.out.println("Hashtable is empty");
else
{
System.out.print("Enter Employee id: ");
id=s.nextInt();
H.search(id);
}
break;
case 4:
if(H.isEmpty())
System.out.println("Hashtable is empty");
else
{
System.out.print("Enter Employee id: ");
id=s.nextInt();
int res=H.del(id);
if(res==0)
System.out.println("Record does not exist");
}
break;
case 5:
if(H.isEmpty())
System.out.println("Hashtable is empty");
else
{
System.out.print("Enter Employee id which you want to update: ");
id=s.nextInt();
H.update(id);
}
System.out.print("\nAfter editing,Employee database is:\n");
H.display();
break;
case 6:
System.out.println("\nYou are just EXITED from ADMIN section");
break;
}

}while(z!=6);
}
else
{
System.out.println("Incorrect username or password...");
}
break;

case 2:
System.out.println("\n**Welcome to the user section**");     //User Section
int u;
do
{
System.out.println("\nMenu:\n1.Display info of all employees\n2.Display own info. of employee\n3.Search info. of other employee\n4.Update\n5.Exit");
System.out.print("Enter Your Choice : ");
u=s.nextInt();
switch(u)
{
case 1:

if(H.isEmpty())
System.out.println("Hashtable is empty");
else
H.display2();
break;
case 2:

if(H.isEmpty())
System.out.println("Hashtable is empty");
else
{
System.out.print("Enter Employee id: ");
id=s.nextInt();

H.search(id);
}
break;
case 3:
if(H.isEmpty())
System.out.println("Hashtable is empty");
else
{
System.out.print("Enter Employee id: ");
id=s.nextInt();
H.search2(id);
}
break;
case 4:
if(H.isEmpty())
System.out.println("Hashtable is empty");
else
{
System.out.print("Enter Employee id which you want to update: ");
id=s.nextInt();
H.update(id);
}
System.out.print("\nAfter editing,Employee database is: \n");
H.display2();
break;

case 5:
System.out.println("\nYou are just EXITED from USER section");
break;
}
}while(u!=5);

break;

case 3:
System.out.println("EXITED......");
break;
}

}while(choice!=3);
}
}
/*
