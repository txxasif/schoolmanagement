/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schoolmanagenent;

/**
 *
 * @author Asif
 */
public class Teacher {
   public String name;
   public String age;
   public String date;
   public String group;
   public String number;
   public String religion;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getDate() {
        return date;
    }

    public String getGroup() {
        return group;
    }

    public String getNumber() {
        return number;
    }

    public String getReligion() {
        return religion;
    }

    

    public Teacher(String name, String age, String date, String group, String number, String religion) {
        this.name = name;
        this.age = age;
        this.date = date;
        this.group = group;
        this.number = number;
        this.religion = religion;
    }

   
}
