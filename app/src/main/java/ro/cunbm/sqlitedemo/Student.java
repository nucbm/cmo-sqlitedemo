package ro.cunbm.sqlitedemo;

public class Student {
    int _id;
    String _name;

    public Student(){ }

    public Student(int id, String name){
        this._id = id;
        this._name = name;
    }

    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getName(){
        return this._name;
    }

    public void setName(String name){
        this._name = name;
    }

}