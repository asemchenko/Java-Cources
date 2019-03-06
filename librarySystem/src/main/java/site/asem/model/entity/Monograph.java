package site.asem.model.entity;

import java.util.List;

public class Monograph extends Publication {
    private String isbn;
    private String publisher;
    private long circulation;

    public Monograph(String title,
                     String udcID,
                     List<String> authors,
                     long pagesQuantity,
                     int publishYear,
                     List<String> tags,
                     List<Publication> references,
                     String isbn,
                     String publisher,
                     long circulation) {
        super(title,
                udcID,
                authors,
                pagesQuantity,
                publishYear,
                tags,
                references);
        this.isbn = isbn;
        this.publisher = publisher;
        this.circulation = circulation;
    }


}
