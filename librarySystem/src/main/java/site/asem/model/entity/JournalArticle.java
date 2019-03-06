package site.asem.model.entity;

import java.util.List;

public class JournalArticle extends Publication {
    private String journal;
    private String issn;
    private int page;

    public JournalArticle(String title,
                          String udcID,
                          List<String> authors,
                          long pagesQuantity,
                          int publishYear,
                          List<String> tags,
                          List<Publication> references,
                          String journal,
                          String issn,
                          int page) {
        super(title, udcID, authors, pagesQuantity, publishYear, tags, references);
        this.journal = journal;
        this.issn = issn;
        this.page = page;
    }
}
