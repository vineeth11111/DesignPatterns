package FactoryDesignPattern;

public class FactoryPatternExample {
	public static void main(String[] args) {
		FactoryPattern  factoryPattern = new FactoryPattern();
		Notification sendNotification = factoryPattern.sendNotification("SMS");
		sendNotification.sendMsg();
	}
}

interface Notification {
	void sendMsg();
}

class FactoryPattern {
	
	public Notification sendNotification(String through) {
		
		if("EMAIL".equalsIgnoreCase(through)) {
			return new EmailNotification();
		}
		if("SMS".equalsIgnoreCase(through)) {
			return new SMSNotification();
		}
		if("PUSH".equalsIgnoreCase(through)) {
			return new PushNotification();
		}
		
		return null;
		
	}
}
class SMSNotification implements Notification {

	@Override
	public void sendMsg() {
		System.out.println("SMS Notifiaction .. ");
		
	}
	
}

class EmailNotification implements Notification {

	@Override
	public void sendMsg() {
		System.out.println("Email Notifiaction .. ");
		
	}
	
}

//Sending msgs through apps like amazon, swiggy, etc.
class PushNotification implements Notification {

	@Override
	public void sendMsg() {
		System.out.println("Push Notifiaction .. ");
		
	}
	
}