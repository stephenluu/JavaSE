
public class UserManagerImpl implements UserManager{

	@Override
	public String addUser(String userId, String userName) {
		System.out.println("userId = "+userId+" ; userName = " +userName);
		return userName;
		
	}

	@Override
	public String addUser2(String userId, String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
