package db;

public interface IDataBase {
	public void connect();
	public void initDatabase();
	public Object getData(int userId);
	public void setDataItem(int userId,Object object);
	public boolean checkId(int idUser);

}
