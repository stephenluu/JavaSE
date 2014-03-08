public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LogHandler logHandler = new LogHandler();
		UserManager userManager = (UserManager) logHandler
				.newProxyInstance(new UserManagerImpl());
		String name = userManager.addUser("0001", "user1");
		
		String name2 = userManager.addUser2("0001", "user2");
	}

}