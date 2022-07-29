package com.revature.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class reimbs {
	private int reimb_id,reimb_amount;
    private Timestamp reimb_submitted, reimb_resolved;
    private String reimb_description, reimb_receipt_url;
    private boolean reimb_is_approved;
    private reimbtype reimb_type_id_fk;
    private int reimb_author_id_fk, reimb_resolver_id_fk;
	

	public reimbs(int reimb_id, int reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, String reimb_receipt_url, boolean reimb_is_approved, reimbtype reimb_type_id_fk,
			int reimb_author_id_fk, int reimb_resolver_id_fk) {
		super();
		this.reimb_id = reimb_id;
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt_url = reimb_receipt_url;
		this.reimb_is_approved = reimb_is_approved;
		this.reimb_type_id_fk = reimb_type_id_fk;
		this.reimb_author_id_fk = reimb_author_id_fk;
		this.reimb_resolver_id_fk = reimb_resolver_id_fk;
	}

	public reimbs(int reimb_amount, Timestamp reimb_submitted, Timestamp reimb_resolved,
			String reimb_description, String reimb_receipt_url, boolean reimb_is_approved, reimbtype reimb_type_id_fk,
			int reimb_author_id_fk, int reimb_resolver_id_fk) {
		super();
		this.reimb_amount = reimb_amount;
		this.reimb_submitted = reimb_submitted;
		this.reimb_resolved = reimb_resolved;
		this.reimb_description = reimb_description;
		this.reimb_receipt_url = reimb_receipt_url;
		this.reimb_is_approved = reimb_is_approved;
		this.reimb_type_id_fk = reimb_type_id_fk;
		this.reimb_author_id_fk = reimb_author_id_fk;
		this.reimb_resolver_id_fk = reimb_resolver_id_fk;
	}

	public int getReimb_id() {
		return reimb_id;
	}

	public void setReimb_id(int reimb_id) {
		this.reimb_id = reimb_id;
	}

	public int getReimb_amount() {
		return reimb_amount;
	}

	public void setReimb_amount(int reimb_amount) {
		this.reimb_amount = reimb_amount;
	}

	public Timestamp getReimb_submitted() {
		return reimb_submitted;
	}

	public void setReimb_submitted(Timestamp reimb_submitted) {
		this.reimb_submitted = reimb_submitted;
	}

	public Timestamp getReimb_resolved() {
		return reimb_resolved;
	}

	public void setReimb_resolved(Timestamp reimb_resolved) {
		this.reimb_resolved = reimb_resolved;
	}

	public String getReimb_description() {
		return reimb_description;
	}

	public void setReimb_description(String reimb_description) {
		this.reimb_description = reimb_description;
	}

	public String getReimb_receipt_url() {
		return reimb_receipt_url;
	}

	public void setReimb_receipt_url(String reimb_receipt_url) {
		this.reimb_receipt_url = reimb_receipt_url;
	}

	public boolean isReimb_is_approved() {
		return reimb_is_approved;
	}

	public void setReimb_is_approved(boolean reimb_is_approved) {
		this.reimb_is_approved = reimb_is_approved;
	}

	public reimbtype getReimb_type_id_fk() {
		return reimb_type_id_fk;
	}

	public void setReimb_type_id_fk(reimbtype reimb_type_id_fk) {
		this.reimb_type_id_fk = reimb_type_id_fk;
	}

	public int getReimb_author_id_fk() {
		return reimb_author_id_fk;
	}

	public void setReimb_author_id_fk(int reimb_author_id_fk) {
		this.reimb_author_id_fk = reimb_author_id_fk;
	}

	public int getReimb_resolver_id_fk() {
		return reimb_resolver_id_fk;
	}

	public void setReimb_resolver_id_fk(int reimb_resolver_id_fk) {
		this.reimb_resolver_id_fk = reimb_resolver_id_fk;
	}

	@Override
	public String toString() {
		return "reimbs [reimb_id=" + reimb_id + ", reimb_amount=" + reimb_amount + ", reimb_submitted="
				+ reimb_submitted + ", reimb_resolved=" + reimb_resolved + ", reimb_description=" + reimb_description
				+ ", reimb_receipt_url=" + reimb_receipt_url + ", reimb_is_approved=" + reimb_is_approved
				+ ", reimb_type_id_fk=" + reimb_type_id_fk + ", reimb_author_id_fk=" + reimb_author_id_fk
				+ ", reimb_resolver_id_fk=" + reimb_resolver_id_fk + "]";
	}
	
	
}
