package SpeechToText03;

import java.io.File;
import java.io.FileNotFoundException;

import com.ibm.cloud.sdk.core.service.security.IamOptions;
import com.ibm.watson.speech_to_text.v1.SpeechToText;
import com.ibm.watson.speech_to_text.v1.model.RecognizeOptions;
import com.ibm.watson.speech_to_text.v1.model.SpeechRecognitionResults;

public class SpeechToText03_main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SpeechToText service = new SpeechToText();
	    IamOptions options = new IamOptions.Builder()
	        .apiKey("ITSSECRET!!")
	        .build();
	    service.setIamCredentials(options);

	    File audio = new File("src/test/resources/speech_to_text/Drill4.mp3");
	    RecognizeOptions options1 = null;
		try {
			options1 = new RecognizeOptions.Builder()
					.audio(audio)
					.contentType(RecognizeOptions.ContentType.AUDIO_MP3)
					//.model("ja-JP_BroadbandModel")
					.build();

		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	    SpeechRecognitionResults transcript = service.recognize(options1).execute().getResult();

	    System.out.println(transcript);

	}

}
