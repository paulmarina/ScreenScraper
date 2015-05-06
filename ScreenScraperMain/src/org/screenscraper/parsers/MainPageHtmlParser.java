package org.screenscraper.parsers;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.screenscraper.objects.*;

public class MainPageHtmlParser {

	public List<CompanyUrl> parse(String html){
		List<CompanyUrl> urls = new ArrayList<CompanyUrl>();
		
		// get xml representation of html
		Document doc = Jsoup.parse(html);
		
		List<Element> elements = doc.getElementsByClass("company-name");
		for (Element element : elements) {
			CompanyUrl companyUrl = new CompanyUrl();
			Node aChild = element.childNode(0).childNode(0);
			String url = "https://www.wlw.de/" + aChild.attr("href");
			companyUrl.setUrl(url);
			String name = aChild.toString();
			companyUrl.setName(name);
		}


			/*// tags were found
			if (el.nodeName().equals("title")) {
				titleStatus = Constants.OkStatusString;
			} else if (el.nodeName().equals("metaname=\"description\"")) {
				descriptionStatus = Constants.OkStatusString;
			} else if (el.nodeName().equals("metaname=\"keywords\"")) {
				keywordsStatus = Constants.OkStatusString;
			}*/
		
		return urls;
	}
}
