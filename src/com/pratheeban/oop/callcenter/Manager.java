package com.pratheeban.oop.callcenter;

class Manager extends Employee {
    public Manager(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Manager;
    }
}
