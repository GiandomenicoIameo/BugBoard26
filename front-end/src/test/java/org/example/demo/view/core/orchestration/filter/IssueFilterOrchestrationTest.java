package org.example.demo.view.core.orchestration.filter;

import javafx.application.Platform;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

// <T extends IssueFeedCardView> List<T> getAll(FilterView filter, Supplier<T> supplier)

class IssueFilterOrchestrationTest {
    @BeforeAll
    static void initJavaFX() {
        try {
            Platform.startup(() -> {});
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}