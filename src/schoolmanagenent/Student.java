
package schoolmanagenent;

public class Student {
String name;
String gender;
String group;
String clas;
String id;
String number;
String pumber;
String Date;
String email;
String password;
public String r1 = "0.0";
public String r2 = "0.0";
public String r3 = "0.0";
public String r4 = "0.0";
public String r5 = "0.0";
public String r6 = "0.0";
public String r7 = "0.0";
public String r8 = "0.0";
public String r9 = "0.0";
public String r10 = "0.0";
public String r11= "0.0";
public String r12= "0.0";
public String r13 = "0.0";
public String r14 = "0.0";
public String r15 = "0.0";
public String r16= "0.0";


    public Student(String name, String gender,String date, String group, String clas, String id, String number, String pumber,String user,String pass) {
        this.name = name;
        this.gender = gender;
        this.Date = date;
        this.group = group;
        this.clas = clas;
        this.id = id;
        this.number = number;
        this.pumber = pumber;
        this.email = user;
        this.password = pass;
    }
    public void setMid(String a,String b,String c,String d,String e,String f,String g,String h){
       this.r1 = a;
       this.r2 = b;
       this.r3 = c;
       this.r4 = d;
       this.r5 = e;
       this.r6 = f;
       this.r7 = g;
       this.r8 = h;
       
   }
   
   public void setFinal(String a,String b,String c,String d,String e,String f,String g,String h){
       this.r9 = a;
       this.r10 = b;
       this.r11 = c;
       this.r12 = d;
       this.r13 = e;
       this.r14 = f;
       this.r15 = g;
       this.r16 = h;
       
   }

    public void setPassword(String password) {
        this.password = password;
    }
   

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getGroup() {
        return group;
    }

    public String getClas() {
        return clas;
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getPumber() {
        return pumber;
    }

    public String getDate() {
        return Date;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
    

   


}