package com.pratheeban.oop.callcenter;

class Respondent extends Employee {
    public Respondent(CallHandler callHandler) {
    	super(callHandler);
    	rank = Rank.Responder;
    }
}
