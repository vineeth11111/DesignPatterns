package BuilderDesignPattern;

public class User {

	private String id;
	private String password;
	private String name;
	private String email;
	private String address;
	
	public User(UserBuilder builder) {
		this.id = builder.getId();
		this.password = builder.getPassword();
		this.name = builder.getName();
		this.email = builder.getEmail();
		this.address = builder.getAddress();
	}
	
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getAddress() {
		return address;
	}
	
	
	static class UserBuilder {
		
		public UserBuilder() {
			
		}
		
		private String id;
		private String password;
		private String name;
		private String email;
		private String address;
		
		public UserBuilder id(String id) {
			this.id = id;
			return this;
		}
		
		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}
		
		public UserBuilder name(String name) {
			this.name = name;
			return this;
		}
		
		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}
		
		public UserBuilder address(String address) {
			this.address = address;
			return this;
		}
		
		public String getId() {
			return this.id;
		}
		public String getName() {
			return this.name;
		}
		public String getPassword() {
			return this.password;
		}
		public String getEmail() {
			return this.email;
		}
		public String getAddress() {
			return this.address;
		}
		
		public User build() {
			User user = new User(this);
			return user;
		}
	}
	
	public static void main(String[] args) {
		
		User user = User.Builder()
				.id("1").password("pwd")
				.email("abc@gmail.com")
				.name("abc")
				.address("1-1-198 ")
				.build();
		System.out.println(user.toString());
	}
	private static UserBuilder Builder() {
		// TODO Auto-generated method stub
		return new User.UserBuilder();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", password=" + password + ", name=" + name + ", email=" + email + ", address="
				+ address + "]";
	}
	
	
	
}
