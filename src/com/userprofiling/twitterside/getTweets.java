package com.userprofiling.twitterside;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.script.javascript.JSAdapter;
import com.temboo.Library.Twitter.Timelines.UserTimeline;
import com.temboo.Library.Twitter.Timelines.UserTimeline.UserTimelineInputSet;
import com.temboo.Library.Twitter.Timelines.UserTimeline.UserTimelineResultSet;
import com.temboo.core.TembooException;
import com.temboo.core.TembooSession;

public class getTweets {

	JSONObject JSONobj;
	public static String TWEET_CREATED_AT;
	public static String TWEET_ID;
	public static String TWEET_TEXT;
	public static String TWEET_IN_REPLY_TO_STATUS_ID;
	public static String TWEET_IN_REPLY_TO_USER_ID;
	public static String TWEET_IN_REPLY_TO_SCREEN_NAME;
	public static String USER_NAME;
	public static String USER_ID;
	public static String USER_SCREEN_NAME;
	public static String USER_LOCATION;
	public static String USER_DESCRIPTION;
	public static long USER_FOLLOWERS_COUNT;
	public static long USER_FRIENDS_COUNT;
	public static String USER_LISTED_COUNT;
	public static String USER_CREATED_AT;
	public static long USER_FAVOURITES_COUNT;
	public static boolean USER_IS_VERIFIED;
	public static long USER_STATUSES_COUNT;
	public static String USER_LANGUAGE;
	public static String USER_IS_FOLLOWING;
	public static String TWEET_RETWEET_COUNT;
	public static String TWEET_FAVOURITES_COUNT;
	public static String TWEET_ENTITIES_SYMBOLS;
	public static String TWEET_IS_RETWEETED;
	public static String TWEET_POSSIBILY_SENSITIVE;
	public static List<Object> USER_ENTITY_DESCRIPTION_URLS;
	public static List<Url> TWEET_ENTITIES_URLS;
	public static List<Object> TWEET_ENTITIES_HASHTAGS;
	public static List<User_mention> TWEET_ENTITIES_USER_MENTIONS;
	
	public void getTweetsnRetweets() throws TembooException, JSONException
	{
		// Instantiate the Choreo, using a previously instantiated TembooSession object, eg:
		TembooSession session = new TembooSession("hingermayank", "UserProfiling", "68247141dcb04a79b7076a2554719d47");
		UserTimeline userTimelineChoreo = new UserTimeline(session);

		// Get an InputSet object for the choreo
		UserTimelineInputSet userTimelineInputs = userTimelineChoreo.newInputSet();

		// Set credential to use for execution
		userTimelineInputs.setCredential("hingermayank");

		// Set inputs
		userTimelineInputs.set_ExcludeReplies("false");
		userTimelineInputs.set_Count("2");
		userTimelineInputs.set_ContributorDetails("true");
		userTimelineInputs.set_IncludeRetweets("true");

		// Execute Choreo
		UserTimelineResultSet userTimelineResults = userTimelineChoreo.execute(userTimelineInputs);
		String response = userTimelineResults.get_Response();
		parseJSON(response);
		
	}
	
	public void parseJSON(String response) throws JSONException
	{		
		Gson gson = new Gson();
	    JsonParser parser = new JsonParser();
	    JsonArray jArray = parser.parse(response).getAsJsonArray();
	    ArrayList<HashMap<String, String>> info_list = new ArrayList<HashMap<String, String>>();
	    
	    
	    for(JsonElement obj : jArray)
	    {
	    	HashMap<String, String> map = new HashMap<String, String>();
	        Tweet tweet = gson.fromJson( obj , Tweet.class);
			TWEET_CREATED_AT = tweet.getCreated_at();
			map.put("TWEET_CREATED_AT", TWEET_CREATED_AT);
			TWEET_ID = tweet.getId_str();
			map.put("TWEET_ID", TWEET_ID);
			TWEET_TEXT =tweet.getText();
			map.put("TWEET_TEXT",TWEET_TEXT);
			
			TWEET_IN_REPLY_TO_USER_ID = (String) tweet.getIn_reply_to_user_id_str();
			if(TWEET_IN_REPLY_TO_USER_ID != null)
			{
				map.put("TWEET_IN_REPLY_TO_USER_ID", TWEET_IN_REPLY_TO_USER_ID );
			}
			TWEET_IN_REPLY_TO_SCREEN_NAME = (String) tweet.getIn_reply_to_screen_name();
			if(TWEET_IN_REPLY_TO_SCREEN_NAME != null)
			{
				map.put("TWEET_IN_REPLY_TO_SCREEN_NAME", TWEET_IN_REPLY_TO_SCREEN_NAME);
			}
			TWEET_IN_REPLY_TO_STATUS_ID = (String) tweet.getIn_reply_to_status_id_str();
			if(TWEET_IN_REPLY_TO_STATUS_ID != null)
			{
				map.put("TWEET_IN_REPLY_TO_STATUS_ID", TWEET_IN_REPLY_TO_STATUS_ID );
			}
			
			User user = tweet.getUser();
			USER_ID = user.getId_str();
			map.put("USER_ID", USER_ID);
			USER_NAME = user.getName();
			map.put("USER_NAME", USER_NAME);
			USER_SCREEN_NAME = user.getScreen_name();
			map.put("USER_SCREEN_NAME", USER_SCREEN_NAME);
			USER_LOCATION = user.getLocation();
			map.put("USER_LOCATION", USER_LOCATION);
			USER_DESCRIPTION = user.getDescription();
			map.put("USER_DESCRIPTION", USER_DESCRIPTION);
			USER_CREATED_AT = user.getCreated_at();
			map.put("USER_CREATED_AT", USER_CREATED_AT);
			
			Entities user_entity = user.getEntities();
			Description descript = user_entity.getDescription();
			USER_ENTITY_DESCRIPTION_URLS = descript.getUrls();
			
			USER_FOLLOWERS_COUNT = user.getFollowers_count();
			map.put("USER_FOLLOWERS_COUNT", USER_FOLLOWERS_COUNT+"");
			USER_FAVOURITES_COUNT = user.getFavourites_count();
			map.put("USER_FAVOURITES_COUNT", USER_FAVOURITES_COUNT+"");
			USER_FRIENDS_COUNT = user.getFriends_count();
			map.put("USER_FRIENDS_COUNT", USER_FRIENDS_COUNT+"");
			USER_CREATED_AT = user.getCreated_at();
			map.put("USER_CREATED_AT", USER_CREATED_AT);
			USER_IS_VERIFIED = user.isVerified();
			
			USER_STATUSES_COUNT = user.getStatuses_count();
			map.put("USER_STATUSES_COUNT", USER_STATUSES_COUNT+"");
			
			Entities_ entity = tweet.getEntities();
			TWEET_ENTITIES_HASHTAGS = entity.getHashtags();
			TWEET_ENTITIES_USER_MENTIONS = entity.getUser_mentions();
			TWEET_ENTITIES_URLS = entity.getUrls();

			info_list.add(map);
	    }
	    System.out.println(info_list.get(1).toString());
	}
	
}
