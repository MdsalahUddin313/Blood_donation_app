package com.example.blooddonationapp.Auth;

class UserData_manage {
    private String UserName;
    private String Email;
    private String Password;
    private String Coursename;
    private String Blood_group;
    private String age;


    private UserData_manage(){
    }



    public UserData_manage(String UserName, String Email, String Password, String Coursename, String Blood_group, String age){

        this.UserName=UserName;
        this.Email=Email;
        this.Password=Password;
        this.Coursename=Coursename;
        this.Blood_group=Blood_group;
        this.age=age;
    }




    public String getUserName() {
        return UserName;
    }
    public String setUserName(String UserName){
        this.UserName=UserName;
        return UserName;
    }

    //

    public String getEmail() {
        return Email;
    }
    public String setEmail(String Email){
        this.Email=Email;return Email;
    }
    //
    public String getPassword() {
        return Password;
    }
    public String setPassword(String Password){
        this.Password=Password;
        return Password;
    }
    //
    public String getCoursename() {
        return Coursename;
    }
    public String setCoursename(String Coursename){
        this.Coursename=Coursename;
        return Coursename;
    }
    //


    //
    public String getAge() {
        return age;
    }
    public String setAge(String age){
        this.age=age;
        return age;
    }
    public String getBlood_group() {
        return Blood_group;
    }
    public String setBlood_group(String Blood_group){
        this.Blood_group=Blood_group;
        return Blood_group;
    }
}
