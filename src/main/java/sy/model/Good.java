package sy.model;

public class Good {
    private Integer id;

    private Integer goodquanity;

    private Double goodprice;

    private String goodname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodquanity() {
        return goodquanity;
    }

    public void setGoodquanity(Integer goodquanity) {
        this.goodquanity = goodquanity;
    }

    public Double getGoodprice() {
        return goodprice;
    }

    public void setGoodprice(Double goodprice) {
        this.goodprice = goodprice;
    }

    public String getGoodname() {
        return goodname;
    }

    public void setGoodname(String goodname) {
        this.goodname = goodname == null ? null : goodname.trim();
    }
}