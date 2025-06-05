package com.tcs.users.model;

public class Bookings {
	private int bookingId;
	private String senderName;
	private String senderAddress;
	private String recipientName;
	private String recipientAddress;
	private String parcelWeight;
	private String parcelContentsDescription;
	private String parcelDeliveryType;
	private String parcelPackingPreference;
	private String parcelPickupTime;
	private String parcelDropoffTime;
	private String parcelServiceCost;
	private String parcelPaymentTime;
	private String status;
	private String trackingId;
	
	public Bookings(int bookingId, String senderName, String senderAddress, String recipientName,
			String recipientAddress, String parcelWeight, String parcelContentsDescription, String parcelDeliveryType,
			String parcelPackingPreference, String parcelPickupTime, String parcelDropoffTime, String parcelServiceCost,
			String parcelPaymentTime, String status, String trackingId) {
		super();
		this.bookingId = bookingId;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.recipientName = recipientName;
		this.recipientAddress = recipientAddress;
		this.parcelWeight = parcelWeight;
		this.parcelContentsDescription = parcelContentsDescription;
		this.parcelDeliveryType = parcelDeliveryType;
		this.parcelPackingPreference = parcelPackingPreference;
		this.parcelPickupTime = parcelPickupTime;
		this.parcelDropoffTime = parcelDropoffTime;
		this.parcelServiceCost = parcelServiceCost;
		this.parcelPaymentTime = parcelPaymentTime;
		this.status = status;
		this.trackingId=trackingId;
	}

	public String getTrackingId() {
		return trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public Bookings() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public String getRecipientName() {
		return recipientName;
	}

	public void setRecipientName(String recipientName) {
		this.recipientName = recipientName;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getParcelWeight() {
		return parcelWeight;
	}

	public void setParcelWeight(String parcelWeight) {
		this.parcelWeight = parcelWeight;
	}

	public String getParcelContentsDescription() {
		return parcelContentsDescription;
	}

	public void setParcelContentsDescription(String parcelContentsDescription) {
		this.parcelContentsDescription = parcelContentsDescription;
	}

	public String getParcelDeliveryType() {
		return parcelDeliveryType;
	}

	public void setParcelDeliveryType(String parcelDeliveryType) {
		this.parcelDeliveryType = parcelDeliveryType;
	}

	public String getParcelPackingPreference() {
		return parcelPackingPreference;
	}

	public void setParcelPackingPreference(String parcelPackingPreference) {
		this.parcelPackingPreference = parcelPackingPreference;
	}

	public String getParcelPickupTime() {
		return parcelPickupTime;
	}

	public void setParcelPickupTime(String parcelPickupTime) {
		this.parcelPickupTime = parcelPickupTime;
	}

	public String getParcelDropoffTime() {
		return parcelDropoffTime;
	}

	public void setParcelDropoffTime(String parcelDropoffTime) {
		this.parcelDropoffTime = parcelDropoffTime;
	}

	public String getParcelServiceCost() {
		return parcelServiceCost;
	}

	public void setParcelServiceCost(String parcelServiceCost) {
		this.parcelServiceCost = parcelServiceCost;
	}

	public String getParcelPaymentTime() {
		return parcelPaymentTime;
	}

	public void setParcelPaymentTime(String parcelPaymentTime) {
		this.parcelPaymentTime = parcelPaymentTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bookings [bookingId=" + bookingId + ", senderName=" + senderName + ", senderAddress=" + senderAddress
				+ ", recipientName=" + recipientName + ", recipientAddress=" + recipientAddress + ", parcelWeight="
				+ parcelWeight + ", parcelContentsDescription=" + parcelContentsDescription + ", parcelDeliveryType="
				+ parcelDeliveryType + ", parcelPackingPreference=" + parcelPackingPreference + ", parcelPickupTime="
				+ parcelPickupTime + ", parcelDropoffTime=" + parcelDropoffTime + ", parcelServiceCost="
				+ parcelServiceCost + ", parcelPaymentTime=" + parcelPaymentTime + ", status=" + status
				+ ", trackingId=" + trackingId + "]";
	}

//	@Override
//	public String toString() {
//		return "Bookings [bookingId=" + bookingId + ", senderName=" + senderName + ", senderAddress=" + senderAddress
//				+ ", recipientName=" + recipientName + ", recipientAddress=" + recipientAddress + ", parcelWeight="
//				+ parcelWeight + ", parcelContentsDescription=" + parcelContentsDescription + ", parcelDeliveryType="
//				+ parcelDeliveryType + ", parcelPackingPreference=" + parcelPackingPreference + ", parcelPickupTime="
//				+ parcelPickupTime + ", parcelDropoffTime=" + parcelDropoffTime + ", parcelServiceCost="
//				+ parcelServiceCost + ", parcelPaymentTime=" + parcelPaymentTime + ", status=" + status + "]";
//	}
	
	
	

}
