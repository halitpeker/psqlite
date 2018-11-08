package pekerteknoloji.com.psqlite;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class PsqliteData {
    public static boolean execSQL(Context context, String sql) {
        Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        if (psqlite.execSQL(sql)) {
            psqlite.disconnect();
            return true;
        } else {
            psqlite.disconnect();
            return false;
        }
    }

    public static String getString(Context context, String sql) {
        String donus = "";
        Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        Cursor cursor = psqlite.dtb.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            donus = cursor.getString(0);
        }
        cursor.close();
        psqlite.disconnect();
        return donus;
    }
    
    public static Long getLong(Context context, String sql) {
        Long donus = 0l;
        Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        Cursor cursor = psqlite.dtb.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            donus = cursor.getLong(0);
        }
        cursor.close();
        psqlite.disconnect();
        return donus;
    }

    public static ArrayList<String> ArrayListDoldurString(Context context, String sql) {
        final Psqlite psqlite = new Psqlite(context);
        ArrayList<String> lstList=new ArrayList<String>();
        psqlite.connect();
        Cursor cDoviz = psqlite.dtb.rawQuery(sql, null);
        while (cDoviz.moveToNext()) {
            lstList.add(cDoviz.getString(0));
        }
        cDoviz.close();
        psqlite.disconnect();
        return lstList;
    }

    public static ArrayList<Long> ArrayListDoldurLong(Context context, String sql) {
        final Psqlite psqlite = new Psqlite(context);
        ArrayList<Long> lstList=new ArrayList<Long>();
        psqlite.connect();
        Cursor cDoviz = psqlite.dtb.rawQuery(sql, null);
        while (cDoviz.moveToNext()) {
            lstList.add(Long.valueOf(cDoviz.getString(0)));
        }
        cDoviz.close();
        psqlite.disconnect();
        return lstList;
    }

    public static Map<Integer, String> getRow(Context context, String sql) {
        Map<Integer, String> row =new HashMap<>();
        final Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        Cursor cursor = psqlite.dtb.rawQuery(sql, null);
        int columCount = cursor.getColumnCount() - 1;
        cursor.moveToFirst();
        for (int j = 0; j <= columCount; j++) {
            row.put(j, cursor.getString(j));
        }
        cursor.close();
        psqlite.disconnect();
        return row;
    }

    public static ArrayList<Map<String, String>> getRowList(Context context, String sql) {
        ArrayList<Map<String, String>> arrRow = new ArrayList<>();
        final Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        Cursor cursor = psqlite.dtb.rawQuery(sql, null);
        while (cursor.moveToNext()) {
            Map<String, String> row = new HashMap<>();
            row.put("ID", cursor.getString(0));
            row.put("VALUE", cursor.getString(1));
            arrRow.add(row);
        }
        cursor.close();
        psqlite.disconnect();
        return arrRow;
    }

    public static int getint(Context context, String sql) {
        int donus = 0;
        Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        Cursor cursor = psqlite.dtb.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            donus = cursor.getInt(0);
        }
        cursor.close();
        psqlite.disconnect();
        return donus;
    }

    public static BigDecimal getBigDecimal(Context context, String sql) {
        BigDecimal donus = BigDecimal.ZERO;
        Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        Cursor cursor = psqlite.dtb.rawQuery(sql, null);
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            donus = new BigDecimal(cursor.getDouble(0));
        }
        cursor.close();
        psqlite.disconnect();
        return donus;
    }

    public static boolean isVarmi(Context context, String sql) {
        boolean donus = false;
        Psqlite psqlite = new Psqlite(context);
        psqlite.connect();
        try {
            Cursor cursor = psqlite.dtb.rawQuery(sql, null);
            if (cursor.getCount() > 0) {
                donus = true;
            }
            cursor.close();
        }catch (Exception e){
            donus=false;
        }
        psqlite.disconnect();
        return donus;
    }
}
