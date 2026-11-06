package org.example.demo.view.shared;

import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.util.Duration;
import javafx.scene.layout.Region;

public class Searchbar {
    private Region region;
    private double high;

    public Searchbar(Region region) {
        this.region = region;
    }

    public void view() {
        if(!region.isVisible()) {
            setVisibile(true); region.toBack();
            updateHeight();
            slide((int) -high, 0, () ->
                    region.toFront());
        }
        else {
            region.toBack(); updateHeight();
            slide(0, (int) -high, () -> {
                setVisibile(false);
                region.setTranslateY(0);
            });
        }
    }

    private TranslateTransition translate(int src, int dst) {
        TranslateTransition move = new TranslateTransition(
                Duration.seconds(0.3), region);
        move.setFromY(src);
        move.setToY(dst);

        return move;
    }

    private void slide(int start, int end, Runnable code) {
        Platform.runLater(() -> {
            TranslateTransition slide =
                    translate(start, end);
            slide.setOnFinished(event ->
                    code.run());
            slide.play();
        });
    }

    private void setVisibile(boolean visible) {
        region.setVisible(visible);
        region.setManaged(visible);
    }

    private void updateHeight() {
        region.applyCss();
        region.layout();
        high = region.getHeight();

        if (high == 0)
            high = region
                    .prefHeight(-1);
    }
}
