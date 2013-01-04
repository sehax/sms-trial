package dtd.phs.chatexperiment_phs;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

	private static final String DB_NAME = "BatteryMeterDB";
	private static final int DB_VERSION = 1;
	private SQLiteDatabase db = null;

	public DBHandler(Context context) {
		super(context, DB_NAME, null, DB_VERSION );
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(BatteryStatusTable.createTableQuery());
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
	    db.execSQL("DROP TABLE IF EXISTS " + BatteryStatusTable.TBL_NAME);
	    onCreate(db);
	}
	
	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
		if (! db.isReadOnly()) {
			db.execSQL("PRAGMA foreign_keys=ON;");
		}
	}
}