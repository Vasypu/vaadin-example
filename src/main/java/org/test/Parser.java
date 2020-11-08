package org.test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class Parser {

    public static Document fromXml () throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Document document = (Document) unmarshaller.unmarshal(new File("/root/Загрузки/secur.xml"));
        return document;
    }

    public static void toXml (Document document) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Document.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(document, new File("/root/Загрузки/secur.xml"));
    }
}
