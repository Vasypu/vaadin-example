package org.test;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "document")
public class Document {
    private Data data;

    @XmlElement
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    static class Data {

        private String id;
        private Metadata metadata;

        @XmlAttribute
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        @XmlElement
        public Metadata getMetadata() {
            return metadata;
        }

        public void setMetadata(Metadata metadata) {
            this.metadata = metadata;
        }

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

        private List<Row> rows;

        @XmlElementWrapper(name = "rows")
        @XmlElement(name = "row")
        public List<Row> getRows() {
            if(rows == null) {
                rows = new ArrayList<>();
            }
            return rows;
        }
    }
}