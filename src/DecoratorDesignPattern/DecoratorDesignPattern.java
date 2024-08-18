package DecoratorDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DecoratorDesignPattern {

	public static final String BASIC_PLAN = "Basic plan can help you with upto 50 lakhs";
	public static final String ACCIDENTIAL_BENEFIT = " Extra Accidential Benefit of upto 10 lakhs";
	public static final String CRITICAL_ILLENESS_BENEFIT = "Extra Critical Benefit of upto 10 lakhs";
	
	public static final Double BASIC_PLAN_PRICE = 1566.0;
	public static final Double ACCIDENTIAL_BENEFIT_PRICE = 54.0;
	public static final Double CRITICAL_ILLENESS_PLAN_PRICE = 46.5;
	
	
	
	public static void main(String[] args) {
		Plan customer1 = new BasicPlan();
		System.out.println("Monthly Plan Price is : "+customer1.getPlanPrice());
		System.out.println("Plan Details is : "+customer1.getPlanDetails());
		
		Plan customer2 = new BasicPlan();
		System.out.println("Monthly Plan Price is : "+customer2.getPlanPrice());
		System.out.println("Plan Details is : "+customer2.getPlanDetails());
		
		 customer2 = new AccidentialBenefit(customer2);
		System.out.println("Monthly Plan Price is : "+customer2.getPlanPrice());
		System.out.println("Plan Details is : "+customer2.getPlanDetails());
		
		customer2 = new CriticalBenefit(customer2);
		System.out.println("Monthly Plan Price is : "+customer2.getPlanPrice());
		System.out.println("Plan Details is : "+customer2.getPlanDetails());
	}
}

interface Plan {
	Double getPlanPrice();
	List<String> getPlanDetails();
}

class BasicPlan implements Plan {

	@Override
	public Double getPlanPrice() {
		// TODO Auto-generated method stub
		return DecoratorDesignPattern.BASIC_PLAN_PRICE;
	}

	@Override
	public List<String> getPlanDetails() {
		// TODO Auto-generated method stub
		List<String> planDetails = new ArrayList<>();
		planDetails.add(DecoratorDesignPattern.BASIC_PLAN);
		return planDetails;
	}
	
}

abstract class PolicyDecorator extends BasicPlan {
	Plan basicPlan;
	PolicyDecorator(Plan basicPlan) {
		this.basicPlan = basicPlan;
	}
	PolicyDecorator() {
		
	}
	@Override
	public Double getPlanPrice() { //List of policies 1) Basic  2) Accidential
		// TODO Auto-generated method stub
		return basicPlan.getPlanPrice();
	}

	@Override
	public List<String> getPlanDetails() {
		// TODO Auto-generated method stub
		return basicPlan.getPlanDetails();
	}
}

class AccidentialBenefit extends PolicyDecorator {

	AccidentialBenefit(Plan basicPlan) {
		super(basicPlan);
		// TODO Auto-generated constructor stub
	}	
		@Override
		public Double getPlanPrice() {
			// TODO Auto-generated method stub
			return super.getPlanPrice() + DecoratorDesignPattern.ACCIDENTIAL_BENEFIT_PRICE;
		}

		@Override
		public List<String> getPlanDetails() {
			// TODO Auto-generated method stub
			List<String> planDetails = new ArrayList<>();
			planDetails.addAll(super.getPlanDetails());
			planDetails.add(DecoratorDesignPattern.ACCIDENTIAL_BENEFIT);
			return planDetails;
		}
	
	
}

class CriticalBenefit extends PolicyDecorator {

	CriticalBenefit(Plan basicPlan) {
		super(basicPlan);
		// TODO Auto-generated constructor stub
	}	
		@Override
		public Double getPlanPrice() {
			// TODO Auto-generated method stub
			return super.getPlanPrice() + DecoratorDesignPattern.CRITICAL_ILLENESS_PLAN_PRICE;
		}

		@Override
		public List<String> getPlanDetails() {
			// TODO Auto-generated method stub
			List<String> planDetails = new ArrayList<>();
			planDetails.addAll(super.getPlanDetails());
			planDetails.add(DecoratorDesignPattern.CRITICAL_ILLENESS_BENEFIT);
			return planDetails;
		}
	
	
}
