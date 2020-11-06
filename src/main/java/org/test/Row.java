package org.test;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlType(propOrder = {
        "id",
        "secid",
        "shortname",
        "regnumber",
        "name",
        "isin",
        "is_traded",
        "emitent_id",
        "emitent_title",
        "emitent_inn",
        "emitent_okpo",
        "gosreg",
        "type",
        "group",
        "primary_boardid",
        "marketprice_boardid"})
public class Row {
    private int id;
    private String secid;
    private String shortname;
    private String regnumber;
    private String name;
    private String isin;
    private int is_traded;
    private int emitent_id;
    private String emitent_title;
    private String emitent_inn;
    private String emitent_okpo;
    private String gosreg;
    private String type;
    private String group;
    private String primary_boardid;
    private String marketprice_boardid;

    @XmlAttribute
    public int getId() {
        return id;
    }
    public void setId (int id) { this.id = id; }
    @XmlAttribute
    public String getSecid() {
        return secid;
    }
    @XmlAttribute
    public String getShortname() {
        return shortname;
    }
    @XmlAttribute
    public String getRegnumber() {
        return regnumber;
    }
    @XmlAttribute
    public String getName() {
        return name;
    }
    @XmlAttribute
    public String getIsin() {
        return isin;
    }
    @XmlAttribute
    public int getIs_traded() {
        return is_traded;
    }
    @XmlAttribute
    public int getEmitent_id() {
        return emitent_id;
    }
    @XmlAttribute
    public String getEmitent_title() {
        return emitent_title;
    }
    public void setEmitent_title (String emitent_title) { this.emitent_title = emitent_title;}
    @XmlAttribute
    public String getEmitent_inn() {
        return emitent_inn;
    }
    @XmlAttribute
    public String getEmitent_okpo() {
        return emitent_okpo;
    }
    @XmlAttribute
    public String getGosreg() {
        return gosreg;
    }
    @XmlAttribute
    public String getType() {
        return type;
    }
    @XmlAttribute
    public String getGroup() {
        return group;
    }
    @XmlAttribute
    public String getPrimary_boardid() {
        return primary_boardid;
    }
    @XmlAttribute
    public String getMarketprice_boardid() {
        return marketprice_boardid;
    }

    public Row() {}

    public Row(int id, String secid, String shortname, String regnumber, String name, String isin, int is_traded,
               int emitent_id, String emitent_title, String emitent_inn, String emitent_okpo, String gosreg,
               String type, String group, String primary_boardid, String marketprice_boardid) {
        this.id = id;
        this.secid = secid;
        this.shortname = shortname;
        this.regnumber = regnumber;
        this.name = name;
        this.isin = isin;
        this.is_traded = is_traded;
        this.emitent_id = emitent_id;
        this.emitent_title = emitent_title;
        this.emitent_inn = emitent_inn;
        this.emitent_okpo = emitent_okpo;
        this.gosreg = gosreg;
        this.type = type;
        this.group = group;
        this.primary_boardid = primary_boardid;
        this.marketprice_boardid = marketprice_boardid;
    }
}
