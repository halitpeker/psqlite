package pekerteknoloji.com.psqlite;

/*
* Halit PEKER
 */

import android.content.Context;
import java.util.ArrayList;

public class Table {

    private Context context;

    public Table(Context context){
        this.context=context;
    }

    public void createTable(String tableName, ArrayList<TableColumn> columns, boolean sequenceCreate){
        String createTable="CREATE TABLE " + tableName + "(";
        for (int i=0;i<columns.size();i++){
            createTable=createTable + columns.get(i).getName()+ " " + columns.get(i).getType() + " " + columns.get(i).getProperty() + ",";
        }
        createTable=createTable.substring(0,createTable.length()-1) + ")";
        PsqliteData.execSQL(context,createTable);
        if(sequenceCreate){
            PsqliteData.execSQL(context,"INSERT INTO SEQUNCES(TABLO,SON_ID) VALUES('"+tableName+"',0)");
        }
    }


    public void addTableColumn(String tableName, TableColumn column){
       if(PsqliteData.isVarmi(context,"SELECT "+ column.getName() +" from " + tableName)==false) {
           String updateTable = "ALTER TABLE " + tableName + " ADD COLUMN ";
           updateTable = updateTable + column.getName() + " " + column.getType();
           PsqliteData.execSQL(context, updateTable);
       }
    }

    public boolean isTableCreated(String tableName){
        boolean varmi=PsqliteData.isVarmi(context,"SELECT * FROM sqlite_master WHERE tbl_name='"+tableName+"'");
        return varmi;
    }




}
