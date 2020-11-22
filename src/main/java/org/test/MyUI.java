package org.test;

import javax.servlet.annotation.WebServlet;
import javax.xml.bind.JAXBException;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

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
    private Securities securities;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        try {
            securities = Parser.fromXml();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        History history = new History();
        HistoryData historyData = new HistoryData();
        HistoryData.Metadata metadata = new HistoryData.Metadata();
        historyData.setMetadata(metadata);
        historyData.getMetadata().getColumns().add(new Column("sdfs", "sdfs", "sdfs", "sdfs"));
        historyData.getMetadata().getColumns().add(new Column("sdfs324", "sd234fs", "sddfghfs", "sdshtfs"));
        historyData.getMetadata().getColumns().add(new Column("sdfs234", "sd3456fs", "sdfghjfs", "sdfsdfhs"));
        historyData.getRowHistories().add(new RowHistory("TQBR", "2020-04-15", "АбрауДюрсо", "ABRD", "171", "734875", "135.5", "133.5", "136.5", "134.5", "135",
                "134.5", "5440", "135", "135", "134.5", "734875", "734875", "734875", ""));
        historyData.setId("history");
        history.getHistoryDataList().add(historyData);

        HistoryData historyData1 = new HistoryData();
        HistoryData.Metadata metadata1 = new HistoryData.Metadata();
        historyData1.setMetadata(metadata1);
        historyData1.getMetadata().getColumns().add(new Column("INDEX", "int64", "", ""));
        historyData1.getMetadata().getColumns().add(new Column("TOTAL", "int64", "", ""));
        historyData1.getMetadata().getColumns().add(new Column("PAGESIZE", "int64", "", ""));
        historyData1.getRowHistories().add(new RowHistory("TQBR", "2020-04-15", "АбрауДюрсо", "ABRD", "171", "734875", "135.5", "133.5", "136.5", "134.5", "135",
                "134.5", "5440", "135", "135", "134.5", "734875", "734875", "734875", ""));
        historyData1.setId("history.cursor");
        history.getHistoryDataList().add(historyData1);
        try {
            Parser.toXmlHistory(history);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        List<RowSecurities> columns = securities.getData().getRowSecurities();
        Grid<RowSecurities> grid = new Grid<>();
        grid.setItems(columns);
        grid.addColumn(RowSecurities::getSecid).setCaption("Secid");
        grid.addColumn(RowSecurities::getShortname).setCaption("Name");
//        grid.addContextClickListener(contextClickEvent -> {
//            System.out.println("contextClickEvent " + contextClickEvent.toString());
//        });
        grid.setSizeFull();
        layout.addComponent(grid);

        Button create = new Button("Создать");
        create.addClickListener(clickEvent -> {

            CreateWindow window = new CreateWindow(securities);
            UI.getCurrent().addWindow(window);
        });

        Button open = new Button("Открыть");
        open.addClickListener(clickEvent -> {
            OpenWindow window = new OpenWindow(grid);
            UI.getCurrent().addWindow(window);
        });
        layout.addComponents(create, open);

        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
