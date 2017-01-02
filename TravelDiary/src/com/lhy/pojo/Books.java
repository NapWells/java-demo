package com.lhy.pojo;

public class Books {
	private String bookUrl;
	private String title;
	private String headImage;
	private String userName;
	private String userHeadImg;
	private String startTime;
	private String routeDays;
	private String bookImgNum;
	private String viewCount;
	private String likeCount;
	private String commentCount;
	private String text;
	private boolean elite;
	public String getBookUrl() {
		return bookUrl;
	}
	public void setBookUrl(String bookUrl) {
		this.bookUrl = bookUrl;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getHeadImage() {
		return headImage;
	}
	public void setHeadImage(String headImage) {
		this.headImage = headImage;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserHeadImg() {
		return userHeadImg;
	}
	public void setUserHeadImg(String userHeadImg) {
		this.userHeadImg = userHeadImg;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getRouteDays() {
		return routeDays;
	}
	public void setRouteDays(String routeDays) {
		this.routeDays = routeDays;
	}
	public String getBookImgNum() {
		return bookImgNum;
	}
	public void setBookImgNum(String bookImgNum) {
		this.bookImgNum = bookImgNum;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public String getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}
	public String getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(String commentCount) {
		this.commentCount = commentCount;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public boolean isElite() {
		return elite;
	}
	public void setElite(boolean elite) {
		this.elite = elite;
	}
	@Override
	public String toString() {
		return "Books [bookUrl=" + bookUrl + ", title=" + title + ", headImage=" + headImage + ", userName=" + userName
				+ ", userHeadImg=" + userHeadImg + ", startTime=" + startTime + ", routeDays=" + routeDays
				+ ", bookImgNum=" + bookImgNum + ", viewCount=" + viewCount + ", likeCount=" + likeCount
				+ ", commentCount=" + commentCount + ", text=" + text + ", elite=" + elite + "]";
	}
	
}
