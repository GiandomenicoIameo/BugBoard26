package org.example.demo.view.core.orchestration.notice;

import org.example.demo.view.components.card.notice.definitions.NoticeView;

import java.io.IOException;
import java.util.List;
import java.util.function.Supplier;

public interface NoticeOrchestration {
    <T extends NoticeView> List<T> getAll(
            Supplier<T> supplier) throws IOException,
            InterruptedException;
}
