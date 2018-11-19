package onlineC;

/*
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
import java.io.File;
import java.net.URL;
import onlineconvert.*;
import org.apache.commons.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class Demo {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception 
    {
        
    	String fileName = "Desolution.mp3";
    	String type = "convert-to-aac";
    	String outputFile = "des.aac";
        File file = new File(fileName);
        String filePath = file.getAbsolutePath();

        OnlineConvert oc = OnlineConvert.create("41dca1c1104d588130b08e96b6f47f78", false);
        System.out.println("Inserting job in server...\n\n");
        System.out.println(oc.convert(type, OnlineConvert.SOURCE_TYPE_FILE_PATH, filePath , fileName, null, ""));
        System.out.println("\n\nJob Inserted in server...\n\n\n\n");

        System.out.println("Getting inserted job status on server...\n\n");
        System.out.println(oc.getProgress());
        System.out.println("\n\nStatus of inserted job on server is above...\n\n\n\n");

        System.out.println("===================================================\n");
        System.out.println("HASH :-" + oc.getHash());
        System.out.println("Download URL  :- " + oc.getDownloadUrl());
        System.out.println("===================================================\n\n");

        System.out.println("\n\nNow deleting the file  from server...\n\n");
        //System.out.println(oc.deleteFile());
        System.out.println("The file has been deleted from server...\n\n\n\n");
        
        String t = null;
        while(t==null)
        {
        	Document doc = Jsoup.connect(oc.getDownloadUrl().replace("result", "download-try")).timeout(10000).get();
            System.out.println(oc.getDownloadUrl().replace("result", "download-try"));
        	Element dLinks = doc.select("#download_box strong a").first();
        	try
        	{
        		t = dLinks.attr("href");
        	}
        	catch(Exception e)
        	{
        		System.out.println("Exception");
        	}
        }
        System.out.println(t);
        
        String proUrl = oc.getProgress();
        System.out.println(proUrl);
        String dUrl = proUrl.substring(proUrl.indexOf("<directDownload>")+16, proUrl.indexOf("</directDownload>"));
        
        
        //FileUtils.copyURLToFile(new URL(dUrl), new File(outputFile));
    }

}
