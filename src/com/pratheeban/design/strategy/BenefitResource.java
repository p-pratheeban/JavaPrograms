package com.pratheeban.design.strategy;

public class BenefitResource {
	private MyBenefitFacade benefitFacade;
	public void getBenefitBooklets(String brand) {
		if(brand.equals("IBC")) {
			benefitFacade.setBenefitBooklet(new MedicaidBB());
		}else {
			benefitFacade.setBenefitBooklet(new MedicareBB());
		}
		benefitFacade.getBenefitBooklets();
	}
}
