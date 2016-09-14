package sy.model;

public class Detail {
	private Long orderId;

	private Long detailId;

	

	private String detailGoodName;

	private Double detailGoodPrice;

	private Integer detailGoodQuantity;

	private Double detailGoodTotalprice;

	private Integer detailIsComplete;

	private String detailCompleter;

	private Integer detailIsCancel;
	
	public Long getDetailId() {
		return detailId;
	}

	public void setDetailId(Long detailId) {
		this.detailId = detailId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDetailGoodName() {
		return detailGoodName;
	}

	public void setDetailGoodName(String detailGoodName) {
		this.detailGoodName = detailGoodName == null ? null : detailGoodName
				.trim();
	}

	public Double getDetailGoodPrice() {
		return detailGoodPrice;
	}

	public void setDetailGoodPrice(Double detailGoodPrice) {
		this.detailGoodPrice = detailGoodPrice;
	}

	public Integer getDetailGoodQuantity() {
		return detailGoodQuantity;
	}

	public void setDetailGoodQuantity(Integer detailGoodQuantity) {
		this.detailGoodQuantity = detailGoodQuantity;
	}

	public Double getDetailGoodTotalprice() {
		return detailGoodTotalprice;
	}

	public void setDetailGoodTotalprice(Double detailGoodTotalprice) {
		this.detailGoodTotalprice = detailGoodTotalprice;
	}

	public Integer getdetailIsComplete() {
		return detailIsComplete;
	}

	public void setdetailIsComplete(Integer detailIsComplete) {
		this.detailIsComplete = detailIsComplete;
	}

	public String getDetailCompleter() {
		return detailCompleter;
	}

	public void setDetailCompleter(String detailCompleter) {
		this.detailCompleter = detailCompleter == null ? null : detailCompleter
				.trim();
	}

	public Integer getdetailIsCancel() {
		return detailIsCancel;
	}

	public void setdetailIsCancel(Integer detailIsCancel) {
		this.detailIsCancel = detailIsCancel;
	}
}