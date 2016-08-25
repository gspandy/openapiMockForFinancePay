/**
 * 
 */
package com.yiji.openapimock.service.userBalanceQuery;

import org.hibernate.validator.constraints.NotBlank;

import com.yiji.openapi.arch.meta.OpenApiField;
import com.yiji.openapi.arch.service.entity.ApiResponse;
import com.yjf.common.lang.util.money.Money;

/**
 * @author damo
 *
 */
public class UserBalanceQueryResponse extends ApiResponse {
	
	@NotBlank
	@OpenApiField(desc = "用户总的余额",demo = "88.66")
	private Money balance;
	
	@NotBlank
	@OpenApiField(desc = "用户可用余额",demo = "88.66")
	private Money availableBalance;
	
	@NotBlank
	@OpenApiField(desc = "用户冻结余额",demo = "88.66")
	private Money freezenBalance;

	/**
	 * 
	 */
	public UserBalanceQueryResponse() {
		super();
	}
	
	/**
	 * @param balance
	 * @param availableBalance
	 * @param freezenBalance
	 */
	public UserBalanceQueryResponse(Money balance, Money availableBalance, Money freezenBalance) {
		super();
		this.balance = balance;
		this.availableBalance = availableBalance;
		this.freezenBalance = freezenBalance;
	}
	
	/**
	 * @return the balance
	 */
	public Money getBalance() {
		return balance;
	}
	
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Money balance) {
		this.balance = balance;
	}
	
	/**
	 * @return the availableBalance
	 */
	public Money getAvailableBalance() {
		return availableBalance;
	}
	
	/**
	 * @param availableBalance the availableBalance to set
	 */
	public void setAvailableBalance(Money availableBalance) {
		this.availableBalance = availableBalance;
	}
	
	/**
	 * @return the freezenBalance
	 */
	public Money getFreezenBalance() {
		return freezenBalance;
	}
	
	/**
	 * @param freezenBalance the freezenBalance to set
	 */
	public void setFreezenBalance(Money freezenBalance) {
		this.freezenBalance = freezenBalance;
	}
	
}
