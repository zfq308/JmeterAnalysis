package com.lazerycode.jmeter.analyzer.parser;

import com.lazerycode.jmeter.analyzer.statistics.Samples;

import java.util.Date;
import java.util.Map;

/**
 * Holds aggregated data for several http responses.
 * 
 * @author caiqiuliang
 */
public class AggregatedResponses {

	/**
	 * Timestamp when the test has started
	 */
	private long start;

	/**
	 * Timestamp when the test has ended
	 */
	private long end;

	/**
	 * size of the responses
	 */
	private Samples size;

	/**
	 * size of the responses splitted by uri
	 */
	private Map<String, Samples> sizeByUri;

	/**
	 * duration of the responses
	 */
	private Samples duration;

	/**
	 * duration of the responses splitted by uri
	 */
	private Map<String, Samples> durationByUri;

	/**
	 * aggregated status codes of responses
	 */
	private StatusCodes statusCodes;

	/**
	 * thread number
	 */
	private int threadNum = 0;
	
	/**
	 * TPS
	 */
	private double tps = 0.0;

	/**
	 * @return Timestamp when the test has started
	 */
	public long getStart() {
		return start;
	}

	/**
	 * @return Date when the test has started
	 */
	public Date getStartDate() {
		return new Date(start);
	}

	protected void setStart(long start) {
		this.start = start;
	}

	/**
	 * @return Timestamp when the test has ended
	 */
	public long getEnd() {
		return end;
	}

	/**
	 * @return Date when the test has ended
	 */
	public Date getEndDate() {
		return new Date(end);
	}

	protected void setEnd(long end) {
		this.end = end;
	}

	/**
	 * @return Aggregation for size of responses
	 */
	public Samples getSize() {
		return size;
	}

	protected void setSize(Samples size) {
		this.size = size;
	}

	/**
	 * @return Aggregation for response duration
	 */
	public Samples getDuration() {
		return duration;
	}

	protected void setDuration(Samples duration) {
		this.duration = duration;
	}

	/**
	 * @return aggregated status codes of responses
	 */
	public StatusCodes getStatusCodes() {
		return statusCodes;
	}

	protected void setStatusCodes(StatusCodes statusCodes) {
		this.statusCodes = statusCodes;
	}

	/**
	 * @return a mapping from uri to sample data
	 */
	public Map<String, Samples> getSizeByUri() {
		return sizeByUri;
	}

	protected void setSizeByUri(Map<String, Samples> sizeByUri) {
		this.sizeByUri = sizeByUri;
	}

	/**
	 * @return a mapping from uri to sample data
	 */
	public Map<String, Samples> getDurationByUri() {
		return durationByUri;
	}

	protected void setDurationByUri(Map<String, Samples> durationByUri) {
		this.durationByUri = durationByUri;
	}

	// --------------------------------------------------------------------------------------------------------------------

	/**
	 * Mark collecting of samples as "finished"
	 */
	protected void finish() {

		if (size != null) {
			size.finish();
		}
		if (duration != null) {
			duration.finish();
		}

		if (sizeByUri != null) {
			for (Samples s : sizeByUri.values()) {
				s.finish();
			}
		}

		if (durationByUri != null) {
			for (Samples s : durationByUri.values()) {
				s.finish();
			}
		}

	}

	public int getThreadNum() {
		return threadNum;
	}

	protected void setThreadNum(int threadNum) {
		if (this.threadNum < threadNum) {
			this.threadNum = threadNum;
		}
	}

	/**
	 * @return the tps
	 */
	public double getTps() {
		return tps;
	}

	/**
	 * @param tps the tps to set
	 */
	protected void setTps(double tps) {
		this.tps = tps;
	}
}
