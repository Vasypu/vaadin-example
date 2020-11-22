package org.test;

import com.vaadin.ui.Grid;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class OpenWindow extends Window {
    final VerticalLayout layout = new VerticalLayout();

    public OpenWindow (Grid<RowSecurities> grid) {

        grid.addColumn(RowSecurities::getSecid).setCaption("Secid");
        grid.addColumn(RowSecurities::getRegnumber).setCaption("Regnumber");
        grid.addColumn(RowSecurities::getShortname).setCaption("Name");
        grid.addColumn(RowSecurities::getEmitent_title).setCaption("Emitent title");

        grid.setSizeFull();

        setSizeFull();
        layout.addComponents(grid);
        setContent(layout);
    }
}
