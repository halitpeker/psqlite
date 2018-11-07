package pekerteknoloji.com.psqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Psqlite {
	public SQLiteDatabase dtb=null;
	private Context context;

	public Psqlite(Context context) {
		this.context=context;
	}
	
	public void connect(){
		dtb=context.openOrCreateDatabase("PSQL.db", Context.MODE_PRIVATE,null);
	}
	
	public boolean execSQL(String sql){
		try {
			dtb.execSQL(sql);
			return true;
		}catch (Exception e){
			Log.e("SqlLite_execSQL",e.toString());
			return false;
		}
	}

	public void disconnect(){
		if (dtb!=null) dtb.close();
	}
}
