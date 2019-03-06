package site.asem.model.entity;

import java.util.List;

public class WebArticle extends Publication {
    private String url;

    public WebArticle(String title,
                      String udcID,
                      List<String> authors,
                      long pagesQuantity,
                      int publishYear,
                      List<String> tags,
                      List<Publication> references,
                      String url) {
        super(title, udcID, authors, pagesQuantity, publishYear, tags, references);
        this.url = url;
    }
}
