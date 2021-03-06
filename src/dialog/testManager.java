package dialog;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.Test;

import db.DataBase;
import db.IDataBase;

class testManager {

	@Test
	void test() {
		IDataBase db = new DataBase();
		db.initDatabase();
		db.connect();
		Integer[] resultEx = new Integer[] {123,122,124};
		int hour = 30;
		for(int i = 0;i < resultEx.length; i++)
			db.setDataItem(resultEx[i], null, hour);
    	
    	ArrayList<Integer> resultGet = db.getIdWithTime(hour);
		for(int i = 0; i < resultEx.length; i++)
			assertEquals(resultEx[i], resultGet.get(i));
	}

}
