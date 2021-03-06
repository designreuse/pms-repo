package com.jpa.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import com.app.exception.Required;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pm_site")
public class Site implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1241308826965453415L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="site_id" , unique=true, nullable=false)
	private Long siteId;

	@Column(name="site_code")
	private String siteCode;

	@Column(name="site_name", nullable=false)
	@Required
	private String siteName;

	@Column(name="district_id")
	private Long districtId;


	@Column(name="area_id")
	private Long areaId;

	@Column(name="cluster_id")
	private Long clusterId;

	@Column(name="site_owner", nullable=false)
	@Required
	private String siteOwner;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="operator_id")
	private Company operator;


	@Column(name="attachment_path")
	private String attachmentPath;

	@Column(name="site_address")
	private String siteAddress;

	@Column(name="post_code")
	private String postCode;

	private String latitude;

	private String longitude;

	@Column(name="contact_name", nullable=false)
	@Required
	private String areaManagerName;

	@Column(name="primary_contact_number", nullable=false)
	@Required
	private BigInteger primaryContact;

	@Column(name="alt_contact_number")
	private BigInteger secondaryContact;

	@Column(name="email", nullable=false)
	@Required
	private String email;

	@Column(name="elec_id_no")
	private String electricIdNo;

	@Column(name="site_number1", nullable=false)
	@Required
	private Long siteNumberOne;

	@Column(name="site_number2")
	private Long siteNumberTwo;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="site",cascade=CascadeType.ALL)
	private List<SiteLicence> siteLicences;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="site",cascade=CascadeType.ALL)
	private List<SiteDeliveryOperation> siteDeliveryOpetaionTimes;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="site",cascade=CascadeType.ALL)
	private List<SiteSalesOperation> siteSalesOpetaionTimes;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="site",cascade=CascadeType.ALL)
	private List<SiteSubMeter> siteSubmeterList;

	@OneToMany(mappedBy="site", fetch = FetchType.LAZY)
	private List<UserSiteAccess> userAccessList = new ArrayList<UserSiteAccess>(0);

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_date")
	private Date createdDate = new Date();

	@Column(name="created_by")
	private String createdBy;

	@Column(name="modified_date")
	private Date modifiedDate;

	@Column(name="modified_by")
	private String modifiedBy;



	@Version
	private int version;


	public Site() {
	}

	public Long getSiteId() {
		return this.siteId;
	}

	public void setSiteId(final Long siteId) {
		this.siteId = siteId;
	}

	public String getSiteCode() {
		return siteCode;
	}

	public void setSiteCode(final String siteCode) {
		this.siteCode = siteCode;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(final String siteName) {
		this.siteName = siteName;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(final Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(final String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(final Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(final String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public Long getDistrictId() {
		return districtId;
	}

	public void setDistrictId(Long districtId) {
		this.districtId = districtId;
	}

	public Long getAreaId() {
		return areaId;
	}

	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}

	public Long getClusterId() {
		return clusterId;
	}

	public void setClusterId(Long clusterId) {
		this.clusterId = clusterId;
	}
	@JsonIgnore
	public Company getOperator() {
		return operator;
	}

	public void setOperator(final Company operator) {
		this.operator = operator;
	}

	public String getSiteOwner() {
		return siteOwner;
	}

	public void setSiteOwner(final String siteOwner) {
		this.siteOwner = siteOwner;
	}


	public String getAttachmentPath() {
		return attachmentPath;
	}

	public void setAttachmentPath(final String attachmentPath) {
		this.attachmentPath = attachmentPath;
	}

	public String getAreaManagerName() {
		return areaManagerName;
	}

	public void setAreaManagerName(final String areaManagerName) {
		this.areaManagerName = areaManagerName;
	}

	public String getSiteAddress() {
		return siteAddress;
	}

	public void setSiteAddress(final String siteAddress) {
		this.siteAddress = siteAddress;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(final String postCode) {
		this.postCode = postCode;
	}




	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public BigInteger getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(final BigInteger primaryContact) {
		this.primaryContact = primaryContact;
	}

	public BigInteger getSecondaryContact() {
		return secondaryContact;
	}

	public void setSecondaryContact(final BigInteger secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getElectricIdNo() {
		return electricIdNo;
	}

	public void setElectricIdNo(final String electricIdNo) {
		this.electricIdNo = electricIdNo;
	}


	public Long getSiteNumberOne() {
		return siteNumberOne;
	}

	public void setSiteNumberOne(Long siteNumberOne) {
		this.siteNumberOne = siteNumberOne;
	}

	public Long getSiteNumberTwo() {
		return siteNumberTwo;
	}

	public void setSiteNumberTwo(Long siteNumberTwo) {
		this.siteNumberTwo = siteNumberTwo;
	}

	@JsonIgnore
	public List<SiteDeliveryOperation> getSiteDeliveryOpetaionTimes() {
		return siteDeliveryOpetaionTimes;
	}
	public void setSiteDeliveryOpetaionTimes(
			final List<SiteDeliveryOperation> siteDeliveryOpetaionTimes) {
		this.siteDeliveryOpetaionTimes = siteDeliveryOpetaionTimes;
	}
	@JsonIgnore
	public List<SiteSalesOperation> getSiteSalesOpetaionTimes() {
		return siteSalesOpetaionTimes;
	}

	public void setSiteSalesOpetaionTimes(
			final List<SiteSalesOperation> siteSalesOpetaionTimes) {
		this.siteSalesOpetaionTimes = siteSalesOpetaionTimes;
	}
	@JsonIgnore
	public List<SiteLicence> getSiteLicences() {
		return siteLicences;
	}

	public void setSiteLicences(final List<SiteLicence> siteLicences) {
		this.siteLicences = siteLicences;
	}
	@JsonIgnore
	public List<SiteSubMeter> getSiteSubmeterList() {
		return siteSubmeterList;
	}

	public void setSiteSubmeterList(final List<SiteSubMeter> siteSubmeterList) {
		this.siteSubmeterList = siteSubmeterList;
	}
	@JsonIgnore
	public List<UserSiteAccess> getUserAccessList() {
		return userAccessList;
	}

	public void setUserAccessList(List<UserSiteAccess> userAccessList) {
		this.userAccessList = userAccessList;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Site [siteId=" + siteId + ", siteCode=" + siteCode
				+ ", siteName=" + siteName + ", siteAddress=" + siteAddress
				+ ", postCode=" + postCode + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", contactName=" + areaManagerName
				+ ", primaryContact=" + primaryContact + ", secondaryContact="
				+ secondaryContact + ", email=" + email + ", electricIdNo="
				+ electricIdNo + ", siteNumberOne=" + siteNumberOne
				+ ", siteNumberTwo=" + siteNumberTwo + ", createdDate="
				+ createdDate + ", createdBy=" + createdBy + ", modifiedDate="
				+ modifiedDate + ", modifiedBy=" + modifiedBy + "]";
	}




}
