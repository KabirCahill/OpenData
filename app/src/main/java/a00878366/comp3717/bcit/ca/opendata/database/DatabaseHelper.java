package a00878366.comp3717.bcit.ca.opendata.database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;

import java.util.List;

import a00878366.comp3717.bcit.ca.opendata.database.schema.Category;
import a00878366.comp3717.bcit.ca.opendata.database.schema.CategoryDao;
import a00878366.comp3717.bcit.ca.opendata.database.schema.DaoMaster;
import a00878366.comp3717.bcit.ca.opendata.database.schema.DaoSession;
import a00878366.comp3717.bcit.ca.opendata.database.schema.DataSet;
import a00878366.comp3717.bcit.ca.opendata.database.schema.DataSetDao;


/**
 * Created by darcy on 2016-10-19.
 */
public class DatabaseHelper
{
    private final static String TAG = DatabaseHelper.class.getName();
    private static DatabaseHelper          instance;
    private        SQLiteDatabase          db;
    private        DaoMaster               daoMaster;
    private        DaoSession              daoSession;
    private        CategoryDao             categoryDao;
    private        DataSetDao              dataSetDao;
    private        DaoMaster.DevOpenHelper helper;

    private DatabaseHelper(final Context context)
    {
        openDatabaseForWriting(context);
    }

    public synchronized static DatabaseHelper getInstance(final Context context)
    {
        if(instance == null)
        {
            instance = new DatabaseHelper(context);
        }

        return (instance);
    }

    public static DatabaseHelper getInstance()
    {
        if(instance == null)
        {
            throw new Error();
        }

        return (instance);
    }

    private void openDatabase()
    {
        daoMaster  = new DaoMaster(db);
        daoSession = daoMaster.newSession();
        categoryDao = daoSession.getCategoryDao();
        dataSetDao = daoSession.getDataSetDao();
    }

    public void openDatabaseForWriting(final Context context)
    {
        helper = new DaoMaster.DevOpenHelper(context,
                                             "categories.db",
                                             null);
        db = helper.getWritableDatabase();
        openDatabase();
    }

    public void openDatabaseForReading(final Context context)
    {
        final DaoMaster.DevOpenHelper helper;

        helper = new DaoMaster.DevOpenHelper(context,
                                             "categories.db",
                                             null);
        db = helper.getReadableDatabase();
        openDatabase();
    }

    public void close()
    {
        helper.close();
    }

    public Category createCategory(final long id, final String ct)
    {
        final Category category;

        category = new Category(id,
                        ct);
        categoryDao.insert(category);

        return (category);
    }

    public void deleteAllCategories() {
        categoryDao.deleteAll();
    }

    public Category getCategoryFromCursor(final Cursor cursor)
    {
        final Category category;

        category = categoryDao.readEntity(cursor,
                                  0);

        return (category);
    }

    public Category getCategoryByObjectId(final long id)
    {
        final List<Category> categories;
        final Category       category;

        categories = categoryDao.queryBuilder().where(CategoryDao.Properties.Id.eq(id)).limit(1).list();

        if(categories.isEmpty())
        {
            category = null;
        }
        else
        {
            category = categories.get(0);
        }

        return (category);
    }

    public List<Category> getCategories()
    {
        return (categoryDao.loadAll());
    }

    public Cursor getCategoriesCursor()
    {
        final Cursor cursor;

        String orderBy = CategoryDao.Properties.Category.columnName + " ASC";
        cursor = db.query(categoryDao.getTablename(),
                          categoryDao.getAllColumns(),
                          null,
                          null,
                          null,
                          null,
                          orderBy);

        return (cursor);
    }

    public long getNumberOfCategories()
    {
        return (categoryDao.count());
    }

    public DataSet createDataSet(final String name, final String description, long category)
    {
        final DataSet dataSet;

        dataSet = new DataSet(null, name, description, category);
        dataSetDao.insert(dataSet);

        return (dataSet);
    }

    public void deleteAllDataSets() {
        dataSetDao.deleteAll();
    }

    public DataSet getDataSetFromCursor(final Cursor cursor)
    {
        final DataSet dataSet;

        dataSet = dataSetDao.readEntity(cursor,
                0);

        return (dataSet);
    }

    public DataSet getDataSetByObjectId(final long id)
    {
        final List<DataSet> dataSets;
        final DataSet       dataSet;

        dataSets = dataSetDao.queryBuilder().where(DataSetDao.Properties.Id.eq(id)).limit(1).list();

        if(dataSets.isEmpty())
        {
            dataSet = null;
        }
        else
        {
            dataSet = dataSets.get(0);
        }

        return (dataSet);
    }

    public List<DataSet> getDataSets()
    {
        return (dataSetDao.loadAll());
    }

    public Cursor getDataSetsCursor(String selection, String[] selectionArgs)
    {
        final Cursor cursor;

        String orderBy = DataSetDao.Properties.Name.columnName + " ASC";
        cursor = db.query(dataSetDao.getTablename(),
                            dataSetDao.getAllColumns(),
                            selection,
                            selectionArgs,
                            null,
                            null,
                            orderBy);

        return (cursor);
    }

    public long getNumberOfDataSets()
    {
        return (dataSetDao.count());
    }

    public static void upgrade(final Database db,
                               final int      oldVersion,
                               final int      newVersion)
    {
    }
}
