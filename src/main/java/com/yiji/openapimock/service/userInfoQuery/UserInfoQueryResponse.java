/**
 * 
 */
package com.yiji.openapimock.service.userInfoQuery;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;
import com.yjf.common.lang.enums.CertTypeEnum;

/**
 * @author damo
 * @date 2014年8月5日
 *
 */
public class UserInfoQueryResponse extends ApiResponse {
	
	@OpenApiField(desc = "易极付用户ID",demo = "1234567980132456789")
	private String userId;
	
	@OpenApiField(desc = "用户名",demo = "易极付")
	private String userName;
	
	@OpenApiField(desc = "用户邮箱",demo = "xx@yiji.com")
	private String email;
	
	@OpenApiField(desc = "用户手机号",demo = "10086100101")
	private String mobileNo;
	
	@OpenApiField(desc = "用户真实姓名",demo = "易极付")
	private String realName;
	
	@OpenApiField(desc = "证件类型",demo = "Identity_Card")
	private CertTypeEnum certType;
	
	@OpenApiField(desc = "证件号码",demo = "123456789012345678")
	private String certNo;
	
	@OpenApiField(desc = "会员身份验证码",demo = "sdfs")
	private String verifyCode;
	
	@OpenApiField(desc = "绑定银行卡数量",demo = "1")
	private int bankCardCount;
	
	@OpenApiField(desc = "用户类型",demo = "PERSON")
	private String userType;
	
	@OpenApiField(desc = "实名认证状态",demo = "UNAUTHERIZED")
	private String certifyStatus;
	
	@OpenApiField(desc = "实名认证等级",demo = "NO_RANK")
	private String certifyLevel;
	
	@OpenApiField(desc = "用户状态",demo = "UNACTIVATED")
	private String userStatus;
	
	@OpenApiField(desc = "运行时状态",demo = "NOMARL")
	private String runtimeStatus;
	
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}
	
	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		if (mobileNo != null) {
			this.mobileNo = mobileNo;
		} else {
			this.mobileNo = "";
		}
	}
	
	/**
	 * @return the realName
	 */
	public String getRealName() {
		return realName;
	}
	
	/**
	 * @param realName the realName to set
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	/**
	 * @return the bankCardCount
	 */
	public int getBankCardCount() {
		return bankCardCount;
	}
	
	/**
	 * @param bankCardCount the bankCardCount to set
	 */
	public void setBankCardCount(int bankCardCount) {
		this.bankCardCount = bankCardCount;
	}
	
	/**
	 * @return the certifyStatus
	 */
	public String getCertifyStatus() {
		return certifyStatus;
	}
	
	/**
	 * @param certifyStatus the certifyStatus to set
	 */
	public void setCertifyStatus(String certifyStatus) {
		this.certifyStatus = certifyStatus;
	}
	
	/**
	 * @return the certifyLevel
	 */
	public String getCertifyLevel() {
		return certifyLevel;
	}
	
	/**
	 * @param certifyLevel the certifyLevel to set
	 */
	public void setCertifyLevel(String certifyLevel) {
		this.certifyLevel = certifyLevel;
	}
	
	/**
	 * @return the userStatus
	 */
	public String getUserStatus() {
		return userStatus;
	}
	
	/**
	 * @param userStatus the userStatus to set
	 */
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}
	
	/**
	 * @return the runtimeStatus
	 */
	public String getRuntimeStatus() {
		return runtimeStatus;
	}
	
	/**
	 * @param runtimeStatus the runtimeStatus to set
	 */
	public void setRuntimeStatus(String runtimeStatus) {
		this.runtimeStatus = runtimeStatus;
	}
	
	public String getCertNo() {
		return this.certNo;
	}
	
	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}
	
	public String getVerifyCode() {
		return this.verifyCode;
	}
	
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	public String getUserType() {
		return this.userType;
	}
	
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public CertTypeEnum getCertType() {
		return this.certType;
	}
	
	public void setCertType(CertTypeEnum certType) {
		this.certType = certType;
	}
	
	public static void main(String[] args) {
		String a = "18621826221";
		System.out.println(a.charAt(0) + a.charAt(1) + a.charAt(2) + "****" + a.charAt(8) + a.charAt(9) + a.charAt(10));
	}
}
