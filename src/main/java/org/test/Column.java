package org.test;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {
        "name",
        "type",
        "bytes",
        "max_size"})
public class Column {
    private String name;
    private String type;
    private String bytes;
    private String max_size;

    @XmlAttribute
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute
    public String getBytes() {
        return bytes;
    }

    public void setBytes(String bytes) {
        this.bytes = bytes;
    }

    @XmlAttribute
    public String getMax_size() {
        return max_size;
    }

    public void setMax_size(String max_size) {
        this.max_size = max_size;
    }

    public Column() {}

    public Column(String name, String type, String bytes, String max_size) {
        this.name = name;
        this.type = type;
        this.bytes = bytes;
        this.max_size = max_size;
    }
}
