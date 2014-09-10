package com.girma.xppepers;

import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		VideoView videoView =(VideoView)findViewById(R.id.videoView);
	    MediaController mediaController= new MediaController(this);
	    View v = findViewById(R.id.view1);
	    mediaController.setAnchorView(v);  
	    mediaController.setPadding(21, 10, 380, 750);
	    Uri  uri= Uri.parse("android.resource://com.girma.xppepers/raw/" + R.raw.girma);
	    videoView.setMediaController(mediaController);
	    videoView.setVideoURI(uri);        
	    videoView.requestFocus();
	    videoView.start();    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
