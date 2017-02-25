package a00878366.comp3717.bcit.ca.opendata;

import android.app.ListActivity;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import a00878366.comp3717.bcit.ca.opendata.database.DatabaseHelper;
import a00878366.comp3717.bcit.ca.opendata.database.schema.DataSetDao;

public class DataSetActivity extends ListActivity {

    private SimpleCursorAdapter adapter;
    private long categoryId;
    private Cursor cursor;

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
    }

    @Override
    protected  void onListItemClick(ListView listView, View view, int position, long id) {
        String name;
        String description;

        cursor.moveToPosition(position);
        //Log.v("---------------------->", cursor.getString(cursor.getColumnIndex("NAME")));
        name = cursor.getString((cursor.getColumnIndex("NAME")));
        description = cursor.getString((cursor.getColumnIndex("DESCRIPTION")));

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("name", name);
        intent.putExtra("description", description);

        startActivity(intent);
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

            uri    = OpenDataContentProvider.DATASETS_CONTENT_URI;
            loader = new CursorLoader(DataSetActivity.this, uri, null, "category_id = " + categoryId, null, null);

            return (loader);
        }

        @Override
        public void onLoadFinished(final Loader<Cursor> loader,
                                   final Cursor         data)
        {
            cursor = data;

//            data.moveToFirst();
//
//            while(!data.isAfterLast()) {
//                Log.v("name", data.getString(1));
//
//                data.move(1);
//            }

//            String[] cols = data.getColumnNames();
//            for(String column : cols) {
//                Log.v("col: ", column);
//            }


            adapter.swapCursor(data);
        }

        @Override
        public void onLoaderReset(final Loader<Cursor> loader)
        {
            adapter.swapCursor(null);
        }
    }
}
