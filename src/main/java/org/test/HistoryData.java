package org.test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

public class HistoryData {

    public HistoryData () {}

    private String id;
    private Metadata metadata;

    @XmlAttribute
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    @XmlElement
    public Metadata getMetadata() { return metadata; }
    public void setMetadata(Metadata metadata) { this.metadata = metadata; }

    static class Metadata {

        private List<Column> columns;

        @XmlElementWrapper
        @XmlElement(name = "column")
        public List<Column> getColumns() {
            if (columns == null) {
                columns = new ArrayList<>();
            }
            return columns;
        }
    }

    private List<RowHistory> rowHistories;

    @XmlElementWrapper(name = "rows")
    @XmlElement(name = "row")
    public List<RowHistory> getRowHistories() {
        if(rowHistories == null) {
            rowHistories = new ArrayList<>();
        }
        return rowHistories;
    }
}