package org.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Parser {

    public static Securities fromXml () throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Securities.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Securities securities = (Securities) unmarshaller.unmarshal(new File("/root/Загрузки/secur.xml"));
        return securities;
    }

    public static void toXml (Securities securities) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Securities.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(securities, new File("/root/Загрузки/secur.xml"));
    }

    public static History fromXmlHistory () throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(History.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        History history = (History) unmarshaller.unmarshal(new File("/root/Загрузки/history.xml"));
        return history;
    }

    public static void toXmlHistory (History history) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(History.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(history, new File("/root/Загрузки/history.xml"));
    }
}
