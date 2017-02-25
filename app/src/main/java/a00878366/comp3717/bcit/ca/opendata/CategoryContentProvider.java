package a00878366.comp3717.bcit.ca.opendata;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import a00878366.comp3717.bcit.ca.opendata.database.DatabaseHelper;

public class CategoryContentProvider
    extends ContentProvider
{
    private static final UriMatcher uriMatcher;
    private static final int CATEGORIES_URI = 1;
    private static final int DATASETS_URI = 2;
    public static final Uri CATEGORIES_CONTENT_URI;
    public static final Uri DATASETS_CONTENT_URI;
    private DatabaseHelper helper;

    static
    {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("a00878366.comp3717.bcit.ca.opendata", "categories", CATEGORIES_URI);
        uriMatcher.addURI("a00878366.comp3717.bcit.ca.opendata", "datasets", DATASETS_URI);
    }

    static
    {
        CATEGORIES_CONTENT_URI = Uri.parse("content://a00878366.comp3717.bcit.ca.opendata/categories");
        DATASETS_CONTENT_URI = Uri.parse("content://a00878366.comp3717.bcit.ca.opendata/datasets");
    }

    @Override
    public boolean onCreate()
    {
        helper = DatabaseHelper.getInstance(getContext());

        return true;
    }

    @Override
    public Cursor query(final Uri uri,
                        final String[] projection,
                        final String selection,
                        final String[] selectionArgs,
                        final String sortOrder)
    {
        final Cursor cursor;

        switch (uriMatcher.match(uri))
        {
            case CATEGORIES_URI:
            {
                final SQLiteDatabase db;

                helper.openDatabaseForReading(getContext());
                cursor = helper.getCategoriesCursor();
                helper.close();
                break;
            }
            case DATASETS_URI:
            {
                final SQLiteDatabase db;

                helper.openDatabaseForReading(getContext());
                cursor = helper.getDataSetsCursor(selection, selectionArgs);
                helper.close();
                break;
            }
            default:
            {
                throw new IllegalArgumentException("Unsupported URI: " + uri);
            }
        }

        return (cursor);
    }

    @Override
    public String getType(final Uri uri)
    {
        final String type;

        switch(uriMatcher.match(uri))
        {
            case CATEGORIES_URI:
                type = "vnd.android.cursor.dir/vnd.a00878366.comp3717.bcit.ca.opendata.categories";
                break;
            case DATASETS_URI:
                type = "vnd.android.cursor.dir/vnd.a00878366.comp3717.bcit.ca.opendata.datasets";
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        return (type);
    }

    @Override
    public int delete(final Uri uri,
                      final String selection,
                      final String[] selectionArgs)
    {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(final Uri uri,
                      final ContentValues values)
    {
        // TODO: Implement this to handle requests to insert a new row.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int update(final Uri uri,
                      final ContentValues values,
                      final String selection,
                      final String[]      selectionArgs)
    {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
