package a00878366.comp3717.bcit.ca.opendata;

import android.app.Activity;
import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import java.util.List;

import a00878366.comp3717.bcit.ca.opendata.database.DatabaseHelper;
import a00878366.comp3717.bcit.ca.opendata.database.schema.CategoryDao;
import a00878366.comp3717.bcit.ca.opendata.database.schema.DataSetDao;

public class DataSetActivity extends ListActivity {

    private SimpleCursorAdapter adapter;
    private long categoryId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final DatabaseHelper helper;
        final LoaderManager manager;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_set);

        Bundle bundle = getIntent().getExtras();
        categoryId = bundle.getLong("category_id");



        helper = DatabaseHelper.getInstance(this);
        helper.openDatabaseForReading(this);
        adapter = new SimpleCursorAdapter(getBaseContext(),
                android.R.layout.simple_list_item_1,
                null,
                new String[]
                        {
                                DataSetDao.Properties.Name.columnName,
                        },
                new int[]
                        {
                                android.R.id.text1,
                        },
                0);
        setListAdapter(adapter);
        manager = getLoaderManager();
        manager.initLoader(0, null, new DataSetActivity.DataSetLoaderCallbacks());
        DataLoader.init(this);
    }

    private class DataSetLoaderCallbacks
            implements LoaderManager.LoaderCallbacks<Cursor>
    {
        @Override
        public Loader<Cursor> onCreateLoader(final int    id,
                                             final Bundle args)
        {
            final Uri uri;
            final CursorLoader loader;

            uri    = CategoryContentProvider.DATASETS_CONTENT_URI;
            loader = new CursorLoader(DataSetActivity.this, uri, null, "category_id = " + categoryId, null, null);

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
