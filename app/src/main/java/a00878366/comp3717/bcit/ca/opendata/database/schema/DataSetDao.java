package a00878366.comp3717.bcit.ca.opendata.database.schema;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DATA_SET".
*/
public class DataSetDao extends AbstractDao<DataSet, Long> {

    public static final String TABLENAME = "DATA_SET";

    /**
     * Properties of entity DataSet.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Description = new Property(2, String.class, "description", false, "DESCRIPTION");
        public final static Property Category_id = new Property(3, long.class, "category_id", false, "CATEGORY_ID");
    }


    public DataSetDao(DaoConfig config) {
        super(config);
    }
    
    public DataSetDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DATA_SET\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT NOT NULL ," + // 1: name
                "\"DESCRIPTION\" TEXT NOT NULL ," + // 2: description
                "\"CATEGORY_ID\" INTEGER NOT NULL );"); // 3: category_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DATA_SET\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DataSet entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getDescription());
        stmt.bindLong(4, entity.getCategory_id());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DataSet entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
        stmt.bindString(2, entity.getName());
        stmt.bindString(3, entity.getDescription());
        stmt.bindLong(4, entity.getCategory_id());
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public DataSet readEntity(Cursor cursor, int offset) {
        DataSet entity = new DataSet( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.getString(offset + 1), // name
            cursor.getString(offset + 2), // description
            cursor.getLong(offset + 3) // category_id
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DataSet entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.getString(offset + 1));
        entity.setDescription(cursor.getString(offset + 2));
        entity.setCategory_id(cursor.getLong(offset + 3));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(DataSet entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(DataSet entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(DataSet entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}