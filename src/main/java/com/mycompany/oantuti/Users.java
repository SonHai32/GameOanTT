package com.mycompany.oantuti;

import java.io.Serializable;

public class Users implements Serializable{
    private String name;
    private String inClass;

    public Users(String name, String inClass){
        this.name = name;
        this.inClass = inClass;
    }

    public String getName(){
        return this.name;
    }

    public String getInClass(){
        return this.inClass;
    }
    
}