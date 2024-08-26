package com.girlvengers.gvc.vo;

public class CSVVo {

    private String bankName; //저축은행명
    private String prodName; //상품명
    private Long rate; //약정금리
    private Long afterTaxRate; //세후금리
    private Long primeRate; //최고우대금리
    private Long earlyEndRate; //중도해지금리

    public CSVVo(){}

    public CSVVo(String bankName, String prodName, Long rate, Long afterTaxRate, Long primeRate, Long earlyEndRate) {
        this.bankName = bankName;
        this.prodName = prodName;
        this.rate = rate;
        this.afterTaxRate = afterTaxRate;
        this.primeRate = primeRate;
        this.earlyEndRate = earlyEndRate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public Long getAfterTaxRate() {
        return afterTaxRate;
    }

    public void setAfterTaxRate(Long afterTaxRate) {
        this.afterTaxRate = afterTaxRate;
    }

    public Long getPrimeRate() {
        return primeRate;
    }

    public void setPrimeRate(Long primeRate) {
        this.primeRate = primeRate;
    }

    public Long getEarlyEndRate() {
        return earlyEndRate;
    }

    public void setEarlyEndRate(Long earlyEndRate) {
        this.earlyEndRate = earlyEndRate;
    }
}
