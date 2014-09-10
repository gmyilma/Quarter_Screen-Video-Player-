package com.girma.xppepers;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayVideo extends Activity
{


 private String videoPath ="url";

 private static ProgressDialog progressDialog;
 String videourl;  
    VideoView videoView ;


 protected void onCreate(Bundle savedInstanceState)
 {

  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

   videoView = (VideoView) findViewById(R.id.videoView);


   progressDialog = ProgressDialog.show(PlayVideo.this, "", "Buffering video...", true);
   progressDialog.setCancelable(true);  


      PlayVideo1();

 }
 private void PlayVideo1()
 {
  try
       {      
              getWindow().setFormat(PixelFormat.TRANSLUCENT);
              MediaController mediaController = new MediaController(PlayVideo.this);
              mediaController.setAnchorView(videoView);           

               Uri video = Uri.parse(videoPath );             
               videoView.setMediaController(mediaController);
               videoView.setVideoURI(video);
               videoView.requestFocus();              
               videoView.setOnPreparedListener(new OnPreparedListener()
               {

                   public void onPrepared(MediaPlayer mp)
                   {                  
                       progressDialog.dismiss();     
                       videoView.start();
                   }
               });           


            }
       catch(Exception e)
       {
                progressDialog.dismiss();
                System.out.println("Video Play Error :"+e.toString());
                finish();
       }   

 }
}