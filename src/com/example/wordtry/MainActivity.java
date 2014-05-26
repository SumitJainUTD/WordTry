package com.example.wordtry;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static final int LENGTH_SHORT = 0;
	public static final String LISTNAME = "com.example.wordtry.LISTNAME";
	public static final String STATSFROMMAINPAGE = "com.example.wordtry.STATS";
	private String strCountQuery;
	private int intWordsCount_Main;
	public WordPowerOpenHelper wp;
	private int intWordsCount_ML;
	private int intWordsCount_LL;
	private int intWordsCount_TL;
	public CommomFunctions cf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.i("Display count","I m displayed again");
		cf = new CommomFunctions(this);
		updateData();
	}
	
	
	
	public void addAllWordsToDB(WordPowerOpenHelper wp){
		strCountQuery = "select Count(*) as Count from mainwordlist";
		
		intWordsCount_Main= getRecordCountMA(strCountQuery);
		if(intWordsCount_Main>0){
			//do nothing
//			wp.addWords("abnegation","renunciation; self-sacrifice","Though Rudolph and Duchess Flavia loved one another, their love was doomed, for she had to wed the king; their act of abnegation was necessary to preserve the kingdom.");
//			wp.addWords("abominate","loathe; hate","Moses scolded the idol worshippers in the tribe because he abominated the custom.");
//			wp.addWords("abortive","unsuccessful; fruitless","We had to abandon our abortive attempts.");
//			wp.addWords("abrasive","rough and can be used to clean a surface or to make it smooth","Just as abrasive cleaning powders can wear away a shiny finish, abrasive remarks can wear away a listener's patience.");
//			wp.addWords("abrogate","abolish;to cancel or revoke formally or officially","He intended to abrogate the decree issued by his predecessor.");
//			wp.addWords("BBBB","depart secretly and hide","The teller absconded with the bonds and was not found.");
//			wp.addWords("bade","complete; totally unlimited; certain","Although the King of Siam was an absolute monarch, he did not want to behead his unfaithful wife without absolute evidence of her infidelity.");
//			wp.addWords("bche","pardon (an offense)","The father confessor absolved him of his sins.");
//			wp.addWords("bher","refrain; withhold from participation","After considering the effect of alcohol on his athletic performance, he decided to abstain from drinking while he trained for the race.");
//			wp.addWords("Chodeed","sparing in eating and drinking","");
//			wp.addWords("Cord","restraint from eating and drinking","");
//			wp.addWords("confuse","obscure; profound; difficult to understand","");
//			wp.addWords("complex","theoretical; not concrete; non-representational","To him, hunger was an abstract concept; he had never missed a meal.");
//			wp.addWords("Dad","coarsely insulting; physically harmful","An abusive parent damages a child both mentally and physically.");
//			wp.addWords("Decide","border upon; adjoin","Where our estates abut, we must build a fence.");
//			wp.addWords("detremine",  "1.  extremely bad or of a very low standard","His arrogance is exceeded only by his abysmal ignorance.");
//			wp.addWords("Elephanr","agree","If I accede to this demand for blackmail, I am afraid that I will be the victim of future demands.");
//			wp.addWords("Eye","move faster","In our science class, we learn how falling bodies accelerate.");
//			wp.addWords("Eagle","easy to approach; obtainable","We asked our guide whether the ruins were accessible on foot.");
//			wp.addWords("Fish","additional object; useful but not essential thing","She bought an attractive handbag as an accessory for her dress.");
//			wp.addWords("Gang","adjust to climate or environment","One of the difficulties of our present air age is the need of travellers to acclimate themselves to their new and often strange environments.");
//		
		}
		else{
			wp.addWords("abate","subside or moderate","Rather than leaving immediately, they waited for the storm to abate.");
			wp.addWords("abbreviate","shorten","Because we were running out of time, the lecturer had to abbreviate her speech.");
			wp.addWords("abdicate","renounce; give up","When Edward VII abdicated the British throne, he surprised the entire world.");
			wp.addWords("aberrant","abnormal or deviant","Given the aberrant nature of the data, we came to doubt the validity of the entire experiment.");
			wp.addWords("abet","assist, usually in doing something wrong","She was unwilling to abet him in the swindle he had planned.");
			wp.addWords("abeyance","suspended action","The deal was held in abeyance until her arrival.");
			wp.addWords("abject","wretched; lacking pride","On the streets of New York the homeless live in abject poverty, huddling in doorways to find shelter from the wind.");
			wp.addWords("abjure","renounce upon oath","He abjured his allegiance to the king.");
			
			wp.addWords("ablution","washing","His daily ablutions were accompanied by loud noises that he humorously labeled Opera in the Bath.");
		
			wp.addWords("abnegation","renunciation; self-sacrifice","Though Rudolph and Duchess Flavia loved one another, their love was doomed, for she had to wed the king; their act of abnegation was necessary to preserve the kingdom.");
			wp.addWords("abominate","loathe; hate","Moses scolded the idol worshippers in the tribe because he abominated the custom.");
			wp.addWords("abortive","unsuccessful; fruitless","We had to abandon our abortive attempts.");
			wp.addWords("abrasive","rough and can be used to clean a surface or to make it smooth","Just as abrasive cleaning powders can wear away a shiny finish, abrasive remarks can wear away a listener's patience.");
			wp.addWords("abrogate","abolish;to cancel or revoke formally or officially","He intended to abrogate the decree issued by his predecessor.");
			wp.addWords("BBBB","depart secretly and hide","The teller absconded with the bonds and was not found.");
			wp.addWords("bade","complete; totally unlimited; certain","Although the King of Siam was an absolute monarch, he did not want to behead his unfaithful wife without absolute evidence of her infidelity.");
			wp.addWords("bche","pardon (an offense)","The father confessor absolved him of his sins.");
			wp.addWords("bher","refrain; withhold from participation","After considering the effect of alcohol on his athletic performance, he decided to abstain from drinking while he trained for the race.");
			wp.addWords("Chodeed","sparing in eating and drinking","");
			wp.addWords("Cord","restraint from eating and drinking","");
			wp.addWords("confuse","obscure; profound; difficult to understand","");
			wp.addWords("complex","theoretical; not concrete; non-representational","To him, hunger was an abstract concept; he had never missed a meal.");
			wp.addWords("Dad","coarsely insulting; physically harmful","An abusive parent damages a child both mentally and physically.");
			wp.addWords("Decide","border upon; adjoin","Where our estates abut, we must build a fence.");
			wp.addWords("detremine",  "1.  extremely bad or of a very low standard","His arrogance is exceeded only by his abysmal ignorance.");
			wp.addWords("Elephanr","agree","If I accede to this demand for blackmail, I am afraid that I will be the victim of future demands.");
			wp.addWords("Eye","move faster","In our science class, we learn how falling bodies accelerate.");
			wp.addWords("Eagle","easy to approach; obtainable","We asked our guide whether the ruins were accessible on foot.");
			wp.addWords("Fish","additional object; useful but not essential thing","She bought an attractive handbag as an accessory for her dress.");
			wp.addWords("Gang","adjust to climate or environment","One of the difficulties of our present air age is the need of travellers to acclimate themselves to their new and often strange environments.");
			wp.addWords("goat","sharp upslope of a hill","The car could not go up the acclivity in high gear.");
			wp.addWords("Hike","award of merit","In Hollywood, an 'Oscar' is the highest accolade.");
			wp.addWords("jake","agreement","She was in complete accord with the verdict.");
			wp.addWords("kite","approach and speak first to a person","When the two young men accosted me, I was frightened because I thought they were going to attack me.");
			wp.addWords("Kitchen","  1.  to dress somebody in a particular type of clothing or give them a particular type of equipment, especially a noticeable or impressive type ","The fisherman was accoutred with the best that the sporting goods store could supply ");
			wp.addWords("Lampard","growth; increase","The accretion of wealth marked the family's rise in power.");
			wp.addWords("Loose","come about by addition","You must pay the interest that has accrued on your debt as well as the principal sum.");
			wp.addWords("acidulous","slightly sour; sharp; caustic","James was unpopular because of his sarcastic and acidulous remarks.");
			wp.addWords("Man","peak; pinnacle; highest point","Welles's success in Citizen Kane marked the acme of his career as an actor; never again did he achieve such popular acclaim.");
			wp.addWords("Mango","assent; agree passively","Although she appeared to acquiesce to her employer's suggestions, I could tell she had reservations about the changes he wanted made.");
			wp.addWords("Opt","deliverance from a charge","His acquittal by the jury surprised those who had thought him guilty.");
			wp.addWords("Queen","sharp; bitterly pungent","The acrid odor of burnt gunpowder filled the room after the pistol had been fired.");
			wp.addWords("Quake","stinging, caustic;angry and full of strong bitter feelings and words ","His tendency to utter acrimonious remarks alienated his audience.");
			wp.addWords("rest","  1.  a person whose job involves calculating insurance risks and payments for insurance companies by studying how frequently accidents, fires, deaths, etc. happen ","According to recent actuarial tables, life expectancy is greater today than it was a century ago.");
			wp.addWords("remain","motivate;Activate","I fail to understand what actuated you to reply to this letter so nastily.");
			wp.addWords("Sumit","sharpness","In time his youthful acuity of vision failed him, and he needed glasses.");
			wp.addWords("Superb","mental keenness","His business acumen helped him to succeed where others had failed.");
			wp.addWords("Tant","wise saying; proverb","There is much truth in the old adage about fools and their money.");
			wp.addWords("Temple","hard, inflexible","He was adamant in his determination to punish the wrongdoer.");
			wp.addWords("UNO","addition; appendix to book","Jane's editor approved her new comparative literature text but thought it would be even better with an addendum on recent developments in literary criticism.");
			wp.addWords("Vast","muddle; drive crazy;  to make somebody unable to think clearly; to confuse somebody ","This idiotic plan is confusing enough to addle anyone.");
			wp.addWords("vempire","supporter; follower","In the wake of the scandal, the senator's one-time adherent quietly deserted him.");
			wp.addWords("wife","a thing that is added or attached to something larger or more important","The memory expansion cards are useful adjuncts to the computer.");
			wp.addWords("wealth","solemn urging","Her adjuration to tell the truth did not change the witnesses' testimony.");
			wp.addWords("Xeroz","staff officer assisting the commander; assistant","Though Wellington delegated many tasks to his chief adjutant, Lord Fitzroy Somerset, Somerset was in no doubt as to who made all major decisions.");
			wp.addWords("Yera"," 1.  to tell somebody firmly that you do not approve of something that they have done   2.  to strongly advise somebody to do something ","  1.  She was admonished for chewing gum in class.  2.  A warning voice admonished him not to let this happen.");
			wp.addWords("Yeah","decorate","Wall paintings and carved statues adorned the temple.");
			wp.addWords("Zeal","skillful","His adroit handling of the delicate situation pleased his employers.");
			wp.addWords("Zambo","flattery; admiration","The rock star thrived on the adulation of his groupies and yes-men.");
			wp.addWords("adulterate","make impure by mixing with baser substances","It is a crime to adulterate foods without informing the buyer.");
			wp.addWords("advent","arrival","Most Americans were unaware of the advent of the Nuclear Age until the news of Hiroshima reached them.");
			wp.addWords("adventitious","accidental; casual","He found this adventitious meeting with his friend extremely fortunate.");
			wp.addWords("adversary","opponent; enemy","Batman struggled to save Gotham City from the machinations of his wicked adversary, the Joker.");
			wp.addWords("adverse","unfavorable; hostile","adverse circumstances compelled him to close his business.");
			wp.addWords("adversity","poverty, misfortune","We must learn to meet adversity gracefully.");
			wp.addWords("advert","refer to","Since you advert to this matter so frequently, you must regard it as important.");
			wp.addWords("advocate","urge; plead for","The abolitionists advocated freedom for the slaves.");
			wp.addWords("aegis","shield; defense","Under the aegis of the Bill of Rights, we enjoy our most treasured freedoms.");
			wp.addWords("affable","courteous;Easy and pleasant to speak to; approachable.","Although he held a position of responsibility, he was an affable individual and could be reached by anyone with a complaint.");
			
	//		*/
		}
			
	}
	public void updateData(){
		wp = new WordPowerOpenHelper(this, cf.DBName, null, 1);
		
		addAllWordsToDB(wp);
		
		strCountQuery = "select Count(*) as Count from mainwordlist";
				
		intWordsCount_Main= cf.getRecordCount(strCountQuery, wp);
		
		intWordsCount_ML= cf.getRecordCount("select Count(*) as Count from mainwordlist where _ID in (select mainid from Mapping where GroupID =1)",wp);
		
		intWordsCount_LL= cf.getRecordCount("select Count(*) as Count from mainwordlist where _ID in (select mainid from Mapping where GroupID =2)",wp);
		
		intWordsCount_TL= cf.getRecordCount("select Count(*) as Count from mainwordlist where _ID in (select mainid from Mapping where GroupID =3)",wp);
		
		wp.close();
		
		Button bt_main = (Button)findViewById(R.id.MainList);
		bt_main.setText("Main List : " + intWordsCount_Main);
		if(intWordsCount_Main>0) bt_main.setEnabled(true);
		else bt_main.setEnabled(false);
		
		Button bt_ML = (Button)findViewById(R.id.MyList);
		bt_ML.setText("My List : " + intWordsCount_ML);
		if(intWordsCount_ML>0) bt_ML.setEnabled(true);
		else bt_ML.setEnabled(false);			
		
		Button bt_LL = (Button)findViewById(R.id.LearningList);
		bt_LL.setText("Learning List : " + intWordsCount_LL);
		if(intWordsCount_LL>0) bt_LL.setEnabled(true);
		else bt_LL.setEnabled(false);
		
		Button bt_TL = (Button)findViewById(R.id.ToughList);
		bt_TL.setText("Tough List : " + intWordsCount_TL);
		if(intWordsCount_TL>0) bt_TL.setEnabled(true);
		else bt_TL.setEnabled(false);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
//	public void ShowMasterList(View v){
//		try{
//		Toast.makeText(this, "Show MASTER WORD LIST",LENGTH_SHORT).show();
//		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
//		NewINt.putExtra(LISTNAME, "MasterWordList");
//		startActivity(NewINt);
//		}
//		catch(Exception e){
//			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
//		}
		//Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	//}
	
		public int getRecordCountMA(String strQuery){		
			int intTemp = 0;		
			Cursor csr = wp.getAllWords(strQuery);
			if(csr.moveToFirst()){
			intTemp = csr.getInt(csr.getColumnIndex("Count"));
			}
			csr.close();		
			return intTemp;
		}
	public void ShowMasterList(View v){
		try{
		Toast.makeText(this, "Show MASTER WORD LIST",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),Select_Alphabet.class);
		NewINt.putExtra(LISTNAME, "MasterWordList");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
	}
	public void ShowMyList(View v){
		try{
		Toast.makeText(this, "Show MY WORD LIST",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "MyList");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		//Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	
	public void ShowLearningList(View v){
		try{
		Toast.makeText(this, "Show Learning LIST",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "LearningList");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		//Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	
	public void ShowToughList(View v){
		try{
		Toast.makeText(this, "Show Tough LIST",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),MainList.class);
		NewINt.putExtra(LISTNAME, "ToughList");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		//Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	
	public void ShowTestSetting(View v){
		try{
	//	Toast.makeText(this, "Show MY WORD LIST",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),TestSetting.class);
		//NewINt.putExtra(LISTNAME, "MyList");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		//Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	
	public void ShowExamSetting(View v){
		try{
	//	Toast.makeText(this, "Show MY WORD LIST",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),ExamSetting.class);
		//NewINt.putExtra(LISTNAME, "MyList");
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		//Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}
	
	public void ShowStats(View v){
		try{
	//	Toast.makeText(this, "Show MY WORD LIST",LENGTH_SHORT).show();
		Intent NewINt = new Intent(getApplicationContext(),Stats.class);
		NewINt.putExtra(STATSFROMMAINPAGE, true);
		startActivity(NewINt);
		}
		catch(Exception e){
			Toast.makeText(this, e.getMessage(),LENGTH_SHORT).show();
		}
		//Toast.makeText(this, "Show Main list button is clicked",LENGTH_SHORT).show();
	}

}
