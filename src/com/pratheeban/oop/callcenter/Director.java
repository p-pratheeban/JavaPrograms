package com.pratheeban.oop.callcenter;

class Director extends Employee {
    public Director(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Director;
    }
}
