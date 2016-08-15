package synchronizedkeyword;

import java.util.ArrayList;
import java.util.List;

/*
 * synchronized keyword to protect blocks of code
 * 
 * only one thread can access the inner block of the add() and next() methods.
 */

public class CrawledSites {
	private List<String> crawledSites = new ArrayList<String>();
	private List<String> linkedSites = new ArrayList<String>();

	public void add(String site) {
		synchronized (this) {
			if (!crawledSites.contains(site)) {
				linkedSites.add(site);
			}
			for(int i=0; i< 3; i++){
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * Get next site to crawl. Can return null (if nothing to crawl)
	 */

	public String next() {
		if (linkedSites.size() == 0) {
			return null;
		}
		synchronized (this) {
			for(int i=0; i< 3; i++){
				try {
					Thread.sleep(400);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			// Need to check again if size has changed
			if (linkedSites.size() > 0) {
				String s = linkedSites.get(0);
				linkedSites.remove(0);
				crawledSites.add(s);
				return s;
			}
			
			return null;
		}
	}

}
