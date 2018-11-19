package onlineC;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String proUrl = "<?xml version=\"1.0\" encoding=\"utf-8\"?><queue-answer>  <status> <directDownload>http://www5.online-convert.com/download-file/6d17c92ee8965629d53f182ac33579e0</directDownload>   <code>100</code>    <message>The file has been successfully converted.</message>  </status>  <params>    <downloadCounter>0</downloadCounter>    <dateProcessed>1433245120</dateProcessed>        <source_checksum>a3c8700592c5ffdf37891d833b1b7f73</source_checksum>    <checksum>1f29efe08716175804fae160d2eee6b9</checksum>    <target_size>1</target_size>    <convert_to>txt</convert_to>    <mime_type>text/plain</mime_type>    <hash>6d17c92ee8965629d53f182ac33579e0</hash>  </params></queue-answer>";
        String dUrl = proUrl.substring(proUrl.indexOf("<directDownload>")+16, proUrl.indexOf("</directDownload>"));
        System.out.println(dUrl);
	}

}
