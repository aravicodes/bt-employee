package com.cg.bugtracking.employee.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;


@Entity
public class Bug{
	@Id
	@Min(value=0)
	private long bid;
	@NotEmpty
	private String bugDesc;
	@NotEmpty
	private String status;
	@NotEmpty
	private Date startDate;
	@NotEmpty
	private Date endDate;
	@NotEmpty
	private String assignee;
	@NotEmpty
	private String type;
	@NotEmpty
	private String priority;
	@NotEmpty
	private long projectId;
	public long getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBugDesc() {
		return bugDesc;
	}
	public void setBugDesc(String bugDesc) {
		this.bugDesc = bugDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getPriority() {
		return priority;
	}
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public long getProjectId() {
		return projectId;
	}
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public Bug(long bid, String bugDesc, String status, Date startDate, Date endDate, String assignee, String type,
			String priority, long projectId) {
		super();
		this.bid = bid;
		this.bugDesc = bugDesc;
		this.status = status;
		this.startDate = startDate;
		this.endDate = endDate;
		this.assignee = assignee;
		this.type = type;
		this.priority = priority;
		this.projectId = projectId;
	}
	public Bug() {
		
	}
}
