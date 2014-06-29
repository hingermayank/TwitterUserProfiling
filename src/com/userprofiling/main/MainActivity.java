package com.userprofiling.main;

import java.sql.SQLException;

import org.json.JSONException;

import com.mysql.jdbc.Connection;
import com.temboo.core.TembooException;
import com.userprofiling.twitterside.getTweets;

public class MainActivity {

	public static Connection check_connection = null;
	public static void main(String[] args) throws TembooException, JSONException, ClassNotFoundException, SQLException
	{	
		getTweets tweets = new getTweets();
		tweets.getTweetsnRetweets();
	}
	
	
	
}
