package org.test;

import javax.servlet.annotation.WebServlet;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.io.File;
import java.io.FileNotFoundException;
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
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });

        layout.addComponents(name, button);

        Securities securities = new Securities(154676, "AAPL","Apple","","Apple Inc.","US0378331005",1,
                1281003,"Apple Inc","","","","common_share","stock_shares",
                "EQRD","");

        try {
            JAXBContext context = JAXBContext.newInstance(Securities.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(securities, new File("/root/Загрузки/secur.xml"));
            marshaller.marshal(securities, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        List<Person> people = Arrays.asList(
                new Person("Nicolaus Copernicus", 1543),
                new Person("Galileo Galilei", 1564),
                new Person("Johannes Kepler", 1571));

        Grid<Person> grid = new Grid<>();
        grid.setItems(people);
        grid.addColumn(Person::getName).setCaption("Name");
        grid.addColumn(Person::getAge).setCaption("Year of birth");
        layout.addComponent(grid);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
