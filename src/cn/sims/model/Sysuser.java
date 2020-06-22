package cn.sims.model;

public class Sysuser {
    private String account;

    private String password;

    public Sysuser(String account, String password) {
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
}