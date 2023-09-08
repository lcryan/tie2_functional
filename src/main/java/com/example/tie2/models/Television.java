package com.example.tie2.models;

import jakarta.persistence.*;

import javax.sound.midi.SysexMessage;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table
public class Television {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "availableSize")
    private double availableSize;

    @Column(name = "refreshRate")
    private double refreshRate;

    @Column(name = "screenType")
    private String screenType;

    @Column(name = "screenQuality")
    private String screenQuality;

    @Column(name = "smartTv")
    private boolean smartTv;

    @Column(name = "wifi")
    private boolean wifi;

    @Column(name = "voiceControl")
    private boolean voiceControl;

    @Column(name = "hdr")
    private boolean hdr;
    @Column(name = "bluetooth")
    private boolean bluetooth;

    @Column(name = "ambiLight")
    private boolean ambiLight;

    @Column(name = "originalStock")
    private Integer originalStock;
    @Column(name = "sold")
    private Integer sold;

    @Column(name = "dateOfPurchase")
    private LocalDate dateOfPurchase;

    @Column(name = "currentStock")
    private LocalDateTime currentStock;




    public Television(Long id, String type, String brand, String name, double price, double availableSize, double refreshRate, String screenType, String screenQuality, boolean smartTv, boolean wifi, boolean voiceControl, boolean hdr, boolean bluetooth, boolean ambiLight, Integer originalStock, Integer sold, LocalDate dateOfPurchase, LocalDateTime currentStock) {
        this.id = id;
        this.type = type;
        this.brand = brand;
        this.name = name;
        this.price = price;
        this.availableSize = availableSize;
        this.refreshRate = refreshRate;
        this.screenType = screenType;
        this.screenQuality = screenQuality;
        this.smartTv = smartTv;
        this.wifi = wifi;
        this.voiceControl = voiceControl;
        this.hdr = hdr;
        this.bluetooth = bluetooth;
        this.ambiLight = ambiLight;
        this.originalStock = originalStock;
        this.sold = sold;
        this.dateOfPurchase = dateOfPurchase;
        this.currentStock = currentStock;
    }

    public Television() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(double availableSize) {
        this.availableSize = availableSize;
    }

    public double getRefreshRate() {
        return refreshRate;
    }

    public void setRefreshRate(double refreshRate) {
        this.refreshRate = refreshRate;
    }

    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    public String getScreenQuality() {
        return screenQuality;
    }

    public void setScreenQuality(String screenQuality) {
        this.screenQuality = screenQuality;
    }

    public boolean isSmartTv() {
        return smartTv;
    }

    public void setSmartTv(boolean smartTv) {
        this.smartTv = smartTv;
    }

    public boolean isWifi() {
        return wifi;
    }

    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }

    public boolean isVoiceControl() {
        return voiceControl;
    }

    public void setVoiceControl(boolean voiceControl) {
        this.voiceControl = voiceControl;
    }

    public boolean isHdr() {
        return hdr;
    }

    public void setHdr(boolean hdr) {
        this.hdr = hdr;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }

    public void setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
    }

    public boolean isAmbiLight() {
        return ambiLight;
    }

    public void setAmbiLight(boolean ambiLight) {
        this.ambiLight = ambiLight;
    }

    public Integer getOriginalStock() {
        return originalStock;
    }

    public void setOriginalStock(Integer originalStock) {
        this.originalStock = originalStock;
    }

    public Integer getSold() {
        return sold;
    }

    public void setSold(Integer sold) {
        this.sold = sold;
    }
}

//3.TODO: add different values than String, int, boolean or double - look at the bonus assignment below:
/*
Een television heeft best veel variabelen, maar er zit nog weinig variatie in de types. Het zijn enkel Strings, Booleans of nummers. Probeer andere datatypes te gebruiken zoals:

        een Datum voor sold (verkoopDatum) of originalStock (inkoopDatum) (er zijn in Java verschillende opties om een datum te maken)
        Een enumeratie voor een of meerdere van availableSize, refreshRate, screenType en screenQuality
        Zoek zelf op Baeldung, W3, GeeksForGeeks, etc op hoe je zulke datatypes maakt.
        Let er ook op hoe dit in je database komt te staan, is dit anders dan andere datatypes?
        Let er ook op dat je deze datatypes goed in postman invoert. Ook dit kun je op internet vinden, maar kun je ook met de ouderwetse gis-en-mis-methode vinden.
        Let op: je mag ook andere types proberen, maar je kunt (nog) geen lijsten of andere soorten collecties gebruiken. Elke variabele wordt een kolom in de databasetabel. In zo'n kolom kan maar 1 waarde staan, niet en hele lijst van waardes.*/
