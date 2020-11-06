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
        
        final TextField name = new TextField();
        name.setCaption("Type your name here:");

        Button button = new Button("Click Me");
        button.addClickListener(e -> {
            layout.addComponent(new Label("Thanks " + name.getValue() 
                    + ", it works!"));
        });

        layout.addComponents(name, button);

        Row securities = new Row(154676, "AAPL","Apple","","Apple Inc.","US0378331005",1,
                1281003,"Apple Inc","","","","common_share","stock_shares",
                "EQRD","");
        Row securities2 = new Row(154676, "AAPLsdf","dsfasf","","Apple Inc.","US0378331005",1,
                1281003,"Apple Inc","","","","common_share","stock_shares",
                "EQRD","");
        Column column1 = new Column("secid","string","36","0");
        Column column2 = new Column("asd","int","42","0");

        Document document = new Document();

        Document.Data data = new Document.Data();
        data.getRows().add(securities);
        data.getRows().add(securities2);

        Document.Data.Metadata metadata = new Document.Data.Metadata();
        metadata.getColumns().add(column1);
        metadata.getColumns().add(column2);

        document.setData(data);
        document.getData().setMetadata(metadata);
        document.getData().setId("securities");

        try {
            JAXBContext context = JAXBContext.newInstance(Document.class);
//            Marshaller marshaller = context.createMarshaller();
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(document, new File("/root/Загрузки/secur.xml"));
//            marshaller.marshal(document, System.out);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Document document2 = (Document) unmarshaller.unmarshal(new File("/root/Загрузки/securities_1.xml"));
            document2.getData().getRows().forEach(row -> {
                System.out.println("row.getId " + row.getId() + " row.getShortname " + row.getEmitent_id());
            });
//            document2.getRows().forEach(row -> {
//                try {
//                    PrintWriter writer = new PrintWriter(new File("/root/Загрузки/secur2.xml"));
//                    writer.print("row.getId() " + row.getId());
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("row.getId() " + row.getId());
//            });
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
        grid.addColumn(Person::getAge).setCaption("Age");

        layout.addComponent(grid);
        setContent(layout);

    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
