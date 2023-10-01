package com.example.tie2.models;

import com.example.tie2.dtos.RemoteControlDto;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "televisions")
public class Television {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "type")
    private String type;
    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "available_size")
    private double availableSize;

    @Column(name = "refresh_rate")
    private double refreshRate;

    @Column(name = "screen_type")
    private String screenType;

    @Column(name = "screen_quality")
    private String screenQuality;

    @Column(name = "smart_tv")
    private boolean smartTv;

    @Column(name = "wifi")
    private boolean wifi;

    @Column(name = "voice_control")
    private boolean voiceControl;

    @Column(name = "hdr")
    private boolean hdr;
    @Column(name = "blue_tooth")
    private boolean bluetooth;

    @Column(name = "ambi_light")
    private boolean ambiLight;

    @Column(name = "original_stock")
    private Integer originalStock;
    @Column(name = "sold")
    private Integer sold;

    @Column(name = "date_of_purchase")
    private LocalDate dateOfPurchase;

    @Column(name = "current_stock")
    private Integer currentStock;

    @Enumerated(EnumType.STRING)
    @Column(name = "energy_label")
    private EnergyLabel energyLabel; // pulling from enum class //


    // 1. Establishing A one-to-one relation between Television and Remote Control //
    @OneToOne
    @JoinColumn(name = "compatible_remote_control")
    private RemoteControl remoteControl;

    //Establishing ManToOne with CiModule //
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "compatible_ci_module")
    // this is the name we gave the joined column - this usually is ci_module_id //
    private CiModule ciModule;

    //Establishing ManyToMany with WallBracket //
    @ManyToMany
    private List<WallBracket> wallBracketList;

// for every television the is ONE remote control //

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

    public LocalDate getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(LocalDate dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public EnergyLabel getEnergyLabel() {
        return energyLabel;
    }

    public void setEnergyLabel(EnergyLabel energyLabel) {
        this.energyLabel = energyLabel;
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

    // Part of step 1. getter and setter for the Remote Control DTO ?  - which Television has a one-to-one relation //


    public RemoteControl getRemoteControl() {
        return remoteControl;
    }

    public void setRemoteControl(RemoteControl remoteControl) {
        this.remoteControl = remoteControl;
    }

    public CiModule getCiModule() {
        return ciModule;
    }

    public void setCiModule(CiModule ciModule) {
        this.ciModule = ciModule;
    }
}

