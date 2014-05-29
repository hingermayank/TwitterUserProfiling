import org.json.JSONException;

import com.temboo.core.TembooException;
import com.userprofiling.twitterside.getTweets;


public class MainActivity {

	public static void main(String[] args) throws TembooException, JSONException
	{
		getTweets tweets = new getTweets();
		tweets.getTweetsnRetweets();
	}
	
}
