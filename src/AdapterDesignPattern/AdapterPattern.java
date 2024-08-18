package AdapterDesignPattern;

public class AdapterPattern {

}

interface BillDesk {
	void setPaymentType(String paymentType);
	String getPaymentType();
	
	void setDetails(String data);
	String getDetails();
}

class AmazonPayment implements BillDesk{

	String paymentType = null;
	String data = null;
	@Override
	public void setPaymentType(String paymentType) {
		// TODO Auto-generated method stub
		this.paymentType = paymentType;
		
	}

	@Override
	public String getPaymentType() {
		// TODO Auto-generated method stub
		return this.paymentType;
	}

	@Override
	public void setDetails(String data) {
		// TODO Auto-generated method stub
		this.data = data;
	}

	@Override
	public String getDetails(Integer abc) {
		// TODO Auto-generated method stub
		return this.data;
	}
	
	@Override
	public String getDetails(float abc) {
		// TODO Auto-generated method stub
		return this.data;
	}
	
}

interface Paytm{
	void setTypeOfPayment(String paymentType);
	String getTypeOfPayment();
	
	void provideDetails(String data);
	String getDetails();
}
class RazorpayPaymentGatewayAdapter  {
	
	public static Paytm paytm = null;
	RazorpayPaymentGatewayAdapter(Paytm paytm) {
		this.paytm = paytm;
	}

	static Paytm convertBillDeskToPaytm() {
		return  null;
	}
	
	
}

/* Sometimes the Billdesk api gateway is not working and at that time my business is going down.So company decided to go to new payment gateway
   */
