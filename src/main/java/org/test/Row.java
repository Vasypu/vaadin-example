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
    public int getId() { return id; }
    public void setId (int id) { this.id = id; }

    @XmlAttribute
    public String getSecid() { return secid; }
    public void setSecid(String secid) { this.secid = secid; }

    @XmlAttribute
    public String getShortname() { return shortname; }
    public void setShortname(String shortname) { this.shortname = shortname; }

    @XmlAttribute
    public String getRegnumber() { return regnumber; }
    public void setRegnumber(String regnumber) { this.regnumber = regnumber; }

    @XmlAttribute
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @XmlAttribute
    public String getIsin() { return isin; }
    public void setIsin(String isin) { this.isin = isin; }

    @XmlAttribute
    public int getIs_traded() { return is_traded; }
    public void setIs_traded(int is_traded) { this.is_traded = is_traded; }

    @XmlAttribute
    public int getEmitent_id() { return emitent_id; }
    public void setEmitent_id(int emitent_id) { this.emitent_id = emitent_id; }

    @XmlAttribute
    public String getEmitent_title() { return emitent_title; }
    public void setEmitent_title (String emitent_title) { this.emitent_title = emitent_title;}

    @XmlAttribute
    public String getEmitent_inn() { return emitent_inn; }
    public void setEmitent_inn(String emitent_inn) { this.emitent_inn = emitent_inn; }

    @XmlAttribute
    public String getEmitent_okpo() { return emitent_okpo; }
    public void setEmitent_okpo(String emitent_okpo) { this.emitent_okpo = emitent_okpo; }

    @XmlAttribute
    public String getGosreg() { return gosreg; }
    public void setGosreg(String gosreg) { this.gosreg = gosreg; }

    @XmlAttribute
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    @XmlAttribute
    public String getGroup() { return group; }
    public void setGroup(String group) { this.group = group; }

    @XmlAttribute
    public String getPrimary_boardid() { return primary_boardid; }
    public void setPrimary_boardid(String primary_boardid) { this.primary_boardid = primary_boardid; }

    @XmlAttribute
    public String getMarketprice_boardid() { return marketprice_boardid; }
    public void setMarketprice_boardid(String marketprice_boardid) { this.marketprice_boardid = marketprice_boardid; }

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
