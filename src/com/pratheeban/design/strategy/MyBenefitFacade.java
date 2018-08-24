package com.pratheeban.design.strategy;

public class MyBenefitFacade {
	private ReadBenefitBooklet benefitBooklet;
	public void setBenefitBooklet( ReadBenefitBooklet bb){
		this.benefitBooklet = bb;
	}
	public void getBenefitBooklets() {
		benefitBooklet.getBenefitBooklet();
	}
}
