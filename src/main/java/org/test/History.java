package org.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "document")
@XmlType(propOrder = {
        "historyDataList"})
public class History {

    private List<HistoryData> historyDataList;

//    @XmlElementWrapper
    @XmlElement(name = "data")
    public List<HistoryData> getHistoryDataList() {
        if (historyDataList == null) {
            historyDataList = new ArrayList<>();
        }
        return historyDataList;
    }
}
