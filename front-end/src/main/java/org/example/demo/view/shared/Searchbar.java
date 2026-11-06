package org.example.demo.view.shared;

import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.scene.layout.Region;

public class Searchbar {
    private final Region region;
    private double high;
    private Runnable code;

    public void setOnFinished(Runnable code) {
        this.code = code;
    }

    public Searchbar(Region region) {
        this.region = region;
    }

    public void viewBack() {
        if(!region.isVisible()) {
            setVisibile(true);
            region.toBack();
            setDimension();
            updateHeight(-1);
            slide((int) -high, 0, () ->
                    region.toFront());
        }
        else {
            region.toBack();
            updateHeight(-1);
            slide(0, (int) -high, () -> {
                setVisibile(false);
                region.setTranslateY(0);
                code.run();
            });
        }
    }

    public void viewFront() {
        if(!region.isVisible()) {
            setVisibile(true);
            updateHeight(60);
            slide((int) -high, 0,
                    () -> {});
        }
        else {
            updateHeight(60);
            slide(0, (int) -high,
                    () -> {
                setVisibile(false);
                region.setTranslateY(0);
                code.run();
            });
        }
    }

    private void setDimension() {
        region.applyCss();
        region.layout();
    }

    private TranslateTransition translate(int src, int dst) {
        TranslateTransition move = new TranslateTransition(
                Duration.seconds(0.2), region);
        move.setFromY(src);
        move.setToY(dst);

        return move;
    }

    private void slide(int start, int end, Runnable code) {
        TranslateTransition slide =
                translate(start, end);
        slide.setOnFinished(event ->
                code.run());
        slide.play();
    }

    private void setVisibile(boolean visible) {
        region.setVisible(visible);
        region.setManaged(visible);
    }

    private void updateHeight(int prefer) {
        high = region.getPrefHeight();
        if (high <= 0)
            high = prefer;
    }
}
