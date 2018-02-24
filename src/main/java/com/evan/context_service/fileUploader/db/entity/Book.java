/**
 * 
 */
package com.evan.context_service.fileUploader.db.entity;

/**
 * @author 310199253
 *
 */
public class Book {

	private int id;

	private String uid;
	
	private String name;

	private String filePath;

	private String hash;

	
	private boolean privateOnly;


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


	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}


	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}


	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}


	/**
	 * @return the privateOnly
	 */
	public boolean isPrivateOnly() {
		return privateOnly;
	}


	/**
	 * @param privateOnly the privateOnly to set
	 */
	public void setPrivateOnly(boolean privateOnly) {
		this.privateOnly = privateOnly;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", uid=" + uid + ", name=" + name + ", filePath=" + filePath + ", hash=" + hash
				+ ", privateOnly=" + privateOnly + "]";
	}
	
	
	
}
