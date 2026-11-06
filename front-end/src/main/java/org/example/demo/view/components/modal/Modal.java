package org.example.demo.view.components.modal;

import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Modal {
    public static void show(Parent root, Parent bar) {
        setEffect(bar, configModal(
                setTransparent(root)));
    }

    private static Scene setTransparent(Parent root) {
        Scene scene = new Scene(root);
        scene.setFill(Color
                .TRANSPARENT);
        return scene;
    }

    private static void setEffect(Parent bar, Stage modal) {
        Parent mainRoot = bar
                .getScene().getRoot();
        mainRoot.setEffect(
                dimEffect());
        modal.showAndWait();
        mainRoot.setEffect(null);
    }

    private static Stage configModal(Scene scene) {
        Stage modal = new Stage(StageStyle
                .UNDECORATED);
        modal.setScene(scene);
        modal.initModality(Modality
                .APPLICATION_MODAL);
        modal.setOnShown(e ->
                centerOnScreen(modal));
        return modal;
    }

    private static void centerOnScreen(Stage stage) {
        Rectangle2D bounds = Screen
                .getPrimary()
                .getVisualBounds();
        stage.setX((bounds.getWidth() -
                stage.getWidth()) / 2);
        stage.setY((bounds.getHeight() -
                stage.getHeight()) / 2);
    }

    private static ColorAdjust dimEffect() {
        ColorAdjust effect = new ColorAdjust();
        effect.setBrightness(-0.09);
        return effect;
    }
}
