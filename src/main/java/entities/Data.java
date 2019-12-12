package entities;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "enName", "arName", "state", "routingMethod", "logo", "coverPhoto", "enDescription",
		"arDescription", "shortNumber", "facebookLink", "twitterLink", "youtubeLink", "website", "onlinePayment",
		"client", "pendingInfo", "pendingMenu", "closed" })
public class Data {

	@JsonProperty("enName")
	private String enName;
	@JsonProperty("arName")
	private String arName;
	@JsonProperty("state")
	private String state;
	@JsonProperty("routingMethod")
	private Object routingMethod;
	@JsonProperty("logo")
	private String logo;
	@JsonProperty("coverPhoto")
	private String coverPhoto;
	@JsonProperty("enDescription")
	private String enDescription;
	@JsonProperty("arDescription")
	private String arDescription;
	@JsonProperty("shortNumber")
	private String shortNumber;
	@JsonProperty("facebookLink")
	private String facebookLink;
	@JsonProperty("twitterLink")
	private String twitterLink;
	@JsonProperty("youtubeLink")
	private String youtubeLink;
	@JsonProperty("website")
	private String website;
	@JsonProperty("onlinePayment")
	private Boolean onlinePayment;
	@JsonProperty("client")
	private Boolean client;
	@JsonProperty("pendingInfo")
	private Boolean pendingInfo;
	@JsonProperty("pendingMenu")
	private Boolean pendingMenu;
	@JsonProperty("closed")
	private Boolean closed;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("enName")
	public String getEnName() {
		return enName;
	}

	@JsonProperty("enName")
	public void setEnName(String enName) {
		this.enName = enName;
	}

	@JsonProperty("arName")
	public String getArName() {
		return arName;
	}

	@JsonProperty("arName")
	public void setArName(String arName) {
		this.arName = arName;
	}

	@JsonProperty("state")
	public String getState() {
		return state;
	}

	@JsonProperty("state")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("routingMethod")
	public Object getRoutingMethod() {
		return routingMethod;
	}

	@JsonProperty("routingMethod")
	public void setRoutingMethod(Object routingMethod) {
		this.routingMethod = routingMethod;
	}

	@JsonProperty("logo")
	public String getLogo() {
		return logo;
	}

	@JsonProperty("logo")
	public void setLogo(String logo) {
		this.logo = logo;
	}

	@JsonProperty("coverPhoto")
	public String getCoverPhoto() {
		return coverPhoto;
	}

	@JsonProperty("coverPhoto")
	public void setCoverPhoto(String coverPhoto) {
		this.coverPhoto = coverPhoto;
	}

	@JsonProperty("enDescription")
	public String getEnDescription() {
		return enDescription;
	}

	@JsonProperty("enDescription")
	public void setEnDescription(String enDescription) {
		this.enDescription = enDescription;
	}

	@JsonProperty("arDescription")
	public Object getArDescription() {
		return arDescription;
	}

	@JsonProperty("arDescription")
	public void setArDescription(String arDescription) {
		this.arDescription = arDescription;
	}

	@JsonProperty("shortNumber")
	public String getShortNumber() {
		return shortNumber;
	}

	@JsonProperty("shortNumber")
	public void setShortNumber(String shortNumber) {
		this.shortNumber = shortNumber;
	}

	@JsonProperty("facebookLink")
	public String getFacebookLink() {
		return facebookLink;
	}

	@JsonProperty("facebookLink")
	public void setFacebookLink(String facebookLink) {
		this.facebookLink = facebookLink;
	}

	@JsonProperty("twitterLink")
	public String getTwitterLink() {
		return twitterLink;
	}

	@JsonProperty("twitterLink")
	public void setTwitterLink(String twitterLink) {
		this.twitterLink = twitterLink;
	}

	@JsonProperty("youtubeLink")
	public String getYoutubeLink() {
		return youtubeLink;
	}

	@JsonProperty("youtubeLink")
	public void setYoutubeLink(String youtubeLink) {
		this.youtubeLink = youtubeLink;
	}

	@JsonProperty("website")
	public Object getWebsite() {
		return website;
	}

	@JsonProperty("website")
	public void setWebsite(String website) {
		this.website = website;
	}

	@JsonProperty("onlinePayment")
	public Boolean getOnlinePayment() {
		return onlinePayment;
	}

	@JsonProperty("onlinePayment")
	public void setOnlinePayment(Boolean onlinePayment) {
		this.onlinePayment = onlinePayment;
	}

	@JsonProperty("client")
	public Boolean getClient() {
		return client;
	}

	@JsonProperty("client")
	public void setClient(Boolean client) {
		this.client = client;
	}

	@JsonProperty("pendingInfo")
	public Boolean getPendingInfo() {
		return pendingInfo;
	}

	@JsonProperty("pendingInfo")
	public void setPendingInfo(Boolean pendingInfo) {
		this.pendingInfo = pendingInfo;
	}

	@JsonProperty("pendingMenu")
	public Boolean getPendingMenu() {
		return pendingMenu;
	}

	@Override
	public String toString() {
		return "Data [enName=" + enName + ", arName=" + arName + ", state=" + state + ", routingMethod=" + routingMethod
				+ ", logo=" + logo + ", coverPhoto=" + coverPhoto + ", enDescription=" + enDescription
				+ ", arDescription=" + arDescription + ", shortNumber=" + shortNumber + ", facebookLink=" + facebookLink
				+ ", twitterLink=" + twitterLink + ", youtubeLink=" + youtubeLink + ", website=" + website
				+ ", onlinePayment=" + onlinePayment + ", client=" + client + ", pendingInfo=" + pendingInfo
				+ ", pendingMenu=" + pendingMenu + ", closed=" + closed + ", additionalProperties="
				+ additionalProperties + "]";
	}

	public Data(String enName, String arName, String state, Object routingMethod, String logo, String coverPhoto,
			String enDescription, String arDescription, String shortNumber, String facebookLink, String twitterLink,
			String youtubeLink, String website, Boolean onlinePayment, Boolean client, Boolean pendingInfo,
			Boolean pendingMenu, Boolean closed) {
		super();
		this.enName = enName;
		this.arName = arName;
		this.state = state;
		this.routingMethod = routingMethod;
		this.logo = logo;
		this.coverPhoto = coverPhoto;
		this.enDescription = enDescription;
		this.arDescription = arDescription;
		this.shortNumber = shortNumber;
		this.facebookLink = facebookLink;
		this.twitterLink = twitterLink;
		this.youtubeLink = youtubeLink;
		this.website = website;
		this.onlinePayment = onlinePayment;
		this.client = client;
		this.pendingInfo = pendingInfo;
		this.pendingMenu = pendingMenu;
		this.closed = closed;
	}

	@JsonProperty("pendingMenu")
	public void setPendingMenu(Boolean pendingMenu) {
		this.pendingMenu = pendingMenu;
	}

	@JsonProperty("closed")
	public Boolean getClosed() {
		return closed;
	}

	@JsonProperty("closed")
	public void setClosed(Boolean closed) {
		this.closed = closed;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
