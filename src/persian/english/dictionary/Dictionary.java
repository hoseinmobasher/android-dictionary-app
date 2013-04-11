package persian.english.dictionary;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.support.farsi.FarsiSupport;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

public class Dictionary extends Activity {
	private SQLiteDatabase sqliteDB = null;
	private boolean enablePopup = true;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		if (!new File("/data/data/" + this.getPackageName()
				+ "/database.sqlite").exists()) {
			try {
				FileOutputStream out = new FileOutputStream("data/data/"
						+ this.getPackageName() + "/database.sqlite");
				InputStream in = getAssets().open("databases/dic.db");

				byte[] buffer = new byte[1024];
				int readBytes = 0;

				while ((readBytes = in.read(buffer)) != -1)
					out.write(buffer, 0, readBytes);

				in.close();
				out.close();
			} catch (IOException e) {
			}
		}

		sqliteDB = SQLiteDatabase.openOrCreateDatabase(
				"/data/data/" + this.getPackageName() + "/database.sqlite",
				null);

		final AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.searchbox);
		textView.setThreshold(1);
		final Context context = this;

		textView.addTextChangedListener(new TextWatcher() {

			@Override
			public void onTextChanged(CharSequence s, int start, int before,
					int count) {
				if (s.length() >= 1 && enablePopup) {
					Cursor cursor = sqliteDB.rawQuery(
							"SELECT word FROM dictionary WHERE word LIKE '"
									+ s.toString().toLowerCase()
									+ "%' LIMIT 10", null);

					if (cursor.getCount() > 0) {
						cursor.moveToFirst();
						ArrayList<String> word = new ArrayList<String>();

						while (!cursor.isAfterLast()) {
							word.add(cursor.getString(0));
							cursor.moveToNext();
						}

						textView.setAdapter(new DropDownAdapter(context,
								sqliteDB, word));
					} else {
						textView.setAdapter(new DropDownAdapter(context,
								sqliteDB, new ArrayList<String>()));
					}
				} else {
					textView.setAdapter(new DropDownAdapter(context, sqliteDB,
							new ArrayList<String>()));
				}

				enablePopup = true;
			}

			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {

			}

			@Override
			public void afterTextChanged(Editable s) {
			}
		});
	}

	@Override
	protected void onDestroy() {
		sqliteDB.close();
		super.onDestroy();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater menuInflater = this.getMenuInflater();
		menuInflater.inflate(R.menu.item_menu, menu);

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (((String) item.getTitle()).compareTo("About") == 0) {
			Toast.makeText(this, "Copyleft 2012, Version 0.1",
					Toast.LENGTH_LONG).show();
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	class DropDownAdapter extends ArrayAdapter<String> {
		Context context;
		ArrayList<String> data;
		SQLiteDatabase sqliteDB;

		public DropDownAdapter(Context context, SQLiteDatabase sqliteDB,
				ArrayList<String> data) {
			super(context, R.layout.list_item_item, data);

			this.context = context;
			this.sqliteDB = sqliteDB;
			this.data = data;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			LayoutInflater inflater = (LayoutInflater) this.context
					.getSystemService(LAYOUT_INFLATER_SERVICE);

			View rowView = (View) inflater.inflate(R.layout.list_item_item,
					parent, false);

			TextView textView = (TextView) rowView.findViewById(R.id.item_text);
			textView.setText(data.get(position));

			final int pos = position;

			textView.setOnTouchListener(new View.OnTouchListener() {
				@Override
				public boolean onTouch(View v, MotionEvent event) {
					new Thread(new Runnable() {

						@Override
						public void run() {
							Cursor cursor = sqliteDB
									.rawQuery(
											"SELECT mean FROM dictionary WHERE word='"
													+ data.get(pos)
															.toLowerCase()
													+ "'", null);

							cursor.moveToFirst();
							final String wordMean = cursor.getString(0);
							cursor.close();

							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									AutoCompleteTextView tv = (AutoCompleteTextView) findViewById(R.id.searchbox);
									TextView mean = (TextView) findViewById(R.id.passage);
									mean.setTypeface(Typeface.createFromAsset(
											getAssets(), "fonts/Nazanin.ttf"));
									mean.setText(FarsiSupport.Convert(wordMean));
									tv.setText(data.get(pos));
									enablePopup = false;
									tv.dismissDropDown();
								}
							});
						}
					}).start();

					return true;
				}
			});

			return rowView;
		}
	}
}