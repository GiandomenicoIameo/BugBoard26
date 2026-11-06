package org.example.demo.view.components.card.notice.definitions;

import java.time.LocalDateTime;

public interface NoticeView {
    void setId(Integer id);
    void setDate(LocalDateTime date);
    void setRead(boolean read);
}
