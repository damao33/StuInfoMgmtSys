package cn.sims.model;

public class User {
    private String account;

    private String password;

    public User(String account, String password) {
		super();
		this.account = account;
		this.password = password;
	}

	public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + "]";
	}
    
    
}