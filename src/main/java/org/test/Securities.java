package org.test;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "document")
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
public class Securities {
    @XmlElement
    public int getId() {
        return id;
    }
    @XmlElement
    public String getSecid() {
        return secid;
    }
    @XmlElement
    public String getShortname() {
        return shortname;
    }
    @XmlElement
    public String getRegnumber() {
        return regnumber;
    }
    @XmlElement
    public String getName() {
        return name;
    }
    @XmlElement
    public String getIsin() {
        return isin;
    }
    @XmlElement
    public int getIs_traded() {
        return is_traded;
    }
    @XmlElement
    public int getEmitent_id() {
        return emitent_id;
    }
    @XmlElement
    public String getEmitent_title() {
        return emitent_title;
    }
    @XmlElement
    public String getEmitent_inn() {
        return emitent_inn;
    }
    @XmlElement
    public String getEmitent_okpo() {
        return emitent_okpo;
    }
    @XmlElement
    public String getGosreg() {
        return gosreg;
    }
    @XmlElement
    public String getType() {
        return type;
    }
    @XmlElement
    public String getGroup() {
        return group;
    }
    @XmlElement
    public String getPrimary_boardid() {
        return primary_boardid;
    }
    @XmlElement
    public String getMarketprice_boardid() {
        return marketprice_boardid;
    }

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

    public Securities () {}

    public Securities(int id, String secid, String shortname, String regnumber, String name, String isin, int is_traded,
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
