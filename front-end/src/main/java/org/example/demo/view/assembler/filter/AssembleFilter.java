package org.example.demo.view.assembler.filter;

import org.example.demo.view.components.modal.definitions.FilterModalView;
import org.example.demo.view.dto.filter.FilterRequestDTO;

public class AssembleFilter {
    private static void assembleKeyword(FilterModalView filter,
                                        FilterRequestDTO request) {
        request.setKeyword(filter.getKeyword());
    }

    private static void assemblePriority(FilterModalView filter,
                                         FilterRequestDTO request) {
        request.setPriority(filter.getPriority());
    }

    private static void assembleState(FilterModalView filter,
                                      FilterRequestDTO request) {
        request.setState(filter.getState());
    }

    private static void assembleTypology(FilterModalView filter,
                                         FilterRequestDTO request) {
        request.setTypology(filter.getTypology());
    }

    public static FilterRequestDTO assemble(FilterModalView filter) {
        FilterRequestDTO request =
                new FilterRequestDTO();

        assembleKeyword(filter,
                request);
        assemblePriority(filter,
                request);
        assembleState(filter,
                request);
        assembleTypology(filter,
                request);

        return request;
    }
}
