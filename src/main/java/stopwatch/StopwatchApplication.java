package stopwatch;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.apache.commons.lang3.time.DurationFormatUtils;

import java.io.IOException;

public class StopwatchApplication extends Application {

    @FXML
    private Label stopwatchLabel;

    private long start;

    @FXML
    private void initialize() {
        start = System.currentTimeMillis();
        Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            long millisElapsed = System.currentTimeMillis() - start;
            stopwatchLabel.setText(DurationFormatUtils.formatDuration(millisElapsed, "HH:mm:ss"));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(StopwatchApplication.class.getResource("/stopwatch.fxml"));
        stage.setTitle("JavaFX Stopwatch");
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.show();
    }

}
