package com.google.code.stk.shared.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;
import com.google.code.stk.shared.Enums;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class AutoTweet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Attribute(primaryKey = true)
	private Key key;

	@Attribute(version = true)
	private Long version;

	/** tweet */
	@Attribute(unindexed = true)
	private String tweet;

	/** bure */
	@Attribute(unindexed = true)
	private Enums.Bure bure;

	/** cycle */
	@Attribute(unindexed = true)
	private Enums.Cycle cycle;

	/** startMMdd */
	private String startMMdd;

	/** endMMdd */
	private String endMMdd;

	/** tweetTime(hh) */
	@Attribute
	private String tweetHour;

	@Attribute(unindexed = true)
	private String lastTweetAt;

	private String screenName;

	/**
	 * keyを取得します。
	 * @return key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * keyを設定します。
	 * @param key key
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		AutoTweet other = (AutoTweet) obj;
		if (key == null) {
			if (other.key != null) {
				return false;
			}
		} else if (!key.equals(other.key)) {
			return false;
		}
		return true;
	}

	/**
	 * versionを取得します。
	 * @return version
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * versionを設定します。
	 * @param version version
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	/**
	 * tweetを取得します。
	 * @return tweet
	 */
	public String getTweet() {
	    return tweet;
	}

	/**
	 * tweetを設定します。
	 * @param tweet tweet
	 */
	public void setTweet(String tweet) {
	    this.tweet = tweet;
	}

	/**
	 * cycleを取得します。
	 * @return cycle
	 */
	public Enums.Cycle getCycle() {
	    return cycle;
	}

	/**
	 * cycleを設定します。
	 * @param cycle cycle
	 */
	public void setCycle(Enums.Cycle cycle) {
	    this.cycle = cycle;
	}

	/**
	 * startMMddを取得します。
	 * @return startMMdd
	 */
	public String getStartMMdd() {
	    return startMMdd;
	}

	/**
	 * startMMddを設定します。
	 * @param startMMdd startMMdd
	 */
	public void setStartMMdd(String startMMdd) {
	    this.startMMdd = startMMdd;
	}

	/**
	 * endMMddを取得します。
	 * @return endMMdd
	 */
	public String getEndMMdd() {
	    return endMMdd;
	}

	/**
	 * endMMddを設定します。
	 * @param endMMdd endMMdd
	 */
	public void setEndMMdd(String endMMdd) {
	    this.endMMdd = endMMdd;
	}

	/**
	 * tweetTime(hhmm)を取得します。
	 * @return tweetTime(hhmm)
	 */
	public String getTweetHour() {
	    return tweetHour;
	}

	/**
	 * tweetTime(hhmm)を設定します。
	 * @param tweetTime tweetTime(hhmm)
	 */
	public void setTweetHour(String tweetTime) {
	    this.tweetHour = tweetTime;
	}

	public void setBure(Enums.Bure bure) {
		this.bure = bure;
	}

	public Enums.Bure getBure() {
		return bure;
	}

	public String getLastTweetAt() {
		return lastTweetAt;
	}

	public void setLastTweetAt(String lastTweetAt) {
		this.lastTweetAt = lastTweetAt;
	}

	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String value) {
		this.screenName = value;
	}
}
