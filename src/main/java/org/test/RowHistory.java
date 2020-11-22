package org.test;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Date;

public class RowHistory {

    private String boardid;
    private String tradedate;
    private String shortname;
    private String secid;
    private String numtrades;
    private String value;
    private String open;
    private String low;
    private String high;
    private String legalcloseprice;
    private String waprice;
    private String close;
    private String volume;
    private String marketprice2;
    private String marketprice3;
    private String admittedquote;
    private String mp2Valtrd;
    private String marketprice3Tradesvalue;
    private String admittedvalue;
    private String waval;

    public RowHistory() {}

    public RowHistory(String boardid, String tradedate, String shortname, String secid, String numtrades, String value, String open, String low,
                      String high, String legalcloseprice, String waprice, String close, String volume, String marketprice2, String marketprice3,
                      String admittedquote, String mp2Valtrd, String marketprice3Tradesvalue, String admittedvalue, String waval) {
        this.boardid = boardid;
        this.tradedate = tradedate;
        this.shortname = shortname;
        this.secid = secid;
        this.numtrades = numtrades;
        this.value = value;
        this.open = open;
        this.low = low;
        this.high = high;
        this.legalcloseprice = legalcloseprice;
        this.waprice = waprice;
        this.close = close;
        this.volume = volume;
        this.marketprice2 = marketprice2;
        this.marketprice3 = marketprice3;
        this.admittedquote = admittedquote;
        this.mp2Valtrd = mp2Valtrd;
        this.marketprice3Tradesvalue = marketprice3Tradesvalue;
        this.admittedvalue = admittedvalue;
        this.waval = waval;
    }

    @XmlAttribute
    public String getBoardid() { return boardid; }
    public void setBoardid(String boardid) { this.boardid = boardid; }

    @XmlAttribute
    public String getTradedate() { return tradedate; }
    public void setTradedate(String tradedate) { this.tradedate = tradedate; }

    @XmlAttribute
    public String getShortname() { return shortname; }
    public void setShortname(String shortname) { this.shortname = shortname; }

    @XmlAttribute
    public String getSecid() { return secid; }
    public void setSecid(String secid) { this.secid = secid; }

    @XmlAttribute
    public String getNumtrades() { return numtrades; }
    public void setNumtrades(String numtrades) { this.numtrades = numtrades; }

    @XmlAttribute
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    @XmlAttribute
    public String getOpen() { return open; }
    public void setOpen(String open) { this.open = open; }

    @XmlAttribute
    public String getLow() { return low; }
    public void setLow(String low) { this.low = low; }

    @XmlAttribute
    public String getHigh() { return high; }
    public void setHigh(String high) { this.high = high; }

    @XmlAttribute
    public String getLegalcloseprice() { return legalcloseprice; }
    public void setLegalcloseprice(String legalcloseprice) { this.legalcloseprice = legalcloseprice; }

    @XmlAttribute
    public String getWaprice() { return waprice; }
    public void setWaprice(String waprice) { this.waprice = waprice; }

    @XmlAttribute
    public String getClose() { return close; }
    public void setClose(String close) { this.close = close; }

    @XmlAttribute
    public String getVolume() { return volume; }
    public void setVolume(String volume) { this.volume = volume; }

    @XmlAttribute
    public String getMarketprice2() { return marketprice2; }
    public void setMarketprice2(String marketprice2) { this.marketprice2 = marketprice2; }

    @XmlAttribute
    public String getMarketprice3() { return marketprice3; }
    public void setMarketprice3(String marketprice3) { this.marketprice3 = marketprice3; }

    @XmlAttribute
    public String getAdmittedquote() { return admittedquote; }
    public void setAdmittedquote(String admittedquote) { this.admittedquote = admittedquote; }

    @XmlAttribute
    public String getMp2Valtrd() { return mp2Valtrd; }
    public void setMp2Valtrd(String mp2Valtrd) { this.mp2Valtrd = mp2Valtrd; }

    @XmlAttribute
    public String getMarketprice3Tradesvalue() { return marketprice3Tradesvalue; }
    public void setMarketprice3Tradesvalue(String marketprice3Tradesvalue) { this.marketprice3Tradesvalue = marketprice3Tradesvalue; }

    @XmlAttribute
    public String getAdmittedvalue() { return admittedvalue; }
    public void setAdmittedvalue(String admittedvalue) { this.admittedvalue = admittedvalue; }

    @XmlAttribute
    public String getWaval() { return waval; }
    public void setWaval(String waval) { this.waval = waval; }
}