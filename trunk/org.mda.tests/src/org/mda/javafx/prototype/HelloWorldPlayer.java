package org.mda.javafx.prototype;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/** plays an mp4 video in JavaFX 2.1+ */
public class HelloWorldPlayer extends Application {
  public static void main(String[] args) { launch(args); }
  @Override public void start(Stage stage) {
    final Label status = new Label("Init");
    MediaPlayer mediaPlayer = createMediaPlayer(
      "file:///tmp/carpenter_de.mp4", 
      status
    );
    
    VBox layout = new VBox(10);
    layout.setAlignment(Pos.CENTER);
    MediaView mediaView = new MediaView(mediaPlayer);
    int size = 2;
    mediaView.setScaleX(size);
    mediaView.setScaleY(size);
    mediaView.setSmooth(true);
    layout.getChildren().addAll(mediaView, status);
    stage.setScene(new Scene(layout, 1000, 600, Color.BLACK));
    stage.show();
    if (mediaPlayer != null) {
      mediaPlayer.play();
    }  
  }

  /** 
   * creates a media player using a url to the media
   * and tracks the status of playing the media via the status label 
   */
  private MediaPlayer createMediaPlayer(final String url, final Label status) {
    Media hit = new Media(url);
    MediaPlayer mediaPlayer = new MediaPlayer(hit);
    mediaPlayer.setOnError(new Runnable() {
      @Override public void run() {
        status.setText("Error");
      }
    });
    mediaPlayer.setOnPlaying(new Runnable() {
      @Override public void run() {
        status.setText("");
      }
    });
    mediaPlayer.setOnEndOfMedia(new Runnable() {
      @Override public void run() {
        status.setText("Done");
      }
    });
    return mediaPlayer;
  }
}