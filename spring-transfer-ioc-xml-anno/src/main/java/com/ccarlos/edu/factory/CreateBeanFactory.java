package com.ccarlos.edu.factory;


import com.ccarlos.edu.utils.ConnectionUtils;

public class CreateBeanFactory {



    public static ConnectionUtils getInstanceStatic() {
        return new ConnectionUtils();
    }


    public ConnectionUtils getInstance() {
        return new ConnectionUtils();
    }
}
