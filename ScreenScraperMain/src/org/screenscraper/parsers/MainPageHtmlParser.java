package org.screenscraper.parsers;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.screenscraper.objects.*;

public class MainPageHtmlParser {

	public List<CompanyUrl> parse(String html){
		List<CompanyUrl> urls = new ArrayList<CompanyUrl>();
		
		// get xml representation of html
		Document doc = Jsoup.parse(html);
		
		Elements nodeList = doc.getAllElements();
		
		List<Element> elements = doc.getElementsByClass("company-name");
		for (Element element : elements) {
			String str = element.baseUri();
			String s = str;
		}
		
		for (int i = 0; i < nodeList.size(); i++) {
			Element el = nodeList.get(i);
			String s = el.baseUri();
			String str = "da" + s;


			/*// tags were found
			if (el.nodeName().equals("title")) {
				titleStatus = Constants.OkStatusString;
			} else if (el.nodeName().equals("metaname=\"description\"")) {
				descriptionStatus = Constants.OkStatusString;
			} else if (el.nodeName().equals("metaname=\"keywords\"")) {
				keywordsStatus = Constants.OkStatusString;
			}*/
		}
		
		return urls;
	}
}
