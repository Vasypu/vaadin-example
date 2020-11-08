package org.test;

import com.vaadin.ui.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateWindow extends Window {
    final VerticalLayout layout1 = new VerticalLayout();
    final VerticalLayout layout2 = new VerticalLayout();
    final HorizontalLayout horizontalLayout = new HorizontalLayout();
    private Document document;

    public CreateWindow (Document document) {
        this.document = document;

        TextField id = new TextField("id");
        id.setWidth(250, Unit.PIXELS);
        TextField secid = new TextField("secid");
        secid.setWidth(250, Unit.PIXELS);
        TextField shortname = new TextField("shortname");
        shortname.setWidth(250, Unit.PIXELS);
        TextField regnumber = new TextField("regnumber");
        regnumber.setWidth(250, Unit.PIXELS);
        TextField name = new TextField("name");
        name.setWidth(250, Unit.PIXELS);
        TextField isin = new TextField("isin");
        isin.setWidth(250, Unit.PIXELS);
        TextField is_traded = new TextField("is_traded");
        is_traded.setWidth(250, Unit.PIXELS);
        TextField emitent_id = new TextField("emitent_id");
        emitent_id.setWidth(250, Unit.PIXELS);
        TextField emitent_title = new TextField("emitent_title");
        emitent_title.setWidth(250, Unit.PIXELS);
        TextField emitent_inn = new TextField("emitent_inn");
        emitent_inn.setWidth(250, Unit.PIXELS);
        TextField emitent_okpo = new TextField("emitent_okpo");
        emitent_okpo.setWidth(250, Unit.PIXELS);
        TextField gosreg = new TextField("gosreg");
        gosreg.setWidth(250, Unit.PIXELS);
        TextField type = new TextField("type");
        type.setWidth(250, Unit.PIXELS);
        TextField group = new TextField("group");
        group.setWidth(250, Unit.PIXELS);
        TextField primary_boardid = new TextField("primary_boardid");
        primary_boardid.setWidth(250, Unit.PIXELS);
        TextField marketprice_boardid = new TextField("marketprice_boardid");
        marketprice_boardid.setWidth(250, Unit.PIXELS);

        layout1.addComponents(id, secid, shortname, regnumber, name, isin, is_traded, emitent_id);
        layout2.addComponents(emitent_title, emitent_inn, emitent_okpo, gosreg, type, group, primary_boardid, marketprice_boardid);

        Row row = new Row();
        row.setId(35);
        row.setIs_traded(54);
        row.setEmitent_id(4);

        secid.addValueChangeListener(valueChangeEvent -> row.setSecid(valueChangeEvent.getValue()));
        shortname.addValueChangeListener(valueChangeEvent -> row.setShortname(valueChangeEvent.getValue()));
        regnumber.addValueChangeListener(valueChangeEvent -> row.setRegnumber(valueChangeEvent.getValue()));
        name.addValueChangeListener(valueChangeEvent -> row.setName(valueChangeEvent.getValue()));
        isin.addValueChangeListener(valueChangeEvent -> row.setIsin(valueChangeEvent.getValue()));
//            is_traded.addValueChangeListener(valueChangeEvent -> row.setIs_traded(valueChangeEvent.getValue()));
//            emitent_id.addValueChangeListener(valueChangeEvent -> row.setEmitent_id(valueChangeEvent.getValue()));
        emitent_title.addValueChangeListener(valueChangeEvent -> row.setEmitent_title(valueChangeEvent.getValue()));
        emitent_inn.addValueChangeListener(valueChangeEvent -> row.setEmitent_inn(valueChangeEvent.getValue()));
        emitent_okpo.addValueChangeListener(valueChangeEvent -> row.setEmitent_okpo(valueChangeEvent.getValue()));
        gosreg.addValueChangeListener(valueChangeEvent -> row.setGosreg(valueChangeEvent.getValue()));
        type.addValueChangeListener(valueChangeEvent -> row.setType(valueChangeEvent.getValue()));
        group.addValueChangeListener(valueChangeEvent -> row.setGroup(valueChangeEvent.getValue()));
        primary_boardid.addValueChangeListener(valueChangeEvent -> row.setPrimary_boardid(valueChangeEvent.getValue()));
        marketprice_boardid.addValueChangeListener(valueChangeEvent -> row.setMarketprice_boardid(valueChangeEvent.getValue()));

        document.getData().getRows().add(row);

        List<Column> columnList = Arrays.asList(new Column("id", "int32", "", ""),
                new Column("secid","string","36","0"),
                new Column("shortname", "string", "189", "0"),
                new Column("regnumber", "string", "189", "0"),
                new Column("name", "string", "765", "0"),
                new Column("isin", "string", "765", "0"),
                new Column("is_traded", "int32", "", ""),
                new Column("emitent_id", "int32", "", ""),
                new Column("emitent_title", "string", "765", "0"),
                new Column("emitent_inn", "string", "30", "0"),
                new Column("emitent_okpo", "string", "24", "0"),
                new Column("gosreg", "string", "189", "0"),
                new Column("type", "string", "93", "0"),
                new Column("group", "string", "93", "0"),
                new Column("primary_boardid", "string", "12", "0"),
                new Column("marketprice_boardid", "string", "12", "0"));

        if (!document.getData().getMetadata().getColumns().equals(columnList)) {
            document.getData().getMetadata().getColumns().clear();
            document.getData().getMetadata().getColumns().addAll(columnList);
        }

        document.getData().setId("securities");

        Button create = new Button("Создать");
        create.addClickListener(clickEvent -> {
            try {
                Parser.toXml(document);
            } catch (JAXBException e) {
                e.printStackTrace();
            }
            close();
        });

        setSizeFull();
        layout1.addComponent(create);
        horizontalLayout.addComponent(layout1);
        horizontalLayout.addComponent(layout2);
        setContent(horizontalLayout);
    }
}