package com.userprofiling.twitterside;


import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;

@Generated("org.jsonschema2pojo")
public class Hashtags {

    @Expose
    private String text;
    @Expose
    private List<Long> indices = new ArrayList<Long>();
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<Long> getIndices() {
		return indices;
	}
	public void setIndices(List<Long> indices) {
		this.indices = indices;
	}

  

}
