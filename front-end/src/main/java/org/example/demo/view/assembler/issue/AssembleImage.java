package org.example.demo.view.assembler.issue;

import org.example.demo.view.dto.issue.ImageRequestDTO;

public class AssembleImage {
    private static void assembleId(Integer id,
                                        ImageRequestDTO request) {
        request.setIdIssue(id);
    }

    public static ImageRequestDTO assemble(Integer id) {
        ImageRequestDTO request
                = new ImageRequestDTO();
        assembleId(id,
                request);

        return request;
    }
}
