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

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        try {
            JAXBContext context = JAXBContext.newInstance(Document.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Document document2 = (Document) unmarshaller.unmarshal(new File("/root/Загрузки/securities_1.xml"));
//            document2.getData().getRows().forEach(row -> {
//                System.out.println("row.getId " + row.getId() + " row.getShortname " + row.getShortname() + " row.getSecid " + row.getSecid());
//            });
            List<Row> columns = document2.getData().getRows();
            Grid<Row> grid = new Grid<>();
            grid.setItems(columns);
            grid.addColumn(Row::getName).setCaption("Name");
            grid.addColumn(Row::getShortname).setCaption("ShortName");
            grid.setSizeFull();
            layout.addComponent(grid);
            setContent(layout);

        } catch (JAXBException e) {
            e.printStackTrace();
        }


    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
