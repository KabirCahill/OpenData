package a00878366.comp3717.bcit.ca.opendata;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import a00878366.comp3717.bcit.ca.opendata.database.DatabaseHelper;
import a00878366.comp3717.bcit.ca.opendata.database.schema.CategoryDao;

public class MainActivity extends ListActivity
{
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        final DatabaseHelper helper;
        final LoaderManager manager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helper = DatabaseHelper.getInstance(this);
        helper.openDatabaseForReading(this);
        adapter = new SimpleCursorAdapter(getBaseContext(),
                android.R.layout.simple_list_item_1,
                null,
                new String[]
                        {
                                CategoryDao.Properties.Category.columnName,
                        },
                new int[]
                        {
                                android.R.id.text1,
                        },
                0);
        setListAdapter(adapter);
        manager = getLoaderManager();
        manager.initLoader(0, null, new CategoryLoaderCallbacks());
        DataLoader.init(this);
    }

    @Override
    protected  void onListItemClick(ListView listView, View view, int position, long id) {
        Intent intent = new Intent(this, DataSetActivity.class);
        intent.putExtra("category_id", id);

        startActivity(intent);
    }

    private class CategoryLoaderCallbacks
            implements LoaderManager.LoaderCallbacks<Cursor>
    {
        @Override
        public Loader<Cursor> onCreateLoader(final int    id,
                                             final Bundle args)
        {
            final Uri uri;
            final CursorLoader loader;

            uri    = CategoryContentProvider.CATEGORIES_CONTENT_URI;
            loader = new CursorLoader(MainActivity.this, uri, null, null, null, null);

            return (loader);
        }

        @Override
        public void onLoadFinished(final Loader<Cursor> loader,
                                   final Cursor         data)
        {
            adapter.swapCursor(data);
        }

        @Override
        public void onLoaderReset(final Loader<Cursor> loader)
        {
            adapter.swapCursor(null);
        }
    }
}
