package bank.com.bean;
/**
 * �û�ʵ����
 * �������� String username��String password,double money �˻����
 * ������֤�û���¼��ע�Ṧ��
 * ����û���ת�� ȡ�� ��� �Ȳ���
 * @Author DFX
 * @version 2.0 207/27
 * */
public class User {
	
	private String ID;
	private String username;//�û���
	private String password;//����
	private double money;
	
	public User(){}//��ʾ�ṩ�޲����Ĺ��췽��
	public User(String username,String password){
		this.username=username;
		this.password=password;
	}
	
	public User(String username,String password,double money){
		this.username=username;
		this.password=password;
		this.money=money;
	}
	
	public double getMoney(){
		return money;
	}
	public void setMoney(double money){
		this.money=money;
	}
	
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}


	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	//��дtoString()����
	public String toString(){
		return this.getClass()+"[name"+username+",password"+password+"]";
	}

}
