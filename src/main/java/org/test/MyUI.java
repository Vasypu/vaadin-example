package org.test;

import javax.servlet.annotation.WebServlet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {
    final VerticalLayout layout = new VerticalLayout();
    private Document document;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        try {
            document = Parser.fromXml();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        List<Row> columns = document.getData().getRows();
        Grid<Row> grid = new Grid<>();
        grid.setItems(columns);
        grid.addColumn(Row::getSecid).setCaption("Secid");
        grid.addColumn(Row::getShortname).setCaption("Name");
        grid.setSizeFull();
        layout.addComponent(grid);

        Button create = new Button("Создать");
        create.addClickListener(clickEvent -> {

            CreateWindow window = new CreateWindow(document);
            UI.getCurrent().addWindow(window);
        });
        layout.addComponent(create);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
