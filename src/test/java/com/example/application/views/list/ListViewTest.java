package com.example.application.views.list;

import com.example.application.data.Contact;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.data.provider.ListDataProvider;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Ivan Tomičić
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListViewTest {

    @Autowired
    private ListView listView;

    @Test
    public void formShownWhenContactSelected() {
        Grid<Contact> grid = listView.grid;
        Contact firstContact = getFirstItem(grid);

        ContactForm form = listView.form;

        Assertions.assertFalse(form.isVisible());
        grid.asSingleSelect().setValue(firstContact);

        Assertions.assertTrue(form.isVisible());
        Assertions.assertEquals(firstContact.getFirstName(), form.firstName.getValue());
    }

    private Contact getFirstItem(Grid<Contact> grid) {
        return ((ListDataProvider<Contact>)grid.getDataProvider()).getItems().iterator().next();
    }
}
