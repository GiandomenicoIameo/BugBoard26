package org.example.demo.view.components.modal;

import javafx.application.Platform;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterFake {
    public void selectToggleGroup(ToggleGroup group,
                                  String roleValue) {
        if (roleValue == null || roleValue
                .isEmpty()) {
            group.selectToggle(null);
            return;
        }

        for(Toggle toggle : group.getToggles()) {
            if((roleValue.equals(toggle
                    .getUserData()))) {
                group.selectToggle(toggle);
                break;
            }
        }
    }

    public void toggle(String value, ToggleGroup group) {
        RadioButton button =
                new RadioButton();
        button.setUserData(value);
        button.setToggleGroup(group);
    }
}

class FilterTest {
    @BeforeAll
    static void initJavaFX() {
        try {
            Platform.startup(() -> {});
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testFilterChange()  {
        FilterFake view = new FilterFake();
        ToggleGroup groupTypology = new ToggleGroup();

        view.toggle("BUG", groupTypology);
        view.toggle("DOCUMENTATION", groupTypology);

        view.selectToggleGroup(groupTypology, "BUG");
        assertNotNull(groupTypology
                .getSelectedToggle());
        assertEquals("BUG", groupTypology
                .getSelectedToggle()
                .getUserData());

        view.selectToggleGroup(groupTypology, "DOCUMENTATION");
        assertNotNull(groupTypology
                .getSelectedToggle());
        assertEquals("DOCUMENTATION", groupTypology
                .getSelectedToggle()
                .getUserData());
    }

    @Test
    void testFilterTypologyValid()  {
        FilterFake view = new FilterFake();
        ToggleGroup typologyGroup = new ToggleGroup();

        view.toggle("BUG",
                typologyGroup);
        view.toggle("FEATURE",
                typologyGroup);
        view.toggle("DOCUMENTATION",
                typologyGroup);
        view.toggle("QUESTION",
                typologyGroup);

        view.selectToggleGroup(typologyGroup,
                "DOCUMENTATION");

        assertNotNull(typologyGroup
                .getSelectedToggle());
        assertEquals("DOCUMENTATION", typologyGroup
                .getSelectedToggle()
                .getUserData());
    }

    @Test
    void testFilterPriorityValid()  {
        FilterFake view = new FilterFake();
        ToggleGroup priorityGroup = new ToggleGroup();

        view.toggle("ALTA",
                priorityGroup);
        view.toggle("MEDIA",
                priorityGroup);
        view.toggle("BASSA",
                priorityGroup);

        view.selectToggleGroup(priorityGroup,
                "ALTA");

        assertNotNull(priorityGroup
                .getSelectedToggle());
        assertEquals("ALTA", priorityGroup
                .getSelectedToggle()
                .getUserData());
    }

    @Test
    void testFilterStateValid()  {
        FilterFake view = new FilterFake();
        ToggleGroup stateGroup = new ToggleGroup();

        view.toggle("TODO",
                stateGroup);
        view.toggle("CHIUSO",
                stateGroup);

        view.selectToggleGroup(stateGroup,
                "TODO");

        assertNotNull(stateGroup
                .getSelectedToggle());
        assertEquals("TODO", stateGroup
                .getSelectedToggle()
                .getUserData());
    }

    @Test
    void testFilterBadValid()  {
        FilterFake view = new FilterFake();
        ToggleGroup stateGroup = new ToggleGroup();

        view.toggle("TODO",
                stateGroup);
        view.toggle("CHIUSO",
                stateGroup);

        view.selectToggleGroup(stateGroup,
                "APERTO");
        assertNull(stateGroup
                .getSelectedToggle());
    }

    @Test
    void testFilterNullInvalid()  {
        FilterFake view = new FilterFake();
        ToggleGroup stateGroup = new ToggleGroup();

        view.toggle("TODO",
                stateGroup);
        view.toggle("CHIUSO",
                stateGroup);

        view.selectToggleGroup(stateGroup,
                null);
        assertNull(stateGroup
                .getSelectedToggle());
    }

    @Test
    void testFilterEmpty()  {
        FilterFake view = new FilterFake();
        ToggleGroup group = new ToggleGroup();

        view.toggle("BUG", group);
        view.toggle("DOCUMENTATION", group);

        view.selectToggleGroup(group, "");
        assertNull(group
                .getSelectedToggle());
    }

    // Questo caso di test verifica
    // che i gruppi siano disgiunti.
    @Test
    void testFilterBad()  {
        FilterFake view = new FilterFake();
        ToggleGroup priorityGroup =
                new ToggleGroup();
        ToggleGroup stateGroup =
                new ToggleGroup();

        view.toggle("ALTA", priorityGroup);
        view.toggle("TODO", stateGroup);

        view.selectToggleGroup(priorityGroup,
                "TODO");
        assertNull(priorityGroup
                .getSelectedToggle());

        view.selectToggleGroup(stateGroup,
                "ALTA");
        assertNull(stateGroup
                .getSelectedToggle());
    }
}