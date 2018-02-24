/**
 * 
 */
package com.evan.context_service.fileUploader.db.entity;

/**
 * @author 310199253
 *
 */
public class User {

	private int id;
	
	private String uid;
	
	private String extId;
	
	
	private String name;


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}


	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}


	/**
	 * @return the extId
	 */
	public String getExtId() {
		return extId;
	}


	/**
	 * @param extId the extId to set
	 */
	public void setExtId(String extId) {
		this.extId = extId;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", uid=" + uid + ", extId=" + extId + ", name=" + name + "]";
	}
	
	
	
	
}
