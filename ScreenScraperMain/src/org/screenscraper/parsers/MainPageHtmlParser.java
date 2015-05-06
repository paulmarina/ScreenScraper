package org.screenscraper.parsers;

import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.screenscraper.objects.*;

public class MainPageHtmlParser {

	Map<String, String> germanCharacters = new HashMap<String, String>() {
		{
			put("Ã¼", "ü");
			put("Ã¤", "ä");
			put("ÃŸ", "ß");
			put("Ã¶", "ö");
		}
	};

	public List<CompanyUrl> parse(String html) {
		List<CompanyUrl> urls = new ArrayList<CompanyUrl>();

		// get xml representation of html
		Document doc = Jsoup.parse(html);

		List<Element> elements = doc.getElementsByClass("company-name");
		for (Element element : elements) {
			// get the <a href=""> element with company name
			Element aChild = element.child(0).child(0);
			String url = "https://www.wlw.de/" + aChild.attr("href");
			String name = aChild.text();
			
			// replace special characters with german characters
/*			for (String character : germanCharacters) {
				
			}*/

			CompanyUrl companyUrl = new CompanyUrl();
			companyUrl.setUrl(url);
			companyUrl.setName(name);
			urls.add(companyUrl);
		}

		return urls;
	}
}
