package org.example.demo.view.mapper.issue;

import javafx.scene.image.Image;
import org.example.demo.view.dto.issue.ImageResponseDTO;

public class MapperImage {
    public static Image mapper(ImageResponseDTO response) {
        if (response == null)
            return null;
        return response.getImage();
    }
}
